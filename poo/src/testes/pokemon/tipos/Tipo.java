package testes.pokemon.tipos;

public abstract class Tipo {
    protected float DanoBonus;

    public float getDanoBonus() {
        return DanoBonus;
    }

    public void setDanoBonus(float danoBonus) {
        DanoBonus = danoBonus;
    }

    protected Tipo(float danoBonus) {
        this.setDanoBonus(danoBonus);
    }
}
