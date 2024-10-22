package factory;

public class QueijoExtraFactory extends RecheioFactory {
    @Override
    public Recheio criarRecheio() {
        return new QueijoExtra();
    }
}