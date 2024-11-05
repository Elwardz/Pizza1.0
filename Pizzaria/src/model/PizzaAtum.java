package model;

import prototype.PizzaPrototype;
import factory.Recheio;
import java.util.ArrayList;
import java.util.List;

public class PizzaAtum extends Pizza implements PizzaPrototype {

    public PizzaAtum() {
        super("Atum", new ArrayList<>()); // Nome da pizza e lista vazia de recheios
    }

    public PizzaAtum(String nome, List<Recheio> recheios) {
        super(nome, recheios);
    }

    @Override
    public Pizza clone() {
        return new PizzaAtum(this.getNome(), new ArrayList<>(this.getRecheios()));
    }
}
