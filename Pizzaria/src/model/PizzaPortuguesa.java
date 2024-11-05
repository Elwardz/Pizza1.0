package model;

import prototype.PizzaPrototype;
import factory.Recheio;
import java.util.ArrayList;
import java.util.List;

public class PizzaPortuguesa extends Pizza implements PizzaPrototype {

    public PizzaPortuguesa() {
        super("Portuguesa", new ArrayList<>()); // Nome da pizza e lista vazia de recheios
    }

    public PizzaPortuguesa(String nome, List<Recheio> recheios) {
        super(nome, recheios);
    }

    @Override
    public Pizza clone() {
        return new PizzaPortuguesa(this.getNome(), new ArrayList<>(this.getRecheios()));
    }
}
