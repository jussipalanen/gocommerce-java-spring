package golbot.gocommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import golbot.gocommerce.SiteConfig;
import golbot.gocommerce.model.Customer;
import golbot.gocommerce.repositories.CustomerRepository;

@Controller
public class SiteController
{

    @Autowired
    CustomerRepository customerRepo;
    SiteConfig siteConfig;
    public String apiURL = "http://localhost:9000/api/v1";

    /**
     * @param model
     * @return
     */
    @GetMapping(value = "/")
    public String index(Model model)
    {
        model.addAttribute("title", SiteConfig.getTitle());
        model.addAttribute("appConfig", SiteConfig.getAppConfigAsJson());
        return "index";
    } 

    @GetMapping(value = "/customers")
    public String viewCustomers(Model model)
    {
        // Get list of the customers
        List<Customer> customers = (List<Customer>) customerRepo.findAll();

        SiteConfig.setTitle("Customers");
        model.addAttribute("title", SiteConfig.getTitle());
        model.addAttribute("appConfig", "lal");
        model.addAttribute("customers", customers);
        return "customers";
    } 

    @GetMapping(value = "/customers/add")
    public String addCustomer(Model model)
    {
        return "fragments/customers/add";
    } 

}