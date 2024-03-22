package lista3.rede;

public class Mensagem{
    private int id;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Mensagem(int id, String text) {
        this.setId(id);
        this.setText(text);
    }

    @Override
    public String toString() {
        return "Mensagem{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
