package lista1.rio;

public class TestaRio {
    public static void main(String[] args) {
        Rio rio1 = new Rio("Amazonas", 70, false);
        Rio rio2 = new Rio("Tietê", 50, true);

        rio1.mostra();
        rio1.chover(50);
        rio1.ensolarar(2);
        rio1.sujar();
        rio1.limpar();
        rio1.mostra();

        rio2.mostra();
        rio2.chover(70);
        rio2.ensolarar(4);
        rio2.limpar();
        rio2.sujar();
        rio2.mostra();
    }
}
