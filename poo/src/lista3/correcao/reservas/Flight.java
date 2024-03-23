package lista3.correcao.reservas;

public class Flight {
    private int id;
    private String origin, destination;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Flight(int id, String origin, String destination) {
        this.setId(id);
        this.setOrigin(origin);
        this.setDestination(destination);
    }
}
