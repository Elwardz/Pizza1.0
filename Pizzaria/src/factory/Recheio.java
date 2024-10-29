package factory;

public enum Recheio {
    QUEIJO_EXTRA(1, "Queijo Extra"),
    OLIVA(2, "Oliva"),
    CEBOLA(3, "Cebola"),
    PEPPERONI(4, "Pepperoni");

    private final int tipo;
    private final String nome;

    Recheio(int tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    public static String criarRecheio(int tipoRecheio) {
        for (Recheio recheio : values()) {
            if (recheio.tipo == tipoRecheio) {
                return recheio.nome;
            }
        }
        throw new IllegalArgumentException("Tipo de recheio inválido: " + tipoRecheio);
    }

    @Override
    public String toString() {
        return nome;
    }

}

