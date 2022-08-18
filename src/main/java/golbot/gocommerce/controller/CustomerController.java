package golbot.gocommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import golbot.gocommerce.model.Customer;
import golbot.gocommerce.repositories.CustomerRepository;

@RestController
@RequestMapping("api/v1")
public class CustomerController
{
    @Autowired
    private CustomerRepository customerRepo;
    @GetMapping(path = {"/customer", "/customer/{id}"})
    public ResponseEntity getCustomer(@PathVariable(required = true, name = "id") Integer id)
    {
        Optional<Customer> customer = customerRepo.findById(id);
        return ResponseEntity.ok().body(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers()
    {
        return customerRepo.findAll();
    }    
}