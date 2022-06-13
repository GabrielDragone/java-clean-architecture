package br.com.alura.escola.dominio.aluno;

// Essa classe deverá ser implementada pela camada de Infraestrutura.
public interface CifradorDeSenha {

    String cifrarSenha(String senha);

    boolean validarSenhaCifrada(String senhaCifrada, String senha);

}
