package br.com.alura.escola.dominio.aluno;

import java.util.List;

public interface AlunoRepository {

    public void matricular(Aluno aluno); //Perceba que não temos implementação.

    public Aluno buscarAlunoPorCPF(CPF cpf);

    public List<Aluno> listarTodosAlunosMatriculados();

    //...
}
