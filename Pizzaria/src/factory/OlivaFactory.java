package factory;

public class OlivaFactory extends RecheioFactory {
    @Override
    public Recheio criarRecheio() {
        return new Oliva();
    }
}
