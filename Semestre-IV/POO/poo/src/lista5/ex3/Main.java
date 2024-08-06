package lista5.ex3;

public class Main {
    public static void main(String[] args) {
        Controle controle = new Controle();
        Radio radio = new Radio(123, 20, "97.9", "FM");
        TV tv = new TV(321, 20, "SBT");

        controle.TestarProduto(radio);
        controle.TestarProduto(tv);

        radio.TrocarBanda("98.5");
        radio.TrocarEstacao("AM");
        tv.TrocarCanal("Record");

        controle.TestarProduto(radio);
        controle.TestarProduto(tv);
    }
}
