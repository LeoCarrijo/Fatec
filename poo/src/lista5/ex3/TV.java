package lista5.ex3;

public class TV extends Produto{
    private String canal;

    public String Assistir() {
        return canal;
    }

    public void TrocarCanal(String canal) {
        this.canal = canal;
    }

    public TV(int sku, int vol, String canal) {
        super(sku, vol);
        this.TrocarCanal(canal);
    }

    @Override
    public String toString() {
        return "TV{" +
                "canal='" + canal + '\'' +
                super.toString() +
                '}';
    }
}
