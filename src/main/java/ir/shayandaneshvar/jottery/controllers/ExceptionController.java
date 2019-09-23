package ir.shayandaneshvar.jottery.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController implements ErrorController {
    @RequestMapping("/error")
    public String handleError() {
        return "404error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}

