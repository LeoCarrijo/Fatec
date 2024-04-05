package lista5.ex4_v2;

public class Papel extends Coisa{
    @Override
    public void compara(Coisa c) {
        if(c instanceof Papel){
            System.out.println("Empate");
        }else if(c instanceof Pedra){
            System.out.println("Papel ganha da Pedra");
        }else if(c instanceof Tesoura){
            System.out.println("Papel perde da Tesoura");
        }else{
            System.out.println("Jogada Inválida");
        }
    }
}
