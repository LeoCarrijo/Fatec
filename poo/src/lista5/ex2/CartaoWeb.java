package lista5.ex2;

public abstract class CartaoWeb {
    protected String destinatario;

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public CartaoWeb(String destinatario) {
        this.setDestinatario(destinatario);
    }

    @Override
    public String toString() {
        return "CartaoWeb{" +
                "destinatario='" + destinatario + '\'' +
                '}';
    }

    public abstract void showMessage();
}
