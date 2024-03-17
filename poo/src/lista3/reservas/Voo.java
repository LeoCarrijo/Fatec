package lista3.reservas;

import java.util.ArrayList;

public class Voo {
    private int id;
    private String origem, destino;
    private ArrayList<Reserva> reservas = new ArrayList<>();

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

    public void addReserva(Reserva reserva){
        this.reservas.add(reserva);
    }

    public void deleteReserva(int i){
        this.reservas.remove(i);
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
