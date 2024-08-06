package lista5.ex2;

public class Natal extends CartaoWeb {
    @Override
    public void showMessage() {
        System.out.println("Querido(a), " + destinatario +
                "\nQue a magia do Natal encha seu coração de alegria e esperança. Que os momentos felizes e " +
                "as lembranças deste ano sejam apenas o começo de um novo ano repleto de felicidade. Feliz Natal!");
    }

    public Natal(String destinatario) {
        super(destinatario);
    }

    @Override
    public String toString() {
        return "Natal{" +
                "destinatario='" + destinatario + '\'' +
                '}';
    }
}
