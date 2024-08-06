package testes.pokemon.pokemons;

import testes.pokemon.ataques.Ataque;
import testes.pokemon.tipos.Fogo;
import testes.pokemon.tipos.Tipo;

public class Charmander extends Pokemon{

    public Charmander(Ataque ataque) {
        super("Charmander", 39, new Fogo(), null, ataque);
    }
}
