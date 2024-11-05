package factory;

public class RecheioFactory {

    public static Recheio criarRecheio(String tipo) {
        switch (tipo.toLowerCase()) {
            case "cebola":
                return Recheio.CEBOLA;
            case "oliva":
                return Recheio.OLIVA;
            case "pepperoni":
                return Recheio.PEPPERONI;
            case "queijo extra":
                return Recheio.QUEIJO_EXTRA;
            default:
                throw new IllegalArgumentException("Tipo de recheio inválido: " + tipo);
        }
    }
}