package br.com.alura;

//Value Object:
public class Telefone {
    private String ddd; //Tem que ter 2 digitos.
    private String numero; //Tem que ter 8 ou 9 digitos.

    public Telefone(String ddd, String numero) {
        if (ddd == null || ddd.length() != 2) {
            throw new IllegalArgumentException("DDD inválido!");
        }

        if (numero == null || (numero.length() != 8 && numero.length() != 9)) {
            throw new IllegalArgumentException("Número inválido!");
        }

        this.ddd = ddd;
        this.numero = numero;
    }
}
