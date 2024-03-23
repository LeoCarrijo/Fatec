package lista5.ex2;

public class Aniversario extends CartaoWeb {
    @Override
    public void showMessage() {
        System.out.println("No seu aniversário, desejo que cada momento seja repleto de sorrisos, alegria e " +
                "celebração. Que este dia especial traga novas aventuras e memórias inesquecíveis. Feliz aniversário!");
    }

    public Aniversario(String destinatario) {
        this.setDestinatario(destinatario);
    }
}
