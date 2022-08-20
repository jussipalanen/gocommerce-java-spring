package golbot.gocommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController
{
    /**
     * @param model
     * @return
     */
    @GetMapping(value = "/")
    public String index(Model model)
    {
        model.addAttribute("title", "Main page");
        return "index";
    } 

    @GetMapping(value = "/customers")
    public String viewCustomers(Model model)
    {
        return "customers";
    } 

    @GetMapping(value = "/customers/add")
    public String addCustomer(Model model)
    {
        return "fragments/customers/add";
    } 

}