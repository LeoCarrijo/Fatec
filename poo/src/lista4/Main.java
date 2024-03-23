package lista4;

import lista4.rh.Assistente;
import lista4.rh.Diretor;
import lista4.rh.Funcionario;
import lista4.rh.Gerente;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void exibirDados(Funcionario obj){
        System.out.println(obj.toString());
        System.out.println("Salário Final: " + obj.CalcularSalario());
    }

    public static void main(String[] args) {
        Assistente leonardo = new Assistente("leonardo", "Rua José Garcia Gomez 1000", "432.169.018-82", 1928.00f, 18);
        exibirDados(leonardo);
        Gerente arnaldo = new Gerente("Arnaldo", "Sla a rua mano", "321.321.321-20", 8000f, 2000);
        exibirDados(arnaldo);
        Diretor scott = new Diretor("Scott", "Sla a rua tbm", "123.123.123-21", 40000f, 35000);
        exibirDados(scott);

        List<Funcionario> funcs = new ArrayList<Funcionario>();
        funcs.add(leonardo);
        funcs.add(arnaldo);
        funcs.add(scott);

        for(Funcionario obj: funcs){
            exibirDados(obj);
        }
    }
}
