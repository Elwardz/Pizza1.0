package application;

import iterator.IteratorIngredientes;
import model.Pizzaria;
import model.PizzariaConcreta;
import model.Pizza;
import factory.Recheio; // Importando a enumeração Recheio
import recibos.Recibo;

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
            System.out.println("3 - Repetir pedido");
            System.out.println("4 - Ver Pizzas");
            System.out.println("5 - Ver Recheios");
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
                case 3: // Repetir pedido
                    repetirPedido(scanner);
                    break;
                case 4: // Ver Pizzas
                    verPizzas();
                    break;
                case 5: // Ver Recheios
                    verRecheios();
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

    private static void verPizzas() {
        System.out.println("\n===== PIZZAS =====");
        System.out.println("1 - Calabresa - R$ 25,00");
        System.out.println("2 - Marguerita - R$ 30,00");
        System.out.println("3 - Mussarela - R$ 28,00");
        System.out.println("4 - Atum - R$ 35,00");
        System.out.println("5 - Portuguesa - R$ 32,00");
    }

    private static void verRecheios() {
        System.out.println("\n===== RECHEIOS =====");
        System.out.println("1 - Queijo Extra - R$ 5,00");
        System.out.println("2 - Oliva - R$ 4,00");
        System.out.println("3 - Cebola - R$ 3,00");
        System.out.println("4 - Pepperoni - R$ 6,00");
        System.out.println("5 - Tomate - R$ 2,00");
    }

    private static void fazerPedido(Scanner scanner, Pizzaria pizzaria) {
        System.out.println("\nEscolha o tipo de pizza:");
        verPizzas(); // Chama o método para mostrar as pizzas disponíveis
        System.out.print("Digite o número da pizza: ");
        int tipoPizza = scanner.nextInt();

        String tipo = "";
        switch (tipoPizza) {
            case 1:
                tipo = "Calabresa";
                break;
            case 2:
                tipo = "Marguerita";
                break;
            case 3:
                tipo = "Mussarela";
                break;
            case 4:
                tipo = "Atum";
                break;
            case 5:
                tipo = "Portuguesa";
                break;
            default:
                System.out.println("Tipo de pizza inválido.");
                return;
        }

        Pizza pizza = pizzaria.processarPedido(tipo); // Processa o pedido da pizza base
        Pizza pizzaPersonalizada = pizza.clone(); // Clona a pizza para personalização
        adicionarRecheios(scanner, pizzaPersonalizada); // Adiciona recheios personalizados
        pedidos.add(pizzaPersonalizada); // Adiciona a pizza personalizada à lista de pedidos
        ultimoPedido = pizzaPersonalizada; // Define a última pizza como a pizza personalizada

        Recibo.gerarRecibo(pizzaPersonalizada);
    }

    private static void adicionarRecheios(Scanner scanner, Pizza pizzaPersonalizada) {
        while (true) {
            System.out.print("Deseja adicionar um recheio adicional? (1 - Sim, 0 - Não): ");
            int adicionarRecheio = scanner.nextInt();

            if (adicionarRecheio == 1) {
                verRecheios(); // Chama o método para mostrar os recheios disponíveis
                System.out.print("Digite o número do recheio: ");
                int tipoRecheio = scanner.nextInt();

                // Usando o método apropriado para obter o recheio a partir da enumeração
                Recheio recheio = null;
                switch (tipoRecheio) {
                    case 1:
                        recheio = Recheio.QUEIJO_EXTRA;
                        break;
                    case 2:
                        recheio = Recheio.OLIVA;
                        break;
                    case 3:
                        recheio = Recheio.CEBOLA;
                        break;
                    case 4:
                        recheio = Recheio.PEPPERONI;
                        break;
                    case 5:
                        recheio = Recheio.TOMATE; // Adicionando o novo recheio
                        break;
                    default:
                        System.out.println("Recheio inválido.");
                }

                if (recheio != null) {
                    pizzaPersonalizada.adicionarRecheio(recheio);
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
                System.out.print("  Recheios: ");

                IteratorIngredientes iterator = pedido.getIteratorIngredientes();
                while (iterator.hasNext()) {
                    System.out.print(iterator.next());
                    if (iterator.hasNext()) {
                        System.out.print(", ");
                    }
                }
                System.out.println("."); // Quebra de linha após exibir todos os recheios
            }
        }
    }

    private static void repetirPedido(Scanner scanner) {
        if (!pedidos.isEmpty()) {
            System.out.println("\nEscolha qual pedido você gostaria de repetir:");
            for (int i = 0; i < pedidos.size(); i++) {
                Pizza pizza = pedidos.get(i);
                System.out.print((i + 1) + " - Pizza de " + pizza.getNome() + " com recheios: ");

                IteratorIngredientes iterator = pizza.getIteratorIngredientes();
                while (iterator.hasNext()) {
                    System.out.print(iterator.next());
                    if (iterator.hasNext()) {
                        System.out.print(", ");
                    }
                }
                System.out.println(); // Quebra de linha após exibir todos os recheios
            }

            System.out.print("Digite o número do pedido: ");
            int numeroPedido = scanner.nextInt();

            if (numeroPedido >= 1 && numeroPedido <= pedidos.size()) {
                Pizza pedidoRepetido = pedidos.get(numeroPedido - 1).clone(); // Clona o pedido escolhido

                // Preparar, assar, cortar e embalar a pizza
                pedidoRepetido.preparar();
                pedidoRepetido.assar();
                pedidoRepetido.cortar();
                pedidoRepetido.embalar();

                // Exibe a pizza repetida
                System.out.println("Pedido repetido com sucesso!");
                System.out.println("Pizza de " + pedidoRepetido.getNome());
                System.out.print("Recheios: ");
                IteratorIngredientes iterator = pedidoRepetido.getIteratorIngredientes();
                while (iterator.hasNext()) {
                    System.out.print(iterator.next());
                    if (iterator.hasNext()) {
                        System.out.print(", ");
                    }
                }
                System.out.println("."); // Quebra de linha após exibir todos os recheios

                pedidos.add(pedidoRepetido); // Adiciona a pizza repetida à lista de pedidos
            } else {
                System.out.println("Número de pedido inválido.");
            }
        } else {
            System.out.println("Nenhum pedido feito para repetir.");
        }
    }


}
