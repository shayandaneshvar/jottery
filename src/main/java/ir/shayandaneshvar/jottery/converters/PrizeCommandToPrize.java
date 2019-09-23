package ir.shayandaneshvar.jottery.converters;

import ir.shayandaneshvar.jottery.commands.PrizeCommand;
import ir.shayandaneshvar.jottery.models.Prize;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PrizeCommandToPrize implements Converter<PrizeCommand, Prize> {
    @Override
    public Prize convert(PrizeCommand src) {
        if (src == null) {
            return null;
        }
        Prize prize = new Prize();
        prize.setId(src.getId());
        prize.setMax(src.getLevel().getMaximum());
        prize.setName(src.getName());
        prize.setNumber(src.getNumber());
        return prize;
    }
}
