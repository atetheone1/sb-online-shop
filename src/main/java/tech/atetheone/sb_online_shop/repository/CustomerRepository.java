package tech.atetheone.sb_online_shop.repository;

import org.springframework.data.repository.CrudRepository;
import tech.atetheone.sb_online_shop.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
