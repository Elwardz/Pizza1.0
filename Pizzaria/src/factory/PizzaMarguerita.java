package factory;

import prototype.PizzaPrototype;
import java.util.ArrayList;

public class PizzaMarguerita extends Pizza implements PizzaPrototype {
    public PizzaMarguerita() {
        this.nome = "Marguerita";
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public Pizza clone() {
        PizzaMarguerita clone = new PizzaMarguerita();
        clone.recheios = new ArrayList<>(this.recheios); // Clona os recheios
        return clone;
    }
}
