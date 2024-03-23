package lista5.ex2;

public abstract class CartaoWeb {
    protected String destinatario;

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public abstract void showMessage();
}
