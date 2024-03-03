package Web.aluno;

public class TestaAluno {

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno(1, 20, "Francisco", 6, 5);

        aluno1.dadosAlunos();
        System.out.println("\nMédia: " + aluno1.notaFinal());
        aluno1.passou();
    }
}
