package lista3.rede;

public class Main {
    public static void main(String[] args) {
        Pessoa leonardo = new Pessoa(1, "LeoCarrijo", "@LeoCarrijo");
        Pessoa hugo = new Pessoa(2, "HugoIII", "@HugoIII");
        Mensagem txtLeo1 = new Mensagem(11, "Texto Leonardo 1.1");
        Mensagem txtLeo2 = new Mensagem(12, "Texto Leonardo 1.2");
        Mensagem txtHugo1 = new Mensagem(21, "Texto Hugo 2.1");
        Mensagem txtHugo2 = new Mensagem(22, "Texto Hugo 2.2");
        Forum index = new Forum(1, "Index", "http://127.0.0.1/");

        leonardo.addMensagem(txtLeo1);
        leonardo.insertMensagem(txtLeo2, 0);
        hugo.addMensagem(txtHugo1);
        hugo.insertMensagem(txtHugo2, 0);
        System.out.println(leonardo.toString());
        leonardo.toStringMessages();
        System.out.println(hugo.toString());
        hugo.toStringMessages();
        leonardo.popMensagem();
        hugo.deleteMensagem(0);
        leonardo.toStringMessages();
        hugo.toStringMessages();

        index.addMensagem(txtLeo1);
        index.addMensagem(txtLeo2);
        index.addMensagem(txtHugo1);
        index.addMensagem(txtHugo2);
        System.out.println(index.toString());
        index.toStringMessages();
    }
}
