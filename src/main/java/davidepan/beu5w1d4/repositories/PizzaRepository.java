package davidepan.beu5w1d4.repositories;

import davidepan.beu5w1d4.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    List<Pizza> findByPrezzoLessThan(double prezzo);

    @Query("SELECT p FROM Pizza p WHERE p.nome = :nome")
    List<Pizza> cercaPizza(@Param("nome") String nome);
}
