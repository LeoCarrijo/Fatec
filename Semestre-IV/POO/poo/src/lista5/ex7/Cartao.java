package lista5.ex7;

import lista5.ex7.Conta;

public class Cartao {
    private Conta conta;
    private int senha;
    private float saldo;

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public int getSenha() {
        return senha;
    }

    private void setSenha(int senha) {
        this.senha = senha;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void AlterarSenha(int novaSenha, int senhaAntiga){
        if(senhaAntiga == this.getSenha()){
            this.setSenha(novaSenha);
        }else{
            System.out.println("Senha atual errada!");
        }
    }

    public Cartao(Conta conta, float saldo, int senha) {
        this.setConta(conta);
        this.setSaldo(saldo);
        this.setSenha(senha);
    }

    public void Depositar(float qtd, int senha) {
        System.out.println("-------------- Cartão de " + this.conta.getNome() + " --------------");
        if(senha == this.getSenha()){
            this.saldo += qtd;
            System.out.println("R$ " + qtd + " depositados.\nSaldo atual: R$ " + this.getSaldo());
        }else{
            System.out.println("Senha Inválida!");
        }
    }

    public boolean Retirar(float qtd, int senha) {
        System.out.println("-------------- Cartão de " + this.conta.getNome() + " --------------");
        if(senha == this.getSenha()){
            if(this.getSaldo() - qtd < 0){
                System.out.println("Não é possível realizar o saque de R$ " + qtd + ", saldo atual de R$ " + this.getSaldo());
                return false;
            }else{
                this.saldo -= qtd;
                System.out.println("Saque de R$ " + qtd + " realizado\nSaldo atual: R$ " + this.getSaldo());
                return true;
            }
        }else{
            System.out.println("Senha Inválida!");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "conta=" + conta +
                ", senha=" + senha +
                ", saldo=" + saldo +
                '}';
    }
}
