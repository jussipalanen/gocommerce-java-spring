package golbot.gocommerce;

import java.util.ArrayList;
import java.util.List;

import golbot.gocommerce.model.Customer;

public class CustomCustomerRepository {
    

    public static Customer get(int id)
    {
        Customer customer1 = new Customer();
        customer1.setFirstname("Jesse");
        customer1.setLastname("Moilanen");
        return customer1;
    }

    public static List<Customer> all()
    {
        List<Customer> customers = new ArrayList<Customer>();
        Customer customer1 = new Customer();
        customer1.setFirstname("Jesse");
        customer1.setLastname("Moilanen");
        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstname("Anna");
        customer2.setLastname("Tolvanen");
        customers.add(customer2);
        return customers;
    }

}
