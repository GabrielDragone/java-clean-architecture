package br.com.alura.escola.infra;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.AlunoNaoEncontradoException;
import br.com.alura.escola.dominio.aluno.AlunoRepository;
import br.com.alura.escola.dominio.aluno.CPF;

import java.util.ArrayList;
import java.util.List;

public class AlunoRepositoryEmMemoria implements AlunoRepository {

    private List<Aluno> matriculados = new ArrayList<>(); // Manipulamos a propriedade pra simular um banco.

    @Override
    public void matricular(Aluno aluno) {
        this.matriculados.add(aluno); // Adiciona o aluno passado na lista.
    }

    @Override
    public Aluno buscarAlunoPorCPF(CPF cpf) {
        return this.matriculados.stream() // API de stream do Java 8.
                .filter(alunoIterado -> alunoIterado.getCpf().equals(cpf.getNumero())) // Filtramos se o aluno iterado tem o mesmo cpf do que está sendo buscado.
                .findFirst() // Pegamos o primeiro resultado, pq não deve ter dois alunos com mesmo CPF.
                .orElseThrow(() -> new AlunoNaoEncontradoException(cpf)); // Se não achar nada, lança exception.
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return this.matriculados; // Retorna toda lista.
    }
}
