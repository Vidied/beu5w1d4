package davidepan.beu5w1d4.entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@Table(name = "pizze")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)h
    private long id;

    private String nome;
    private double prezzo;
    private int calorie;

    @ManyToMany
    private List<Topping> toppings;

    public Pizza( String nome, double prezzo, int calorie, List<Topping> toppings) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.calorie = calorie;
        this.toppings = toppings;
    }

}
