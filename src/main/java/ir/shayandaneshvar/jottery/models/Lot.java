package ir.shayandaneshvar.jottery.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Lot {
    private final Long id;
    private Boolean active;
}
