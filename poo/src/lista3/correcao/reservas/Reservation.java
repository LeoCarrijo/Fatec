package lista3.correcao.reservas;

import java.util.Date;

public class Reservation {
    private int id;
    private Date date;
    private Passanger passanger;
    private Flight flight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Passanger getPassanger() {
        return passanger;
    }

    public void setPassanger(Passanger passanger) {
        this.passanger = passanger;
    }

    public Reservation(int id, Date date, Passanger passanger, int idf, String origin, String destination) {
        this.setId(id);
        this.setDate(date);
        this.setPassanger(passanger);
        this.flight = new Flight(idf, origin, destination);
    }
}
