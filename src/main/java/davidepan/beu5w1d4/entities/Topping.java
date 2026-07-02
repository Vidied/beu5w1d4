package davidepan.beu5w1d4.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "condimenti")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Topping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    private String name;
    private int calorie;
    private double prezzo;

}
