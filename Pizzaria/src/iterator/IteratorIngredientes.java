package iterator;

import factory.Recheio;
import java.util.List;

public class IteratorIngredientes {
    private List<Recheio> recheios;
    private int position = 0;

    public IteratorIngredientes(List<Recheio> recheios) {
        this.recheios = recheios;
    }

    public boolean hasNext() {
        return position < recheios.size();
    }

    public Recheio next() {
        if (this.hasNext()) {
            return recheios.get(position++);
        }
        return null; // Ou pode lançar uma exceção
    }

    public void remove() {
        if (position > 0) {
            recheios.remove(--position);
        } else {
            throw new IllegalStateException("Não é possível remover antes de chamar next()");
        }
    }
}
