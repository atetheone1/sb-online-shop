package tech.atetheone.sb_online_shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.atetheone.sb_online_shop.domain.Customer;
import tech.atetheone.sb_online_shop.domain.Order;
import tech.atetheone.sb_online_shop.repository.CustomerRepository;
import tech.atetheone.sb_online_shop.repository.OrderRepository;

import java.util.Arrays;

@SpringBootApplication
public class SbOnlineShopApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(SbOnlineShopApplication.class);
	private final CustomerRepository customerRepository;
	private final OrderRepository orderRepository;

public SbOnlineShopApplication(CustomerRepository customerRepository, OrderRepository orderRepository) {
		this.customerRepository = customerRepository;
		this.orderRepository = orderRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SbOnlineShopApplication.class, args);
		logger.info("Spring Boot online shop application started successfully at http://localhost:8080");
	}

	@Override
	public void run(String... args) throws Exception {
		Customer c1 = new Customer("Bugs Bunny", "New York", 59000);
		Customer c2 = new Customer("Daffy Duck", "Los Angeles", 37000);
		Customer c3 = new Customer("Porky Pig", "Miami", 28000 );
		customerRepository.saveAll(Arrays.asList(c1,c2, c3));

		Order o1 = new Order(100, c1);
		Order o2 = new Order(300, c1);
		Order o3 = new Order(200, c2);
		Order o4 = new Order(140, c3);
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));

		int i_order = 0;
		System.out.println("----- All Orders ------");

		for (Order o : orderRepository.findAll()) {
			i_order++;

			System.out.print("order_"+i_order+" \t "+o.getCustomer().getFullname()+"\t "+o.getTotal()+"$");

			System.out.println(" ");
		}
		System.out.println("-----             ------");

	}
}
