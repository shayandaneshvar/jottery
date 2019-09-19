package ir.shayandaneshvar.jottery.controllers;

import ir.shayandaneshvar.jottery.commands.LevelCommand;
import ir.shayandaneshvar.jottery.models.Level;
import ir.shayandaneshvar.jottery.repositories.LevelRepository;
import ir.shayandaneshvar.jottery.services.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class LevelController {
    private final LevelService levelService;

    @GetMapping({"/levels", "level", "/lvls", "/lvl"})
    public String loadLevels(Model model) {
        model.addAttribute("level", new LevelCommand());
        model.addAttribute("levels", levelService.getLevelRepository().findAll());
        return "levels";
    }

    @PostMapping("/handleLevelAddition")
    public String addLevel(@ModelAttribute LevelCommand source) {
        LevelCommand levelCommand = levelService.saveCommand(source);
        return "redirect:/levels";
    }
}
