package factory;

import iterator.IteratorIngredientes;
import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    private String nome;
    private List<String> recheios;

    // Construtor vazio
    public Pizza() {
        this.recheios = new ArrayList<>();
    }

    // Construtor com nome e recheios
    public Pizza(String nome, List<String> recheios) {
        this.nome = nome;
        this.recheios = new ArrayList<>(recheios); // Clona a lista para evitar modificações externas
    }

    public String getNome() {
        return nome;
    }

    public void adicionarRecheio(String recheio) {
        recheios.add(recheio);
    }

    public IteratorIngredientes getIteratorIngredientes() {
        return new IteratorIngredientes(recheios);
    }

    public void preparar() {
        System.out.println("Preparando Pizza de " + getNome());
        System.out.println("Recheios: " + recheios);
    }

    public void assar() {
        System.out.println("Assando Pizza de " + getNome());
    }

    public void cortar() {
        System.out.println("Cortando Pizza de " + getNome());
    }

    public void embalar() {
        System.out.println("Embalando Pizza de " + getNome());
    }

    public List<String> getRecheios() {
        return recheios;
    }

    public abstract Pizza clone();
}
