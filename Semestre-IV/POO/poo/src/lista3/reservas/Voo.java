package lista3.reservas;

public class Voo {
    protected int id;
    protected String origem, destino;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Voo(int id, String origem, String destino) {
        this.setId(id);
        this.setOrigem(origem);
        this.setDestino(destino);
    }

    @Override
    public String toString() {
        return "Voo{" +
                "id=" + id +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                '}';
    }
}
