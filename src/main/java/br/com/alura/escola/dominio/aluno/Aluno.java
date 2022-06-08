package br.com.alura.escola.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

    //Entidade: é um termo genérico. No curso, é uma classe que tem um atributo que identifica unicamente cada objeto.

    //private Long id; //Se utilizassemos ID, estariamos amarrando o código com infraestrutura. E de acordo com CA, devemos desacoplar.
    //private String cpf; // Utilizamos então CPF pra ficar mais próximo do mundo real. Isso diferencia os alunos.
    private CPF cpf;
    private String nome;
    private Email email;
    private List<Telefone> telefones = new ArrayList<>(); //Já foi instanciado pois na hr de instancia o Aluno pra ele já ter uma lista vazia.

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public void adicionarTelefone(String ddd, String numero) {
        this.telefones.add(new Telefone(ddd, numero));
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Email getEmail() {
        return email;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }
}
