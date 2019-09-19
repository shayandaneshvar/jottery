package ir.shayandaneshvar.jottery.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(exclude = {"level"})
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(unique = true)
    @Basic(fetch = FetchType.EAGER)
    private Long nationalCode;
    @NonNull
    @NotBlank
    private String firstName;
    @NonNull
    @NotBlank
    private String lastName;
    @NonNull
    @Positive
    private Integer score;
    //    @PastOrPresent
    private LocalDate birthDate;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotBlank
    @Size(min = 3, max = 12)
    @Basic(fetch = FetchType.LAZY)
    private String mobile;
    @ManyToOne
    private Level level;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Prize> prizes;

    public Customer(Long nationalCode, String firstName, String lastName,
                    Integer score, LocalDate birthDate, Gender gender,
                    String mobile) {
        this.nationalCode = nationalCode;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.lastName = lastName;
        this.gender = gender;
        this.mobile = mobile;
        this.score = score;
    }
}