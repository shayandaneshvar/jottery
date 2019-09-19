package ir.shayandaneshvar.jottery.controllers;

import ir.shayandaneshvar.jottery.commands.LevelCommand;
import ir.shayandaneshvar.jottery.models.Customer;
import ir.shayandaneshvar.jottery.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final CustomerRepository customerRepository;

    @GetMapping({"", "/", "/index"})
    public String loadHome() {
        return "index";
    }

//    @PostMapping("/form")
//    public String handleSubmit(@ModelAttribute Customer customer,Model model){
//        return "sub";
//    }
}
