package lista5.ex4_v2;

public class Tesoura extends Coisa{

    @Override
    public void compara(Coisa c) {
        if(c instanceof Tesoura){
            System.out.println("Empate");
        } else if(c instanceof Papel) {
            System.out.println("Tesoura ganha do Papel");
        }else if(c instanceof Pedra){
            System.out.println("Tesoura perde da Pedra");
        }else{
            System.out.println("Jogada Inválida");
        }
    }
}
