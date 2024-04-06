package testes.pokemon.ataques;

import testes.pokemon.tipos.Tipo;

public abstract class Ataque {
    protected String nome;
    protected float dano, precisao;
    protected byte pp;
    protected char categoria;
    private char[] categoriasPermitidas = {'s', 'f', 'e'};
    protected Tipo tipo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getDano() {
        return dano;
    }

    public void setDano(float dano) {
        this.dano = dano;
    }

    public float getPrecisao() {
        return precisao;
    }

    public void setPrecisao(float precisao) {
        if(precisao > 0 && precisao <= 100) this.precisao = precisao;
        else System.out.println("Valor de Precisão Inválido!\nApenas entre 1-100%");
    }

    public byte getPp() {
        return pp;
    }

    public void setPp(byte pp) {
        this.pp = pp;
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        categoria = Character.toLowerCase(categoria);
        boolean existe = false;
        for(char cat : categoriasPermitidas){
            if(categoria == cat){
                existe = true;
                if(existe) break;
            }
        }
        if(existe) this.categoria = categoria;
        else System.out.println("Categoria Inexistente");
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Ataque(String nome, float dano, float precisao, byte pp, char categoria, Tipo tipo) {
        this.setNome(nome);
        this.setDano(dano);
        this.setPrecisao(precisao);
        this.setPp(pp);
        this.setCategoria(categoria);
        this.setTipo(tipo);
    }

    @Override
    public String toString() {
        return "Ataque{" +
                "nome='" + nome + '\'' +
                ", dano=" + dano +
                ", precisao=" + precisao +
                ", pp=" + pp +
                ", categoria=" + categoria +
                ", tipo=" + tipo +
                '}';
    }
}
