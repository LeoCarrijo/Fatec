package Web.Rio;

public class Rio {
    private String nome;
    private float nivel;
    private boolean poluido;

    public Rio(String nome, float nivel, boolean poluido){
        this.nome = nome;
        this.nivel = nivel;
        this.poluido = poluido;
    }

    public void chover(float mms){
        this.nivel += mms / 10;
        System.out.println("\n" + mms + "mm choveram (+1M por 10mm)" +
                "\nNível atual do Rio: " + this.nivel + "M");
    }

    public void ensolarar(float hrs){
        this.nivel -= hrs;
        System.out.println("\n" + hrs + "Hrs de Sol (-1M por Hr de Sol)" +
                "\nNível atual do Rio: " + this.nivel + "M");
    }

    public void limpar(){
        this.poluido = false;
        System.out.println("\nO rio agora foi limpo");
    }

    public void sujar(){
        this.poluido = true;
        System.out.println("\nO rio agora foi poluído");
    }

    public void mostra(){
        String msg = "";
        if(this.poluido){
            msg = "Rio Poluído";
        }else{
            msg = "Rio Limpo";
        }
        System.out.println("\nNome do Rio: " + this.nome +
                "\nNível: " + this.nivel +
                "\n" + msg);
    }
}
