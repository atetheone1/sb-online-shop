package tech.atetheone.sb_online_shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.atetheone.sb_online_shop.domain.Customer;
import tech.atetheone.sb_online_shop.domain.Order;
import tech.atetheone.sb_online_shop.domain.Product;
import tech.atetheone.sb_online_shop.domain.Item;
import tech.atetheone.sb_online_shop.repository.CustomerRepository;
import tech.atetheone.sb_online_shop.repository.ItemRepository;
import tech.atetheone.sb_online_shop.repository.OrderRepository;
import tech.atetheone.sb_online_shop.repository.ProductRepository;

import java.util.Arrays;

@SpringBootApplication
public class SbOnlineShopApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(SbOnlineShopApplication.class);
	private final CustomerRepository customerRepository;
	private final OrderRepository orderRepository;
  private final ItemRepository itemRepository;
  private final ProductRepository productRepository;

public SbOnlineShopApplication(
        CustomerRepository customerRepository,
        OrderRepository orderRepository,
        ItemRepository itemRepository,
        ProductRepository productRepository
) {
		this.customerRepository = customerRepository;
		this.orderRepository = orderRepository;
    this.itemRepository = itemRepository;
    this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SbOnlineShopApplication.class, args);
		logger.info("Spring Boot online shop application started successfully at http://localhost:8080");
	}

	@Override
	public void run(String... args) throws Exception {
    // Create some customers
		Customer c1 = new Customer("Bugs Bunny", "New York", "user",  59000);
		Customer c2 = new Customer("Daffy Duck", "Los Angeles", "user", 37000);
		Customer c3 = new Customer("Porky Pig", "Miami", "user", 28000 );
    customerRepository.saveAll(Arrays.asList(c1,c2, c3));

    Order o1 = new Order(c1);
		Order o2 = new Order(c1);
		Order o3 = new Order(c2);
		Order o4 = new Order(c3);
    orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));

    // Create a product
    Product p1 = new Product("Banana", "Yellow fruit", "banana.jpg", 200);
    Product p2 = new Product("Apple", "Red fruit", "apple.jpg", 250);
    productRepository.saveAll(Arrays.asList(p1, p2));

    // Create an item
    Item i1 = new Item(2, 200, o1, p1);
    Item i2 = new Item(3, 300, o2, p2);

    itemRepository.saveAll(Arrays.asList(i1, i2));


		System.out.println("----- All Orders ------");

    for (Order o : orderRepository.findAll()) {
      System.out.println("Order: " + o.getId() + ", Customer: " + o.getCustomer().getFullname() + ", Total: " + o.getTotal() + "$");

      for (Item item : o.getItems()) {
        System.out.println("\tItem: " + item.getProduct().getName() + ", Quantity: " + item.getQuantity() + ", Price: " + item.getPrice());
      }

      System.out.println("-----             ------");
    }
		System.out.println("-----             ------");

	}
}
