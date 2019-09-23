package ir.shayandaneshvar.jottery.config;

import ir.shayandaneshvar.jottery.models.Lottery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LotteryConfig {
    @Bean
    public Lottery lottery() {
        return new Lottery();
    }
}