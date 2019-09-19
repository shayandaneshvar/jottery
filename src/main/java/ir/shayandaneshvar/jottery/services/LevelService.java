package ir.shayandaneshvar.jottery.services;

import ir.shayandaneshvar.jottery.commands.LevelCommand;
import ir.shayandaneshvar.jottery.converters.LevelCommandToLevel;
import ir.shayandaneshvar.jottery.converters.LevelToLevelCommand;
import ir.shayandaneshvar.jottery.models.Level;
import ir.shayandaneshvar.jottery.repositories.CustomerRepository;
import ir.shayandaneshvar.jottery.repositories.LevelRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class LevelService {
    private final LevelRepository levelRepository;
    private final CustomerRepository customerRepository;
    private final LevelCommandToLevel levelCommandToLevel;
    private final LevelToLevelCommand levelToLevelCommand;
    @Transactional
    public LevelCommand saveCommand(LevelCommand source) {
        Level level = levelCommandToLevel.convert(source);
        level = levelRepository.save(level);
        customerRepository.updateCustomerByLevel(level,level.getMinimum(),level.getMaximum());
        return levelToLevelCommand.convert(level);
    }
}
