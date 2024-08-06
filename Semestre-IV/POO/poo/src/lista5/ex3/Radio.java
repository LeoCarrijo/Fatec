package lista5.ex3;

public class Radio extends Produto{
    private String estacao, banda;

    public String getEstacao() {
        return estacao;
    }

    public void TrocarEstacao(String estacao) {
        this.estacao = estacao;
    }

    public String getBanda() {
        return banda;
    }

    public void TrocarBanda(String banda) {
        this.banda = banda;
    }

    public String Escutar(){
        return this.getBanda() + " " + this.getEstacao();
    }

    public Radio(int sku, int vol, String estacao, String banda) {
        super(sku, vol);
        this.TrocarEstacao(estacao);
        this.TrocarBanda(banda);
    }

    @Override
    public String toString() {
        return "Radio{" +
                "estacao='" + estacao + '\'' +
                ", banda='" + banda + '\'' +
                super.toString() +
                '}';
    }
}
