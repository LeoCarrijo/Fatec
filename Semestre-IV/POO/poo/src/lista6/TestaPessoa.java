package lista6;

import lista6.ex1.Contribuinte;
import lista6.ex1.Pessoa;
import lista6.ex1.Professor;

public class TestaPessoa {
    public static void main(String args[]){
        Pessoa objPessoa = new Pessoa("123", "456");
        objPessoa.ensina(); objPessoa.trabalha();
        objPessoa.tiraCpf(); objPessoa.pegaIr();
        objPessoa.tirarRg(); objPessoa.vota();
        objPessoa.comer(); objPessoa.respira();

        Contribuinte objContribuinte = new Pessoa("234", "567");
        objContribuinte.pegaIr();
        objContribuinte.tiraCpf();

        Professor objProfessor = new Pessoa("345", "678");
        objProfessor.ensina();
    }
}
