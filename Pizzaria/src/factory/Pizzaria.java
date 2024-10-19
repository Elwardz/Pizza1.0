package factory;

public abstract class Pizzaria { // Agora é uma classe abstrata
    public abstract Pizza pedirPizza(String tipo);

    public void processarPedido(Pizza pizza) {
        pizza.preparar();
        pizza.assar();
        pizza.cortar();
        pizza.embalar();
        System.out.println("Pedido feito com sucesso!");
    }
}
