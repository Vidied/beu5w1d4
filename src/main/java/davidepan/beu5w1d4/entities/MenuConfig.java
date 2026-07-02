package davidepan.beu5w1d4.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MenuConfig {

    @Bean(name = "topping_pomodoro")
    public Topping toppingPomodoro(){
        Topping t = new Topping();
        t.setName("Pomodoro");
        t.setCalorie(20);
        t.setPrezzo(0.5);
        return t;
    }
    @Bean(name = "topping_fiorDiLatte")
    public Topping toppingFiorDiLatte(){
        Topping t = new Topping();
        t.setName("Fior di latte");
        t.setCalorie(100);
        t.setPrezzo(1);
        return t;
    }
    @Bean(name = "topping_salame")
    public Topping toppingSalame(){
        Topping t = new Topping();
        t.setName("Salame");
        t.setCalorie(150);
        t.setPrezzo(1.5);
        return t;
    }

    @Bean(name = "pizza_margherita")
    public Pizza pizzaMargherita(){
        List<Topping> tL = new ArrayList<>();
        tL.add(toppingPomodoro());
        tL.add(toppingFiorDiLatte());
        return new Pizza("Margherita", 5.99, 700, tL);
    }
    @Bean(name = "pizza_diavola")
    public Pizza pizzaDiavola(){
        List<Topping> tL = new ArrayList<>();
        tL.add(toppingPomodoro());
        tL.add(toppingFiorDiLatte());
        tL.add(toppingSalame());
        return new Pizza("Diavola", 6.49, 850, tL);
    }

    @Bean(name = "estate_limone")
    public Bevanda estateLimone(){
        return new Bevanda("Estate al limone", 200,1.5);
    }


}
