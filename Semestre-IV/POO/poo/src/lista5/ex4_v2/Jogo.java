package lista5.ex4_v2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Jogo {

    public static void main(String[] args) {
        String userChoice = JOptionPane.showInputDialog("Digite 0. Papel 1. Pedra 2. Tesoura");
        Coisa user;
        switch(userChoice){
            case "0": user = new Papel(); break;
            case "1": user = new Pedra(); break;
            case "2": user = new Tesoura(); break;
            default: user = new Papel();
        }
        // escolha PC
        Random random = new Random();
        int pcChoice = random.nextInt(3); // gera 0, 1 ou 2
        Coisa pc;
        switch(pcChoice){
            case 0: pc = new Papel(); break;
            case 1: pc = new Pedra(); break;
            case 2: pc = new Tesoura(); break;
            default: pc = new Papel();
        }

        user.compara(pc);
    }
}
