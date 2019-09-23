package ir.shayandaneshvar.jottery.commands;

import ir.shayandaneshvar.jottery.models.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrizeCommand {
    private Long id;
    private String name;
    private Level level;
    private Integer number;
}
