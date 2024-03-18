package lista3.reservas;

public class Main {
    public static void main(String[] args) {
        Passageiro leonardo = new Passageiro(1, "Leonardo", "123");
        Passageiro samuel = new Passageiro(2, "Samuel", "321");
        System.out.println(leonardo.toString());
        System.out.println(samuel.toString());

        Voo eua = new Voo(1, "Brasil", "EUA");
        Voo maceio = new Voo(2, "Brasil", "Maceió");
        System.out.println(eua.toString());
        System.out.println(maceio.toString());

        Reserva rese1 = new Reserva(eua, 1, "20/05/2024");
        Reserva rese2 = new Reserva(maceio, 2, "30/05/2024");
        Reserva rese3 = new Reserva(eua, 3, "20/07/2024");
        Reserva rese4 = new Reserva(maceio, 4, "30/07/2024");
        System.out.println(rese1.toString());
        System.out.println(rese2.toString());
        System.out.println(rese3.toString());
        System.out.println(rese4.toString());
    }
}
