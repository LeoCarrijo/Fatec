package lista5.ex4_v2;

public class Pedra extends Coisa{

    @Override
    public void compara(Coisa c){
        if (c instanceof Pedra){
            System.out.println("Empate");
        }else if(c instanceof Tesoura){
            System.out.println("Pedra ganha da Tesoura");
        } else if(c instanceof Papel) {
            System.out.println("Pedra perde do Papel");
        }else{
            System.out.println("Jogada Inválida");
        }
    }
}
