package lista5.ex3;

public class Controle {


    public Controle() {
    }

    public void TestarProduto(Produto prod){
        if(prod.TestarUnidade()){
            prod.setTestado("Aprovado");
        }else{
            prod.setTestado("Reporvado");
        }
        System.out.println(prod.toString());
    }
}
