package model;

public class PizzariaConcreta extends Pizzaria {

    @Override
    public Pizza pedirPizza(String tipo) {
        if (tipo.equalsIgnoreCase("Calabresa")) {
            return new PizzaCalabresa();
        } else if (tipo.equalsIgnoreCase("Marguerita")) {
            return new PizzaMarguerita();
        } else if (tipo.equalsIgnoreCase("Mussarela")) {
            return new PizzaMussarela();
        } else if (tipo.equalsIgnoreCase("Atum")) {
            return new PizzaAtum();
        } else if (tipo.equalsIgnoreCase("Portuguesa")) {
            return new PizzaPortuguesa();
        } else {
            return null;
        }
    }
}
