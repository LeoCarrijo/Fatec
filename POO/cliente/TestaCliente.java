package Web.cliente;

public class TestaCliente {
    public static void main(String[] args) {
        Cliente fulano = new Cliente(1, 55, "Francisco", 1500);
        Cliente beltrano = new Cliente(2, 55, "Leonardo", 1500);

        fulano.mostrarInformacoes();
        fulano.realizarDeposito(500.50F);
        fulano.realizarSaque(200.75F);

        beltrano.mostrarInformacoes();
        beltrano.realizarDeposito(275.75F);
        beltrano.realizarSaque(125.25F);
    }
}
