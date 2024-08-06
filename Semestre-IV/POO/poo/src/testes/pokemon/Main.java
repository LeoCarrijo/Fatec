package testes.pokemon;

import testes.pokemon.ataques.Ataque;
import testes.pokemon.ataques.FireBlast;
import testes.pokemon.ataques.FirePunch;
import testes.pokemon.pokemons.Charmander;
import testes.pokemon.pokemons.Pokemon;

public class Main {
    public static void main(String[] args) {
        Ataque fireBlast = new FireBlast();
        Ataque firePunch = new FirePunch();
        Pokemon charmander = new Charmander(fireBlast);
        charmander.setAtaque(firePunch);
        System.out.println(charmander.toString());
    }
}
