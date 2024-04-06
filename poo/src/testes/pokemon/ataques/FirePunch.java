package testes.pokemon.ataques;

import testes.pokemon.tipos.Tipo;

public class FirePunch extends Ataque{
    public FirePunch(String nome, float dano, float precisao, byte pp, char categoria, Tipo tipo) {
        super(nome, dano, precisao, pp, categoria, tipo);
    }
}
