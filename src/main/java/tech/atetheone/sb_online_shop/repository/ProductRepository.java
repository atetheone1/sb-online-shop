package tech.atetheone.sb_online_shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tech.atetheone.sb_online_shop.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
