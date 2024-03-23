package lista5.ex2;

public class DiaDosNamorados extends CartaoWeb {
    @Override
    public void showMessage() {
        System.out.println("Neste Dia dos Namorados, quero expressar o quanto você significa para mim. Você ilumina " +
                "cada dia com seu sorriso e enche meu coração de alegria. Que nosso amor continue a florescer como as" +
                " mais belas rosas do jardim do amor.");
    }

    public DiaDosNamorados(String destinatario) {
        this.setDestinatario(destinatario);
    }
}
