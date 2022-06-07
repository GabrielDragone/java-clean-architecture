package br.com.alura;

public class FabricaDeAluno {

    private Aluno aluno;

    public FabricaDeAluno comNomeCFPEmail(String nome, String cpf, String email) {
        this.aluno = new Aluno(new CPF(cpf), nome, new Email(email));
        return this; //Retornando this para fazer encadeamento de método.
    }

    public FabricaDeAluno comTelefone(String ddd, String numero) { //Existe um problema se chamarmos primeiramente esse método, pois o aluno não esta instanciado ainda. Entao daria pra melhorar a classe.
        this.aluno.adicionarTelefone(ddd, numero);
        return this; //Retornando this para fazer encadeamento de método.
    }

    public Aluno criar() { //Retorna o Aluno que foi criado.
        return this.aluno;
    }

}
