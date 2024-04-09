package testes.pokemon.ataques;

import testes.pokemon.tipos.Fogo;

public class FirePunch extends Ataque{
    public FirePunch() {
        super("Fire Punch", 75f, 100f, (byte) 15, 'f', new Fogo());
    }
}
