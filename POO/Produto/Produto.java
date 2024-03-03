package Web.Produto;

public class Produto {
    private int id, qtde;
    private String descricao;
    private float preco;

    public Produto(int id, int qtde, String descricao, float preco){
        this.id = id;
        this. qtde = qtde;
        this.descricao = descricao;
        this.preco = preco;
    }

    public void comprar(int qtd){
        this.qtde += qtd;
        System.out.println("\n" + qtd + " produtos comprados" +
                "\nEstoque atual: " + this.qtde);
    }

    public void vender(int qtd){
        this.qtde -= qtd;
        System.out.println("\n" + qtd + " produtos vendidos" +
                "\nEstoque atual: " + this.qtde);
    }

    public void subir(float acre){
        this.preco += acre;
        System.out.println("\nR$" + acre + " de acréscimo" +
                "\nPreço atual: " + this.preco);
    }

    public void descer(float desc){
        this.preco -= desc;
        System.out.println("\nR$" + desc + " de desconto" +
                "\nPreço atual: " + this.preco);
    }

    public void mostra(){
        System.out.println("\nID: " + this.id +
                "\nDescrição: " + descricao +
                "\nQuantidade em Estoque: " + qtde +
                "\nPreço: " + preco);
    }
}
