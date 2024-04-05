package lista6;

public class AtletaVoleiBasquete implements JogadorVolei, JogadorBasquete{
    @Override
    public void baterLanceLivre() {
        System.out.println("Atleta do volei e do basquete bateu lance livre");
    }
    @Override
    public void pegarRebote() {
        System.out.println("Atleta do volei e do basquete pegou rebote");
    }
    @Override
    public void sacar() {
        System.out.println("Atleta do volei e do basquete sacou");
    }
    @Override
    public void atacar() {
        System.out.println("Atleta do volei e do basquete atacou");
    }
}
