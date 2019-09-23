package ir.shayandaneshvar.jottery.controllers;

import ir.shayandaneshvar.jottery.models.Lottery;
import ir.shayandaneshvar.jottery.repositories.CustomerRepository;
import ir.shayandaneshvar.jottery.repositories.PrizeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class LotteryController {
    private Lottery lottery;
    private PrizeRepository prizeRepository;
    private CustomerRepository customerRepository;
    @GetMapping({"/lottery", "/lotto"})
    public String loadLottery(Model model) {
        model.addAttribute(lottery);
        return "lottery";
    }
    
    @PostMapping("/doTheLottery")
    public String action(@ModelAttribute Lottery myLottery,Model model){
        myLottery.getPrizes().addAll(prizeRepository.findAll());
        myLottery.generateLots(customerRepository.findAll());
        myLottery.start();
        return "redirect:/results";
    }
    
    @GetMapping({"/results","result"})
    public String showResult(){
        // TODO: 9/22/19  
        return "result";
    }
}
