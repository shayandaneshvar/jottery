package ir.shayandaneshvar.jottery.repositories;

import ir.shayandaneshvar.jottery.models.Prize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrizeRepository extends JpaRepository<Prize, Long> {
}