package golbot.gocommerce.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import golbot.gocommerce.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    
}
