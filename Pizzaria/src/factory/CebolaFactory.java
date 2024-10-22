package factory;

public class CebolaFactory extends RecheioFactory {
    @Override
    public Recheio criarRecheio() {
        return new Cebola();
    }
}

