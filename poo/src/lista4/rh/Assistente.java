package lista4.rh;

public class Assistente extends Funcionario{
    private float horaExtra;

    public Assistente(String nome, String endereco, String cpf, float salario, float horaExtra){
        super(nome, endereco, cpf, salario); // Reutilização de código
        this.horaExtra = horaExtra;
    }

    public float getHoraExtra() {
        return horaExtra;
    }

    public void setHoraExtra(float horaExtra) {
        this.horaExtra = horaExtra;
    }

    @Override
    public String toString() {
        return "Assistente{" +
                "horaExtra=" + horaExtra +
                super.toString() +
                '}';
    }

    @Override
    public float CalcularSalario(){
        return super.CalcularSalario() + horaExtra * 40;
    }
}
