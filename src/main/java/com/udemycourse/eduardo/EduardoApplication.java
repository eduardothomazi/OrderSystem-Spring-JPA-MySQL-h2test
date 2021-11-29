package com.udemycourse.eduardo;

import com.udemycourse.eduardo.entities.Category;
import com.udemycourse.eduardo.entities.City;
import com.udemycourse.eduardo.entities.Product;
import com.udemycourse.eduardo.entities.State;
import com.udemycourse.eduardo.repositories.CategoryRepository;
import com.udemycourse.eduardo.repositories.CityRepository;
import com.udemycourse.eduardo.repositories.ProductRepository;
import com.udemycourse.eduardo.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

	public static void main(String[] args) {
		SpringApplication.run(EduardoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
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


	}
}
