package factory;

import iterator.IteratorIngredientes;
import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    protected String nome; //private
    protected List<String> recheios = new ArrayList<>(); //private
    //pode criar dois cosntrutores: um vazio e outro com tudo
    public abstract String getNome();

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

    // Método clone deve ser adicionado aqui // ??
    public abstract Pizza clone();
}
