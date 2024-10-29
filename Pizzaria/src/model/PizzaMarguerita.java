    package model;

    import prototype.PizzaPrototype;
    import factory.Recheio; // Importação necessária para o uso de Recheio
    import java.util.ArrayList;
    import java.util.List;

    public class PizzaMarguerita extends Pizza implements PizzaPrototype {

        // Construtor padrão
        public PizzaMarguerita() {
            super("Marguerita", new ArrayList<>()); // Passa o nome "Marguerita" e uma lista vazia de recheios
        }

        // Construtor que aceita nome e recheios do tipo List<Recheio>
        public PizzaMarguerita(String nome, List<Recheio> recheios) {
            super(nome, recheios); // Passa o nome e os recheios para o construtor da classe base
        }

        @Override
        public Pizza clone() {
            // Ao clonar, cria uma nova instância de PizzaMarguerita com o nome e os recheios atuais
            return new PizzaMarguerita(this.getNome(), new ArrayList<>(this.getRecheios()));
        }
    }
