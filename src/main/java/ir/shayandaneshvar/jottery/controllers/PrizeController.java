package ir.shayandaneshvar.jottery.controllers;

import ir.shayandaneshvar.jottery.commands.LevelCommand;
import ir.shayandaneshvar.jottery.commands.PrizeCommand;
import ir.shayandaneshvar.jottery.models.Prize;
import ir.shayandaneshvar.jottery.repositories.LevelRepository;
import ir.shayandaneshvar.jottery.services.LevelService;
import ir.shayandaneshvar.jottery.services.PrizeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PrizeController {
    private final PrizeService prizeService;
    private final LevelRepository levelRepository;

    @GetMapping({"/prize", "/prizes", "/prz"})
    public String loadPrizes(Model model) {
        model.addAttribute("prize", new PrizeCommand());
        model.addAttribute("levels", levelRepository.findAll());
        model.addAttribute("prizes", prizeService.getPrizeRepository().findAll().stream().map(x ->
                prizeService.getPrizeToPrizeCommand().convert(x)).collect(Collectors.toList()));
        return "prizes";
    }

    @PostMapping("/handlePrizeAddition")
    public String addPrize(@ModelAttribute PrizeCommand source) {
        PrizeCommand prize = prizeService.saveCommand(source);
        return "redirect:/prizes";
    }
}
