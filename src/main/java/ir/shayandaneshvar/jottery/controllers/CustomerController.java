package ir.shayandaneshvar.jottery.controllers;

import ir.shayandaneshvar.jottery.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    public final CustomerRepository customerRepository;

    @GetMapping({"/customers/{page}","/people/{page}","/individuals/{page}"})
    public String getCustomers(@PathVariable String page, Model model){
        model.addAttribute("customers",customerRepository.findAll(PageRequest.of(Integer.parseInt(page) - 1,50)));
        return "customers";
    }
    @GetMapping({"/customers","/people","/individuals"})
    public String getCustomers(){
        return "redirect:/customers/1";
    }
}
