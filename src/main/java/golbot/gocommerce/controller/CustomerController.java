package golbot.gocommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import golbot.gocommerce.CustomerRepository;
import golbot.gocommerce.model.Customer;

@RestController
public class CustomerController
{
    @GetMapping(path = {"/customer", "/customer/{id}"})
    public Customer customer(@PathVariable(required = true, name = "id") long id)
    {

        Customer customer = CustomerRepository.get(1);
        return customer;
    }

    @GetMapping("/customers")
    public List<Customer> customers()
    {

        List<Customer> customers = CustomerRepository.all();
        return customers;
    }    
}