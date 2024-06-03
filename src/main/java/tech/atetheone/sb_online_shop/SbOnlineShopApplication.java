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

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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
		List<Customer> customers = Arrays.asList(
						Customer.builder()
										.fullname("Bugs Bunny")
										.password("New York")
										.role("user")
										.balance(59000)
										.createdAt(LocalDateTime.now())
										.updatedAt(LocalDateTime.now())
										.build(),
						Customer.builder()
										.fullname("Daffy Duck")
										.password("Los Angeles")
										.role("user")
										.balance(37000)
										.createdAt(LocalDateTime.now())
										.updatedAt(LocalDateTime.now())
										.build(),
						Customer.builder()
										.fullname("Porky Pig")
										.password("Miami")
										.role("user")
										.balance(28000)
										.createdAt(LocalDateTime.now())
										.updatedAt(LocalDateTime.now())
										.build()
		);

		customerRepository.saveAll(customers);

		// Create some orders
		List<Order> orders = Arrays.asList(
						Order.builder()
										.customer(customers.get(0))
										.createdAt(LocalDateTime.now())
										.updatedAt(LocalDateTime.now())
										.build(),
						Order.builder()
										.customer(customers.get(0))
										.createdAt(LocalDateTime.now())
										.updatedAt(LocalDateTime.now())
										.build(),
						Order.builder()
										.customer(customers.get(1))
										.createdAt(LocalDateTime.now())
										.updatedAt(LocalDateTime.now())
										.build(),
						Order.builder()
										.customer(customers.get(2))
										.createdAt(LocalDateTime.now())
										.updatedAt(LocalDateTime.now())
										.build()
		);
		orderRepository.saveAll(orders);

		// Create a product
		Product shirt = Product.builder()
						.name("Shirt")
						.description("Nice shirt")
						.image("shirt.jpg")
						.price(200)
						.createdAt(LocalDateTime.now())
						.updatedAt(LocalDateTime.now())
						.build();

		Product phone = Product.builder()
						.name("Phone")
						.description("Smartphone")
						.image("phone.jpg")
						.price(200)
						.createdAt(LocalDateTime.now())
						.updatedAt(LocalDateTime.now())
						.build();

		Product tv = Product.builder()
						.name("TV")
						.description("Smart TV")
						.image("tv.jpg")
						.price(300)
						.createdAt(LocalDateTime.now())
						.updatedAt(LocalDateTime.now())
						.build();

		Product shoes = Product.builder()
						.name("Shoes")
						.description("Running shoes")
						.image("shoes.jpg")
						.price(300)
						.createdAt(LocalDateTime.now())
						.updatedAt(LocalDateTime.now())
						.build();

		productRepository.saveAll(Arrays.asList(shirt, phone, tv, shoes));


		// Create items
		List<Item> items = Arrays.asList(
						Item.builder()
										.quantity(2)
										.price(shirt.getPrice())
										.order(orders.get(0))
										.product(shirt)
										.createdAt(LocalDateTime.now())
										.updatedAt(LocalDateTime.now())
										.build(),
						Item.builder()
										.quantity(1)
										.price(phone.getPrice())
										.order(orders.get(1))
										.product(phone)
										.build(),
						Item.builder()
										.quantity(1)
										.price(tv.getPrice())
										.order(orders.get(1))
										.product(tv)
										.createdAt(LocalDateTime.now())
										.updatedAt(LocalDateTime.now())
										.build(),
						Item.builder()
										.quantity(1)
										.price(shoes.getPrice())
										.order(orders.get(1))
										.product(shoes)
										.createdAt(LocalDateTime.now())
										.updatedAt(LocalDateTime.now())
										.build(),
						Item.builder()
										.quantity(1)
										.price(tv.getPrice())
										.order(orders.get(2))
										.product(tv)
										.createdAt(LocalDateTime.now())
										.updatedAt(LocalDateTime.now())
										.build(),
						Item.builder()
										.quantity(1)
										.price(phone.getPrice())
										.order(orders.get(2))
										.product(phone)
										.createdAt(LocalDateTime.now())
										.updatedAt(LocalDateTime.now())
										.build(),
						Item.builder()
										.quantity(1)
										.price(shoes.getPrice())
										.order(orders.get(2))
										.product(shoes)
										.createdAt(LocalDateTime.now())
										.updatedAt(LocalDateTime.now())
										.build(),
						Item.builder()
										.quantity(1)
										.price(tv.getPrice())
										.order(orders.get(3))
										.product(tv)
										.createdAt(LocalDateTime.now())
										.updatedAt(LocalDateTime.now())
										.build(),
						Item.builder()
										.quantity(1)
										.price(shirt.getPrice())
										.order(orders.get(3))
										.product(shirt)
										.createdAt(LocalDateTime.now())
										.updatedAt(LocalDateTime.now())
										.build()
		);
		itemRepository.saveAll(items);

		// Print all orders
		System.out.println("----- All Orders ------");
		for (Order o : orderRepository.findAll()) {
			System.out.println("Order ID: " + o.getId() + " - Total: " + o.getTotal() + "$ - Customer: " + o.getCustomer().getFullname());
			for (Item item : o.getItems()) {
				System.out.println("\tItem: " + item.getQuantity() + " x " + item.getProduct().getName() + " (" + item.getProduct().getPrice() + "$)");
			}
		}
		System.out.println("-----             ------");
	}
}
