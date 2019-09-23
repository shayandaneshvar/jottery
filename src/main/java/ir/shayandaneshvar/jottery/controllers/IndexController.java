package ir.shayandaneshvar.jottery.controllers;

import ir.shayandaneshvar.jottery.commands.LevelCommand;
import ir.shayandaneshvar.jottery.exceptions.NotFoundException;
import ir.shayandaneshvar.jottery.models.Customer;
import ir.shayandaneshvar.jottery.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequiredArgsConstructor
public class IndexController {
    private final CustomerRepository customerRepository;

    @GetMapping({"", "/", "/index"})
    public String loadHome() {
        return "index";
    }

//    @RequestMapping("/error")
//    public String handleNotFound() {
//        return "404error";
//    }
}
