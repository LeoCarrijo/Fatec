package lista3.reservas;

public class Reserva{
    private int id;
    private String data;
    private Voo voo;

    public int getIdr() {
        return id;
    }

    public void setIdr(int idr) {
        this.id = idr;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public Reserva(Voo voo, int id, String data) {
        this.setVoo(voo);
        this.setIdr(id);
        this.setData(data);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", voo=" + voo +
                '}';
    }
}
