package ir.shayandaneshvar.jottery.converters;

import ir.shayandaneshvar.jottery.commands.LevelCommand;
import ir.shayandaneshvar.jottery.models.Level;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LevelCommandToLevel implements Converter<LevelCommand, Level> {
    @Override
    public Level convert(LevelCommand source) {
        log.debug("Converting lvlCommand to lvl");
        if (source == null) {
            return null;
        }
        Level level = new Level();
        level.setId(source.getId());
        level.setTag(source.getTag());
        level.setMaximum(source.getMaximum());
        level.setMinimum(source.getMinimum());
        return level;
    }
}
