package davidepan.beu5w1d4.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bevande")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Bevanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    private long id;

    private String name;
    private int calorie;
    private double prezzo;

    public Bevanda( String name, int calorie, double prezzo) {

        this.name = name;
        this.calorie = calorie;
        this.prezzo = prezzo;
    }

}
