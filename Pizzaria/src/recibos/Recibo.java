package recibos;

import iterator.IteratorIngredientes;
import model.Pizza;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Recibo {

    public static void gerarRecibo(Pizza pedido) {
        // Cria um nome de arquivo único para cada recibo com base na data e hora
        String nomeArquivo = "Recibo_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            // Cabeçalho do recibo
            writer.write("Recibo de Pedido\n");
            writer.write("===================\n");
            writer.write("Pizza: " + pedido.getNome() + "\n");

            // Lista os ingredientes
            writer.write("Ingredientes: ");
            IteratorIngredientes iterator = pedido.getIteratorIngredientes();
            while (iterator.hasNext()) {
                writer.write(iterator.next().toString());
                if (iterator.hasNext()) {
                    writer.write(", ");
                }
            }
            writer.newLine();

            // Adiciona a data e hora do pedido
            writer.write("Data e Hora: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n");
            writer.write("===================\n");
            writer.write("Obrigado pela preferência!");

            System.out.println("Recibo gerado: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao gerar o recibo: " + e.getMessage());
        }
    }
}
