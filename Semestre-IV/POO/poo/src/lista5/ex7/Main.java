package lista5.ex7;

public class Main {
    public static void main(String[] args) {
        Conta leonardo = new ContaEspecial("Leonardo", 1900f, 1, 5700f, 1000f);
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

        Cartao cart_leonardo = new Cartao(leonardo, 0, 123);
        Cartao cart_francisco = new Cartao(francisco, 100, 123);
        Cartao cart_damaris = new Cartao(damaris, 200, 123);
        System.out.println(cart_leonardo.toString());
        System.out.println(cart_francisco.toString());
        System.out.println(cart_damaris.toString());
        cart_leonardo.Depositar(100, 123);
        cart_francisco.Depositar(200, 123);
        cart_damaris.Depositar(300, 321);
        cart_leonardo.Retirar(50, 123);
        cart_francisco.Retirar(350, 123);
        cart_damaris.Retirar(150, 213);
        System.out.println(cart_leonardo.toString());
        System.out.println(cart_francisco.toString());
        System.out.println(cart_damaris.toString());
    }
}
