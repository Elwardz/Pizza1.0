package iterator;

import java.util.List;

public class IteratorIngredientes {
    private List<String> recheios;
    private int posicao;

    public IteratorIngredientes(List<String> recheios) {
        this.recheios = recheios;
        this.posicao = 0;
    }

    public boolean hasNext() {
        return posicao < recheios.size();
    }

    public String next() {
        return hasNext() ? recheios.get(posicao++) : null;
    }

    @Override
    public String toString() {
        return String.join(", ", recheios); // Converte a lista de recheios em uma String
    }
}
