package lista5.ex4;

import java.util.ArrayList;
import java.util.Random;

public class Jogo {
    public static String VerificadorVitoria(Coisa c1, Coisa c2){
        if(Quebra(c1, c2)) return "Pedra quebra Tesoura";
        if(Envolve(c1, c2)) return "Papel envolve Pedra";
        if(Corta(c1, c2)) return "Tesoura corta Papel";
        if(Empate(c1, c2)) return "Empate";
        return "Caso Inválido";
    }

    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Coisa> opcoes = new ArrayList<Coisa>();
        Coisa pedra = new Pedra();
        Coisa papel = new Papel();
        Coisa tesoura = new Tesoura();
        opcoes.add(pedra);
        opcoes.add(papel);
        opcoes.add(tesoura);

        for (int i = 0; i < 10; i++) {
            Coisa opc1 = opcoes.get(random.nextInt(opcoes.size()));
            Coisa opc2 = opcoes.get(random.nextInt(opcoes.size()));
            System.out.println(opc1);
            System.out.println(opc2);
            System.out.println(VerificadorVitoria(opc1, opc2) + "\n");
        }
    }



    public static boolean Quebra(Coisa c1, Coisa c2){
        if((c1.getTipo() == "Pedra" && c2.getTipo() == "Tesoura") ||
                (c1.getTipo() == "Tesoura" && c2.getTipo() == "Pedra")){
            return true;
        }
        return false;
    }

    public static boolean Envolve(Coisa c1, Coisa c2){
        if((c1.getTipo() == "Papel" && c2.getTipo() == "Pedra") ||
                (c1.getTipo() == "Pedra" && c2.getTipo() == "Papel")){
            return true;
        }
        return false;
    }

    public static boolean Corta(Coisa c1, Coisa c2){
        if((c1.getTipo() == "Tesoura" && c2.getTipo() == "Papel") ||
                (c1.getTipo() == "Papel" && c2.getTipo() == "Tesoura")){
            return true;
        }
        return false;
    }

    public static boolean Empate(Coisa c1, Coisa c2){
        if(c1.getTipo() == c2.getTipo()) return true;
        return false;
    }
}
