package model;

import factory.Recheio;
import factory.QueijoExtraFactory; // Certifique-se de importar a fábrica
import iterator.IteratorIngredientes;
import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    private String nome;
    private List<Recheio> recheiosList;

    // Construtor vazio
    public Pizza() {
        this.recheiosList = new ArrayList<>();
    }

    // Construtor com nome e recheios
    public Pizza(String nome, List<Recheio> recheiosList) {
        this.nome = nome;
        this.recheiosList = new ArrayList<>(recheiosList); // Clona a lista para evitar modificações externas
    }

    public String getNome() {
        return nome;
    }

    // Método para adicionar um recheio do tipo Recheio
    public void adicionarRecheio(Recheio recheio) {
        recheiosList.add(recheio);
    }

    // Método específico para adicionar queijo extra
    public void adicionarQueijoExtra() {
        QueijoExtraFactory queijoExtraFactory = new QueijoExtraFactory();
        Recheio queijoExtra = queijoExtraFactory.criarRecheio();
        adicionarRecheio(queijoExtra);
    }

    public IteratorIngredientes getIteratorIngredientes() {
        return new IteratorIngredientes(recheiosList);
    }

    public void preparar() {
        System.out.println("Preparando Pizza de " + getNome());
        System.out.println("Recheios: " + recheiosList);
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

    public List<Recheio> getRecheios() {
        return recheiosList;
    }

    public abstract Pizza clone();
}
