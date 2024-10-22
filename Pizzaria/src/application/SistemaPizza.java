package application;

import factory.Pizzaria;
import factory.PizzariaConcreta;
import factory.Pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaPizza {

    private static List<Pizza> pedidos = new ArrayList<>();
    private static Pizza ultimoPedido = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pizzaria pizzaria = new PizzariaConcreta();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Fazer pedido");
            System.out.println("2 - Ver pedidos");
            System.out.println("3 - Repetir último pedido");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1: // Fazer pedido
                    fazerPedido(scanner, pizzaria);
                    break;
                case 2: // Ver pedidos
                    verPedidos();
                    break;
                case 3: // Repetir último pedido
                    repetirUltimoPedido();
                    break;
                case 0: // Sair
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void fazerPedido(Scanner scanner, Pizzaria pizzaria) {
        System.out.println("\nEscolha o tipo de pizza:");
        System.out.println("1 - Calabresa");
        System.out.println("2 - Marguerita");
        System.out.print("Digite o número da pizza: ");
        int tipoPizza = scanner.nextInt();

        String tipo = (tipoPizza == 1) ? "Calabresa" : "Marguerita";
        Pizza pizza = pizzaria.pedirPizza(tipo);

        Pizza pizzaPersonalizada = pizza.clone(); // Clona a pizza para personalização

        adicionarRecheios(scanner, pizzaPersonalizada);

        pizzaria.processarPedido(pizzaPersonalizada);

        pedidos.add(pizzaPersonalizada);
        ultimoPedido = pizzaPersonalizada;
    }

    private static void adicionarRecheios(Scanner scanner, Pizza pizzaPersonalizada) {
        while (true) {
            System.out.print("Deseja adicionar um recheio adicional? (1 - Sim, 0 - Não): ");
            int adicionarRecheio = scanner.nextInt();

            if (adicionarRecheio == 1) {
                System.out.println("Escolha um recheio:");
                System.out.println("1 - Queijo Extra");
                System.out.println("2 - Oliva");
                System.out.println("3 - Cebola");
                System.out.println("4 - Pepperoni");
                System.out.print("Digite o número do recheio: ");
                int tipoRecheio = scanner.nextInt();

                switch (tipoRecheio) {
                    case 1:
                        pizzaPersonalizada.adicionarRecheio("Queijo Extra");
                        break;
                    case 2:
                        pizzaPersonalizada.adicionarRecheio("Oliva");
                        break;
                    case 3:
                        pizzaPersonalizada.adicionarRecheio("Cebola");
                        break;
                    case 4:
                        pizzaPersonalizada.adicionarRecheio("Pepperoni");
                        break;
                    default:
                        System.out.println("Recheio inválido.");
                }
            } else {
                break;
            }
        }
    }

    private static void verPedidos() {
        System.out.println("\nPedidos feitos:");
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido feito.");
        } else {
            for (Pizza pedido : pedidos) {
                System.out.println("- Pizza de " + pedido.getNome());
                System.out.println("  Recheios: " + pedido.getIteratorIngredientes());
            }
        }
    }

    private static void repetirUltimoPedido() {
        if (ultimoPedido != null) {
            System.out.println("\nRepetindo último pedido:");
            Pizza pedidoRepetido = ultimoPedido.clone();

            pedidoRepetido.preparar();
            pedidoRepetido.assar();
            pedidoRepetido.cortar();
            pedidoRepetido.embalar();

            pedidos.add(pedidoRepetido);
            System.out.println("Pedido repetido com sucesso!");
        } else {
            System.out.println("Nenhum pedido anterior para repetir.");
        }
    }
}
