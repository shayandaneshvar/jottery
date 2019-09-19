package ir.shayandaneshvar.jottery.services;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;


@Getter
@Setter
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final LevelService levelService;
}
