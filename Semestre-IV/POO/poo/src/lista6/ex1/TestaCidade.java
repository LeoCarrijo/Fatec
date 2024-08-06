package lista6.ex1;

public class TestaCidade {
    public static void main(String[] args) {
        Pessoa fulano = new Pessoa("123", "456");
        Cidade franca = new Cidade();
        franca.contrata(fulano);
        franca.contrata((Empregado) fulano);
        franca.cobraDe(fulano);
        franca.registra(fulano);
        franca.alimenta(fulano);
    }
}
