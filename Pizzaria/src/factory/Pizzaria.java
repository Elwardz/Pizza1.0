package factory;

public abstract class Pizzaria {
    public abstract Pizza pedirPizza(String tipo);

    public void processarPedido(Pizza pizza) {
        pizza.preparar();
        pizza.assar();
        pizza.cortar();
        pizza.embalar();
    }
}
