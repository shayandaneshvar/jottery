package ir.shayandaneshvar.jottery.controllers;

import ir.shayandaneshvar.jottery.models.Lottery;
import ir.shayandaneshvar.jottery.repositories.CustomerRepository;
import ir.shayandaneshvar.jottery.repositories.PrizeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class LotteryController {
    private Lottery lottery;
    private PrizeRepository prizeRepository;
    private CustomerRepository customerRepository;

    @GetMapping({"/lottery", "/lotto"})
    public String loadLottery(Model model) {
        model.addAttribute("lottery", lottery);
        return "lottery";
    }

    @PostMapping("/doTheLottery")
    public String action(@ModelAttribute Lottery myLottery, Model model) {
        myLottery.getPrizes().addAll(prizeRepository.findAll());
        System.out.println("Offset :" + myLottery.getOffset());
//        customerRepository.findAll().stream().map(x -> x.getId()).forEach(System.out::println);
        myLottery.setCustomerRepository(customerRepository);
        myLottery.start(customerRepository.findAll());
        return "redirect:/results";
    }

    @GetMapping({"/results", "result"})
    public String showResult(Model model) {
        model.addAttribute("winners", customerRepository.findAll().stream()
                .filter(x -> x.getPrize() != null).peek(z -> System.out.println(z.getPrize())).collect(Collectors.toList()));
        return "result";
    }
}
