package com.udemycourse.eduardo;

import com.udemycourse.eduardo.entities.*;
import com.udemycourse.eduardo.entities.enums.ClientType;
import com.udemycourse.eduardo.entities.enums.PaymentStatus;
import com.udemycourse.eduardo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class EduardoApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;


	public static void main(String[] args) {
		SpringApplication.run(EduardoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Category category1 = new Category(null, "Computers");
		Category category2 = new Category(null, "Office");

		Product product1 = new Product(null, "Computer", 2000.00);
		Product product2 = new Product(null, "Printer", 800.00);
		Product product3 = new Product(null, "Mouse", 80.00);

		category1.getProducts().addAll(Arrays.asList(product1,product2,product3));
		category2.getProducts().add(product2);
		product1.getCategoryList().add(category1);
		product2.getCategoryList().addAll(Arrays.asList(category1,category2));
		product3.getCategoryList().add(category1);

		categoryRepository.saveAll(Arrays.asList(category1, category2));
		productRepository.saveAll(Arrays.asList(product1,product2,product3));

		State state1 = new State(null, "Minas Gerais");
		State state2 = new State(null, "São Paulo");

		City city1 = new City(null,"Uberlândia", state1);
		City city2 = new City(null, "São Paulo", state2);
		City city3 = new City(null, "Campinas", state2);

		state1.getCities().add(city1);
		state2.getCities().addAll(Arrays.asList(city2,city3));

		stateRepository.saveAll(Arrays.asList(state1,state2));
		cityRepository.saveAll(Arrays.asList(city1,city2,city3));

		Client client1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PERSON);
		client1.getPhones().addAll(Arrays.asList("27363323","93838393"));

		Address address1 = new Address(null, "Rua Flores","300","Apto 203","Jardim","38220834", client1, city1);
		Address address2 = new Address(null, "Avenida Matos","105","Sala 800","Centro","38777020", client1, city2);

		client1.getAddresses().add(address1);
		client1.getAddresses().add(address2);

		clientRepository.save(client1);

		addressRepository.saveAll(Arrays.asList(address1,address2));

		OrderClass order1 = new OrderClass(null, sdf.parse("30/09/2017 10:32"), client1, address1);
		OrderClass order2 = new OrderClass(null, sdf.parse("10/10/2017 19:35"), client1, address2);

		orderRepository.save(order1);
		orderRepository.save(order2);

		Payment pay1 = new CardPayment(null, PaymentStatus.PAYED, order1, 6);
		order1.setPayment(pay1);

		Payment pay2 = new ProgrammedPayment(null, PaymentStatus.PENDENT, order2, sdf.parse("20/10/2017 00:00"),null);
		order2.setPayment(pay2);

		orderRepository.save(order1);
		orderRepository.save(order2);

		client1.getOrders().addAll(Arrays.asList(order1,order2));

		OrderItem orderItem1 = new OrderItem(order1,product1,0.00,1,2000.00);
		OrderItem orderItem2 = new OrderItem(order1,product3,0.00,2,80.00);

		OrderItem orderItem3 = new OrderItem(order2,product2,100.00,1,800.00);

		order1.getItems().addAll(Arrays.asList(orderItem1,orderItem2));
		order2.getItems().addAll(Arrays.asList(orderItem3));

		product1.getProducts().addAll(Arrays.asList(orderItem1));
		product2.getProducts().addAll(Arrays.asList(orderItem3));
		product3.getProducts().addAll(Arrays.asList(orderItem2));

		orderItemRepository.saveAll(Arrays.asList(orderItem1,orderItem2,orderItem3));




	}
}
