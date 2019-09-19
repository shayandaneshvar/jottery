package ir.shayandaneshvar.jottery.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude = {"customer"})
@NoArgsConstructor
@Table(name = "levels")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tag;
    private Integer minimum;
    private Integer maximum;
    @OneToMany(mappedBy = "level",cascade = CascadeType.ALL)
    private List<Customer> customer;

}