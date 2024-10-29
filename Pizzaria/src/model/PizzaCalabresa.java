package model;

import prototype.PizzaPrototype;
import factory.Recheio; // Importação necessária para o uso de Recheio
import java.util.ArrayList;
import java.util.List;

public class PizzaCalabresa extends Pizza implements PizzaPrototype {

    // Construtor padrão
    public PizzaCalabresa() {
        super("Calabresa", new ArrayList<>()); // Passa o nome "Calabresa" e uma lista vazia de recheios
    }

    // Construtor que aceita nome e recheios do tipo List<Recheio>
    public PizzaCalabresa(String nome, List<Recheio> recheios) {
        super(nome, recheios); // Passa o nome e os recheios para o construtor da classe base
    }

    @Override
    public Pizza clone() {
        // Ao clonar, cria uma nova instância de PizzaCalabresa com o nome e os recheios atuais
        return new PizzaCalabresa(this.getNome(), new ArrayList<>(this.getRecheios()));
    }
}

