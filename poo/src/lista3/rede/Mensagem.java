package lista3.rede;

public class Mensagem extends Pessoa{
    private int idm;
    private String text;

    public int getIdm() {
        return idm;
    }

    public void setIdm(int idm) {
        this.idm = idm;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Mensagem(int id, String nome, String usuario, int idm, String text) {
        super(id, nome, usuario);
        this.idm = idm;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Mensagem{" +
                "idm=" + idm +
                ", text='" + text + '\'' +
                super.toString() +
                '}';
    }
}
