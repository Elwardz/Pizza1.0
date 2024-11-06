package model;

public abstract class Pizzaria {
    public abstract Pizza pedirPizza(String tipo);

    public Pizza processarPedido(String tipo) {
        Pizza pizza = this.pedirPizza(tipo);

        if(pizza == null) {
            throw new IllegalArgumentException("Tipo de pizza não reconhecido: " + tipo);
        }

        return pizza;
    }
}

