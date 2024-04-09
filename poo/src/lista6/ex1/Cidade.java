package lista6.ex1;

public class Cidade {
    public void contrata(Professor p){
        p.ensina();
        p.trabalha();
    }

    public void contrata(Empregado e){
        e.trabalha();
    }

    public void cobraDe(Contribuinte c){
        c.pegaIr();
    }

    public void registra(Cidadao c){
        c.tirarRg();
    }

    public void alimenta(Animal a){
        a.comer();
    }
}
