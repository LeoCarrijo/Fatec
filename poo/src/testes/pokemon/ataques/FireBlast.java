package testes.pokemon.ataques;

import testes.pokemon.tipos.Fogo;
import testes.pokemon.tipos.Tipo;

public class FireBlast extends Ataque{
    public FireBlast() {
        super("Fire Blast", 40f, 85f, (byte) 5, 'e', new Fogo());
    }
}
