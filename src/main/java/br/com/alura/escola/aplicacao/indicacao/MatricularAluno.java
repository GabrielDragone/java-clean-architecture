package br.com.alura.escola.aplicacao.indicacao;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.AlunoRepository;

// Imagina como sendo um Service, onde toodo o fluxo está isolado dentro dessa classe, pois é de responsabilidade dela.
// Esse é o padrão Use Case:
public class MatricularAluno {

    private final AlunoRepository repository;

    // A responsabilidade de instanciar e passar o Repositorio utilizado será da classe que utilizará o MatricularAluno:
    public MatricularAluno(AlunoRepository repository) {
        this.repository = repository;
    }

    // COMMAND: Padrão de projeto onde temos a classe e o método executar da mesma, que se pararmos para ler, fica claro o entendimento:
//    public void matricular(MatricularAlunoDto dados) {
    public void executar(MatricularAlunoDto dados) {
        Aluno novoAluno = dados.criarAluno(); // Aqui dentro não está sendo passado nenhum parâmetro, pois o DTO já está populado.
        repository.matricular(novoAluno);
    }

}
