package Web.Produto;

public class TestaProduto {
    public static void main(String[] args) {
        Produto prod1 = new Produto(1, 10, "TVs", 1500);
        Produto prod2 = new Produto(2, 20, "Celulares", 2000);

        prod1.mostra();
        prod1.comprar(10);
        prod1.vender(5);
        prod1.subir(250.75F);
        prod1.descer(125.25F);
        prod1.mostra();

        prod2.mostra();
        prod2.comprar(5);
        prod2.vender(10);
        prod2.subir(400.50F);
        prod2.descer(200.25F);
        prod2.mostra();
    }
}
