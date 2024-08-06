package lista5.ex5;

public class Conta {
    private String nome;
    private float salario, saldo_limite, saldo;
    private int numero;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getSaldo_limite() {
        return saldo_limite;
    }

    public void setSaldo_limite(float saldo_limite) {
        if (saldo_limite > this.salario) {
            System.out.println("Valor maior que salário mensal de " + this.getNome() + ". Valor inválido!");
        }
        this.saldo_limite = saldo_limite;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Conta(String nome, float salario, int numero, float saldo_limite, float saldo) {
        this.setNome(nome);
        this.setSalario(salario);
        this.setNumero(numero);
        this.setSaldo_limite(saldo_limite);
        this.setSaldo(saldo);
    }

    public void Depositar(float qtd) {
        System.out.println("--------------" + this.getNome() + "--------------");
        if (this.getSaldo() >= this.getSaldo_limite()) {
            System.out.println("Saldo limite de R$ " + this.getSaldo_limite() + " atingido.");
        } else {
            if (qtd + this.getSaldo() > this.getSaldo_limite()) {
                System.out.println("Não é possível depositar R$" + qtd + ", você tem um limite de saldo de R$ " +
                        this.getSaldo_limite() + ".\nÉ possível depositar apenas R$ " +
                        ((this.getSaldo() + qtd) - this.getSaldo_limite()));
            }else{
                this.saldo += qtd;
                System.out.println("R$ " + qtd + " depositados.\nSaldo atual: R$ " + this.getSaldo());
            }
        }
    }

    public boolean Retirar(float qtd) {
        System.out.println("--------------" + this.getNome() + "--------------");
        if(this.getSaldo() - qtd < 0){
            System.out.println("Não é possível realizar o saque de R$ " + qtd + ", saldo atual de R$ " + this.getSaldo());
            return false;
        }else{
            this.saldo -= qtd;
            System.out.println("Saque de R$ " + qtd + " realizado\nSaldo atual: R$ " + this.getSaldo());
            return true;
        }
    }

    @Override
    public String toString() {
        return "Conta{" +
                "nome='" + nome + '\'' +
                ", salario=" + salario +
                ", saldo_limite=" + saldo_limite +
                ", saldo=" + saldo +
                ", numero=" + numero +
                '}';
    }
}
