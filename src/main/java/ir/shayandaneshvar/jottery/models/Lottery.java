package ir.shayandaneshvar.jottery.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class Lottery {
    private Integer offset;
    private List<Lot> lots = new ArrayList<>();
    private List<Prize> prizes = new ArrayList<>();
    private Boolean isActive = true;

    public void generateLots(Iterable<Customer> all) {
        all.forEach(x -> {
            Lot lot = new Lot(x.getId(), true);
            for (int i = 0; i < x.getScore(); i++) {
                lots.add(lot);
            }
        });
    }

    public Lottery(Integer off) {
        offset = off;
    }

    public boolean start() {
        if (!isActive || lots.size() == 0) {
            log.debug("$$$ problem starting the lotto!");
            return false;
        }
        prizes.sort((x, y) -> x == y ? 0 : (x.getMax() > y.getMax() ? 1 : -1));
        prizes.forEach(System.out::println);
        doTheLottery();
        return true;
    }

    private void doTheLottery() {
        prizes.forEach(x -> {
            Integer pointer = (int) (Math.random() * 100);
            for (int i = 0; i < x.getNumber(); i++) {
                if (lots.get(pointer).getActive()) {
                    // TODO: 9/22/19  ps:prize -- customer rel ?! handle it.!
                }
                pointer += offset;
            }
        });
    }
}
