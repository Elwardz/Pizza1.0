package factory;

import prototype.PizzaPrototype;
import java.util.ArrayList;

public class PizzaCalabresa extends Pizza implements PizzaPrototype {
    public PizzaCalabresa() {
        this.nome = "Calabresa";
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public Pizza clone() {
        PizzaCalabresa clone = new PizzaCalabresa();
        clone.recheios = new ArrayList<>(this.recheios); // Clona os recheios
        //return new new PizzaCalabresa(getNome(), getRecheio());
        return clone;
    }
}
