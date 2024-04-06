package lista6.ex1;

public class Pessoa extends Animal implements Cidadao, Contribuinte, Professor{
    private String rg, cpf;

    public Pessoa(){
        super();
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Pessoa(String rg, String cpf){
        this.setRg(rg);
        this.setCpf(cpf);
    }

    @Override
    public void vota() {

    }

    @Override
    public void tirarRg() {

    }

    @Override
    public void pegaIr() {

    }

    @Override
    public void tiraCpf() {

    }

    @Override
    public void trabalha() {

    }

    @Override
    public void ensina() {

    }
}
