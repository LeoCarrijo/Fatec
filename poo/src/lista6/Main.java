package lista6;

public class Main {
    public static void main(String[] args) {
        AtletaVoleiBasquete avb = new AtletaVoleiBasquete();
        avb.atacar(); avb.baterLanceLivre();
        avb.pegarRebote(); avb.sacar();

        JogadorBasquete jb = new AtletaVoleiBasquete();
        jb.baterLanceLivre(); jb.pegarRebote();
    }
}
