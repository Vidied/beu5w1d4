package davidepan.beu5w1d4.runners;

import davidepan.beu5w1d4.entities.Bevanda;
import davidepan.beu5w1d4.entities.Pizza;
import davidepan.beu5w1d4.entities.Topping;
import davidepan.beu5w1d4.repositories.BevandaRepository;
import davidepan.beu5w1d4.repositories.PizzaRepository;
import davidepan.beu5w1d4.repositories.ToppingRepository;
import davidepan.beu5w1d4.services.PizzaService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class MenuRunners implements CommandLineRunner {

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private ToppingRepository toppingRepository;

    @Autowired
    private BevandaRepository bevandaRepository;

    @Override
    public void run(String... args) throws Exception {

        Topping pomodoro = ctx.getBean("topping_pomodoro", Topping.class);
        Topping fiorDiLatte = ctx.getBean("topping_fiorDiLatte", Topping.class);
        Topping salame = ctx.getBean("topping_salame", Topping.class);
        Pizza margherita = ctx.getBean("pizza_margherita", Pizza.class);
        Pizza diavola = ctx.getBean("pizza_diavola", Pizza.class);
        Bevanda estateLimone = ctx.getBean("estate_limone", Bevanda.class);

        toppingRepository.save(pomodoro);
        toppingRepository.save(fiorDiLatte);
        toppingRepository.save(salame);
        pizzaRepository.save(margherita);
        pizzaRepository.save(diavola);
        bevandaRepository.save(estateLimone);

        log.info("Dati salvati con successo nel DB");

        try {
            log.info("tentativo prima query per pizze che costano meno di 6.5");
            List<Pizza> pizzaCheap = pizzaService.getPizzeEconomiche(6.5);
            pizzaCheap.forEach(System.out::println);

            log.info("tentativo seconda query per cercare una pizza per nome");
            List<Pizza> pizzaDiavola = pizzaService.getPizzaPerNome("Diavola");
            pizzaDiavola.forEach(System.out::println);
        } catch (Exception e){
            log.error("Errore nelle query", e);
        }
        log.info("Chiusura del programma");
    }
}
