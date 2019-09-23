package ir.shayandaneshvar.jottery.services;

import ir.shayandaneshvar.jottery.repositories.CustomerRepository;
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
    private final CustomerRepository customerRepository;
}
