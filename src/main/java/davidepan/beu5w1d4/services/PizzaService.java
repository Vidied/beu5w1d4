package davidepan.beu5w1d4.services;

import davidepan.beu5w1d4.entities.Pizza;
import davidepan.beu5w1d4.repositories.PizzaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;


    public List<Pizza> getPizzeEconomiche(double prezzoMassimo) {
        return pizzaRepository.findByPrezzoLessThan(prezzoMassimo);
    }

    public List<Pizza> getPizzaPerNome(String nome) {
        return pizzaRepository.cercaPizza(nome);
    }

}
