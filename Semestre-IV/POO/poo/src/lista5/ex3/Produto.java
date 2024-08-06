package lista5.ex3;

import java.util.Random;

public abstract class Produto {
    private int sku, vol;
    private String testado = "Não Testado";

    private Random random = new Random();

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public String getTestado() {
        return testado;
    }

    public void setTestado(String testado) {
        this.testado = testado;
    }

    public boolean TestarUnidade(){
        float n = random.nextFloat();
        float corte = 0.9f;
        return n <= corte;
    }

    public Produto(int sku, int vol) {
        this.setSku(sku);
        this.setVol(vol);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "sku=" + sku +
                ", vol=" + vol +
                ", testado='" + testado + '\'' +
                '}';
    }
}
