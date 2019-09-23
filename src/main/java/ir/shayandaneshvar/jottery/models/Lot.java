package ir.shayandaneshvar.jottery.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Lot {
    private final Long id;
    private final Integer max;
    private Boolean active;
}
