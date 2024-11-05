package model;

import prototype.PizzaPrototype;
import factory.Recheio;
import java.util.ArrayList;
import java.util.List;

public class PizzaMussarela extends Pizza implements PizzaPrototype {

    public PizzaMussarela() {
        super("Mussarela", new ArrayList<>()); // Nome da pizza e lista vazia de recheios
    }

    public PizzaMussarela(String nome, List<Recheio> recheios) {
        super(nome, recheios);
    }

    @Override
    public Pizza clone() {
        return new PizzaMussarela(this.getNome(), new ArrayList<>(this.getRecheios()));
    }
}
