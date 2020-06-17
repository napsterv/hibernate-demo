package com.hibernatedemo.company.controllers;

import com.hibernatedemo.company.food.Pizza;
import com.hibernatedemo.company.repositories.PizzaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("pizzas")
public class PizzaController {

    private final PizzaRepository pizzaRepository;
//    private final Topp1

//    @Autowired
//    public PizzaController(PizzaRepository pizzaRepository) {
//        this.pizzaRepository = pizzaRepository;
//    }

    @GetMapping
    public List<Pizza> listPost() {
        return pizzaRepository.findAll();
    }

    @PostMapping
    public Pizza addPizza(@RequestBody Pizza pizza) {
//        List<Integer> ids = new ArrayList<>();
//        ids = (List<Integer>) pizza.getToppings_id();
//        List<Topping> toppings = new ArrayList<>();
//        toppings
        return pizzaRepository.save(pizza);
    }
}
