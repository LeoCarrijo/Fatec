package lista4.rh;

public class Diretor extends Funcionario {
    private float acoes;

    public Diretor(String nome, String endereco, String cpf, float salario, float acoes) {
        super(nome, endereco, cpf, salario);
        this.acoes = acoes;
    }

    public float getAcoes() {
        return acoes;
    }

    public void setAcoes(float acoes) {
        this.acoes = acoes;
    }

    @Override
    public String toString() {
        return "Diretor{" +
                "acoes=" + acoes +
                super.toString() +
                '}';
    }

    @Override
    public float CalcularSalario(){
        return super.CalcularSalario() + acoes;
    }
}