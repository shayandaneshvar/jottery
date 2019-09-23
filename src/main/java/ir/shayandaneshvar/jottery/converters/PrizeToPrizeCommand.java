package ir.shayandaneshvar.jottery.converters;

import ir.shayandaneshvar.jottery.commands.PrizeCommand;
import ir.shayandaneshvar.jottery.models.Prize;
import ir.shayandaneshvar.jottery.repositories.LevelRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PrizeToPrizeCommand implements Converter<Prize, PrizeCommand> {
    private final LevelRepository levelRepository;

    @Override
    public PrizeCommand convert(Prize src) {
        if (src == null) {
            return null;
        }
        PrizeCommand prizeCommand = new PrizeCommand();
        prizeCommand.setId(src.getId());
        prizeCommand.setName(src.getName());
        prizeCommand.setLevel(levelRepository.findByMaximum(src.getMax()));
        prizeCommand.setNumber(src.getNumber());
        return prizeCommand;
    }
}
