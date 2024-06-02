package tech.atetheone.sb_online_shop.repository;

import org.springframework.data.repository.CrudRepository;
import tech.atetheone.sb_online_shop.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
