package model;

public class PizzariaConcreta extends Pizzaria {

    @Override
    public Pizza pedirPizza(String tipo) {
        if (tipo.equalsIgnoreCase("Calabresa")) {
            return new PizzaCalabresa();
        } else if (tipo.equalsIgnoreCase("Marguerita")) {
            return new PizzaMarguerita();
        } else {
            return null;
        }
    }
}
