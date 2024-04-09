package testes.pokemon.pokemons;

import testes.pokemon.ataques.Ataque;
import testes.pokemon.tipos.Tipo;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Pokemon{
    protected String nome;
    protected int hp;
    protected Tipo tipo1, tipo2;
    protected ArrayList<Ataque> ataques = new ArrayList<Ataque>();
    protected Scanner input = new Scanner(System.in);

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Tipo getTipo1() {
        return tipo1;
    }

    public void setTipo1(Tipo tipo1) {
        this.tipo1 = tipo1;
    }

    public Tipo getTipo2() {
        return tipo2;
    }

    public void setTipo2(Tipo tipo2) {
        if(tipo2 == this.getTipo1()){
            System.out.println(this.getNome() + " já possui o tipo " + tipo2);
        }else{
            this.tipo2 = tipo2;
        }
    }

    public void setAtaque(Ataque ataque) {
        int opc = 0;
        if(ataques.size() == 4){
            System.out.println("O Pokemon " + this.getNome() + " já tem os 4 slots de ataque" +
                    "\nQual ataque deseja substituir?" +
                    "\n(Insira 0 para cancelar a operação)");
            for (int i = 0; i < ataques.size(); i++) {
                System.out.println(i+1 + ". " + ataques.get(i).getNome());
            }
            do {
                opc = input.nextInt();
                if(opc == 0){
                    System.out.println("Operação cancelada");
                    break;
                }
                if(opc > 4 || opc < 0){
                    System.out.println("Insira um valor entre 0 e 4");
                }
            }while (opc > 4 || opc < 0);
            ataques.add(opc, ataque);
        }else{
            ataques.add(ataque);
            System.out.println(ataque.getNome() + " adicionado na posição " + ataques.size());
        }
    }

    public Pokemon(String nome, int hp, Tipo tipo1, Tipo tipo2, Ataque ataque) {
        this.setNome(nome);
        this.setHp(hp);
        this.setTipo1(tipo1);
        this.setTipo2(tipo2);
        this.setAtaque(ataque);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nome='" + nome + '\'' +
                ", hp=" + hp +
                ", tipo1=" + tipo1 +
                ", tipo2=" + tipo2 +
                ", ataques=" + ataques +
                '}';
    }
}
