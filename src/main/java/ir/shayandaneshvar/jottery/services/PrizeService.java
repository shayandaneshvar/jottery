package ir.shayandaneshvar.jottery.services;

import ir.shayandaneshvar.jottery.commands.LevelCommand;
import ir.shayandaneshvar.jottery.commands.PrizeCommand;
import ir.shayandaneshvar.jottery.converters.PrizeCommandToPrize;
import ir.shayandaneshvar.jottery.converters.PrizeToPrizeCommand;
import ir.shayandaneshvar.jottery.models.Level;
import ir.shayandaneshvar.jottery.models.Prize;
import ir.shayandaneshvar.jottery.repositories.PrizeRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Getter
@Setter
@RequiredArgsConstructor
@Service
public class PrizeService {
    private final PrizeRepository prizeRepository;
    private final PrizeCommandToPrize prizeCommandToPrize;
    private final PrizeToPrizeCommand prizeToPrizeCommand;

    @Transactional
    public PrizeCommand saveCommand(PrizeCommand source) {
        Prize prize = prizeCommandToPrize.convert(source);
        prize = prizeRepository.save(prize);
        return prizeToPrizeCommand.convert(prize);
    }
}
