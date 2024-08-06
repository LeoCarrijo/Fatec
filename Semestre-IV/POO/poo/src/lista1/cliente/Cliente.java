package lista1.cliente;

public class Cliente {
    private int numeroConta, numeroAgencia;
    private String nome;
    private float saldo;

    public Cliente(int numeroConta, int numeroAgencia, String nome, float saldo){
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.nome = nome;
        this.saldo = saldo;
    }

    public void mostrarInformacoes(){
        System.out.println("\nNome: " + this.nome +
                "\nNº da Conta: " + this.numeroConta +
                "\nSaldo Atual: " + this.saldo);
    }

    public void realizarDeposito(float quantia){
        this.saldo += quantia;
        System.out.println("\nR$" + quantia + " depositado(s)" +
                "\nSaldo Atual: " + this.saldo);
    }

    public void realizarSaque(float quantia){
        this.saldo -= quantia;
        System.out.println("\nR$" + quantia + " Sacado(s)" +
                "\nSaldo Atual: " + this.saldo);
    }
}
