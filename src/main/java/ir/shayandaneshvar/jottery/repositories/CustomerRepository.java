package ir.shayandaneshvar.jottery.repositories;

import ir.shayandaneshvar.jottery.models.Customer;
import ir.shayandaneshvar.jottery.models.Level;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //    @Query("select count (customer.id) from Customer customer where customer" +
//            ".score between :min and :max")
//    Long counter(@Param("min") Integer minimum, @Param("max") Integer maximum);
    Long countAllByScoreBetween(Long min, Long max);

    @Modifying
    @Transactional
    @Query(value = "update Customer c set c.level= :level where c.score between :min AND :max")
    void updateCustomerByLevel(@Param("level") Level level, @Param("min") Integer min, @Param("max") Integer max);
//    @Query(value = "select * from Customer limit 10 ",nativeQuery = true)
//    List<Customer> findFirst10();

}