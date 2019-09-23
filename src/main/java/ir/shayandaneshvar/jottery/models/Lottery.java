package ir.shayandaneshvar.jottery.models;

import ir.shayandaneshvar.jottery.repositories.CustomerRepository;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
@Setter
public final class Lottery {
    private Integer offset;
    private List<Lot> lots = new ArrayList<>();
    private List<Prize> prizes = new ArrayList<>();
    private Boolean isActive = true;
    private CustomerRepository customerRepository;


    private void generateLots(Iterable<Customer> all) {
        all.forEach(x -> {
            if (x.getLevel() == null) {
                return;
            }
            Lot lot = new Lot(x.getId(), x.getScore(), true);
            for (int i = 0; i < x.getScore(); i++) {
                lots.add(lot);
            }
        });
    }

    public boolean start(Iterable<Customer> all) {
        generateLots(all);
        if (!isActive || lots.size() == 0) {
            log.debug("$$$ problem starting the lotto!");
            return false;
        }
        prizes.sort((x, y) -> x == y ? 0 : (x.getMax() > y.getMax() ? 1 : -1));
        prizes.forEach(System.out::println);
        final List list = new ArrayList();
        all.forEach(c -> list.add(c));
        doTheLottery(list);
        return true;
    }

    private void doTheLottery(List<Customer> all) {
        AtomicInteger pointer = new AtomicInteger((int) Math.abs(Math.random() * 1000));
        prizes.forEach(prz -> {
            for (int i = 0; i < prz.getNumber(); i++) {
                Lot lot;
                if ((lot = lots.get(pointer.get() % lots.size())).getActive()) {
                    if (lot.getMax() <= prz.getMax()) {
                        offerPrize(prz, all, lot);
                    } else {
                        i--;
                    }
                } else {
                    int index = pointer.get() % lots.size() + 1;
                    while (true) {
                        if ((lot = lots.get(index % lots.size())).getActive() && lot.getMax() < prz.getMax()) {
                            offerPrize(prz, all, lot);
                            break;
                        } else {
                            index++;
                        }
                    }
                }
                pointer.set((pointer.get() + offset) % lots.size());
            }
        });
    }

    private void offerPrize(Prize prz, List<Customer> all, Lot lot) {
        List<Customer> list = new ArrayList<>();
        all.stream().filter(c -> c.getId() == lot.getId()).findFirst().
                ifPresent(x -> {
                    x.setPrize(prz);
                    list.add(x);
                });
        list.forEach(x -> customerRepository.save(x));
        lot.setActive(false);
    }
}
