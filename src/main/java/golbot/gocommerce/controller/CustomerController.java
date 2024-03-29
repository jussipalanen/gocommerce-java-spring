package golbot.gocommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import golbot.gocommerce.model.Customer;
import golbot.gocommerce.repositories.CustomerRepository;
import golbot.gocommerce.resources.ResourceNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
public class CustomerController
{
    @Autowired
    private CustomerRepository customerRepo;

    @GetMapping("/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable(required = true, name = "id") Integer id) throws ResourceNotFoundException 
    {
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        return ResponseEntity.ok().body(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers()
    {
        return (List<Customer>) customerRepo.findAll();
    }    

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@Validated @RequestBody Customer customer)
    {
        return ResponseEntity.ok().body(customerRepo.save(customer));
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Integer id, @Validated @RequestBody Customer customerDetails) throws ResourceNotFoundException
    {
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        if( customerDetails.getFirstname() != null ) { customer.setFirstname( customerDetails.getFirstname() ); }
        if( customerDetails.getLastname() != null ) { customer.setLastname( customerDetails.getLastname() ); }
        if( customerDetails.getEmail() != null ) { customer.setEmail( customerDetails.getEmail() ); }
        if( customerDetails.getPhone() != null ) { customer.setPhone( customerDetails.getPhone() ); }
        if( customerDetails.getPostalCode() != null ) { customer.setPostalCode( customerDetails.getPostalCode() ); }
        final Customer updatedCustomer = customerRepo.save( customer );
        return ResponseEntity.ok().body(updatedCustomer);
    }
}