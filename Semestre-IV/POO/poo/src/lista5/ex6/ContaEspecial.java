package lista5.ex6;

public class ContaEspecial extends Conta{

    public ContaEspecial(String nome, float salario, int numero, float saldo_limite, float saldo) {
        super(nome, salario, numero, saldo_limite, saldo);
    }

    @Override
    public void setSaldo_limite(float saldo_limite) {
        if (saldo_limite > this.getSalario() * 3) {
            System.out.println("Valor maior que salário mensal de " + this.getNome() + ". Valor inválido!");
        }
        this.saldo_limite = saldo_limite;
    }
}
