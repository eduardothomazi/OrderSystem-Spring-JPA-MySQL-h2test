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


	public static void main(String[] args) {
		SpringApplication.run(EduardoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Category cat1 = new Category(null, "Computers");
		Category cat2 = new Category(null, "Office");

		Product p1 = new Product(null, "Computer", 2000.00);
		Product p2 = new Product(null, "Printer", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);

		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().add(p2);
		p1.getCategoryList().add(cat1);
		p2.getCategoryList().addAll(Arrays.asList(cat1,cat2));
		p3.getCategoryList().add(cat1);

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));

		State s1 = new State(null, "Minas Gerais");
		State s2 = new State(null, "São Paulo");

		City c1 = new City(null,"Uberlândia", s1);
		City c2 = new City(null, "São Paulo", s2);
		City c3 = new City(null, "Campinas", s2);

		s1.getCities().add(c1);
		s2.getCities().addAll(Arrays.asList(c2,c3));

		stateRepository.saveAll(Arrays.asList(s1,s2));
		cityRepository.saveAll(Arrays.asList(c1,c2,c3));

		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PERSON);
		cli1.getPhones().addAll(Arrays.asList("27363323","93838393"));

		Address e1 = new Address(null, "Rua Flores","300","Apto 203","Jardim","38220834", cli1, c1);
		Address e2 = new Address(null, "Avenida Matos","105","Sala 800","Centro","38777020", cli1, c2);

		cli1.getAddresses().add(e1);
		cli1.getAddresses().add(e2);

		clientRepository.save(cli1);

		addressRepository.saveAll(Arrays.asList(e1,e2));

		OrderClass o1 = new OrderClass(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		OrderClass o2 = new OrderClass(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		orderRepository.save(o1);
		orderRepository.save(o2);

		Payment pay1 = new CardPayment(null, PaymentStatus.PAYED, o1, 6);
		o1.setPayment(pay1);

		Payment pay2 = new ProgrammedPayment(null, PaymentStatus.PENDENT, o2, sdf.parse("20/10/2017 00:00"),null);
		o2.setPayment(pay2);

		orderRepository.save(o1);
		orderRepository.save(o2);

		cli1.getOrders().addAll(Arrays.asList(o1,o2));

	}
}
