package lista5.ex4;

public abstract class Coisa {
    protected String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Coisa() {
    }

    @Override
    public String toString() {
        return "Coisa{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
