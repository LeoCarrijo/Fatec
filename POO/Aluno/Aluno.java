package Web.Aluno;

public class Aluno {
    private int numeroAluno, idade;
    private String nome;
    private float p1, p2;

    public Aluno(int numeroAluno, int idade, String nome, float p1,float p2) {
        this.numeroAluno = numeroAluno;
        this.idade = idade;
        this.nome = nome;
        this.p1 = p1;
        this.p2 = p2;
    }

    public void dadosAlunos(){
        System.out.println("\nNº do Aluno: " + this.numeroAluno +
                "\nNome: " + this.nome +
                "\nIdade: " + this.idade);
    }

    public float notaFinal(){
        return (this.p1 + this.p2) / 2;
    }

    public void passou(){
        if (this.notaFinal() >= 6) {
            System.out.println("\n" + this.nome + " Passou");
        } else {
            System.out.println("\n" + this.nome + " Reprovou");
        }
    }
}
