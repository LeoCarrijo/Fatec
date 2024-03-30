package lista5.ex5;

public class Main {
    public static void main(String[] args) {
        Conta leonardo = new Conta("Leonardo", 1900f, 1, 1800f, 1000f);
        Conta francisco = new Conta("Francisco", 2500f, 2, 2400f, 2200f);
        Conta damaris = new Conta("Damaris", 2100f, 3, 2000f, 1500f);

        System.out.println(leonardo.toString());
        System.out.println(francisco.toString());
        System.out.println(damaris.toString());
        leonardo.Depositar(200f);
        francisco.Depositar(100f);
        damaris.Depositar(600f);
        damaris.Depositar(100f);
        leonardo.Retirar(1200f);
        francisco.Retirar(2400f);
        damaris.Retirar(1500f);
        System.out.println(leonardo.toString());
        System.out.println(francisco.toString());
        System.out.println(damaris.toString());

    }
}
