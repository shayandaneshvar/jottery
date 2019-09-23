package ir.shayandaneshvar.jottery.models;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = "customer")
@Entity
public class Prize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer max;
    private Integer number;
    @ManyToOne
    private Customer customer;
}
