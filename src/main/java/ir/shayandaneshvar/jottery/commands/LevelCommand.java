package ir.shayandaneshvar.jottery.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LevelCommand {
    private Long Id;
    private String tag;
    private Integer minimum;
    private Integer maximum;
}
