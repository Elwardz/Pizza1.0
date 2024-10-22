package factory;

public class PepperoniFactory extends RecheioFactory {
    @Override
    public Recheio criarRecheio() {
        return new Pepperoni();
    }
}
