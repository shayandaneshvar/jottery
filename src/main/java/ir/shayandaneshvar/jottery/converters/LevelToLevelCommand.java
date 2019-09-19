package ir.shayandaneshvar.jottery.converters;

import ir.shayandaneshvar.jottery.commands.LevelCommand;
import ir.shayandaneshvar.jottery.models.Level;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LevelToLevelCommand implements Converter<Level, LevelCommand> {

    @Override
    public LevelCommand convert(Level level) {
        if (level == null) {
            return null;
        }
        LevelCommand levelCommand = new LevelCommand();
        levelCommand.setId(level.getId());
        levelCommand.setTag(level.getTag());
        levelCommand.setMinimum(level.getMinimum());
        levelCommand.setMaximum(level.getMaximum());
        return levelCommand;
    }
}
