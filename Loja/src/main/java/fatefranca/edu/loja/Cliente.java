Package fatecfranca.edu.loja;

import jakarta.persistance.Table;

@Entity // Entidade de BD
@Table(name="cliente") // Tabela com nome "cliente"
public class Cliente {
    @Id // Chave primária
    @GeneratedValue(strategy = GenerationType.AUTO) // Gera automaticamente os valores
    private Long id;
    @Column(name="nome")
    private String nome;
    @Column(name="nota")
    private float nota;
    @Column(name="idade")
    private int idade;
    @Column(name="devedor")
    private boolean devedor;

    public Cliente(Long id, String nome, float nota, int idade, boolean devedor){
        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.idade = idade;
        this.devedor = devedor;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return this.nome
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public float getNota(){
        return this.nota
    }

    public void setNota(float nota){
        this.nota = nota;
    }

    public int getIdade(){
        return this.idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public boolean getDevedor(){
        return this.devedor;
    }

    public void setDevedor(boolean devedor){
        this.devedor = devedor;
    }
}

