package model;

public class Cliente {

    private String nome;
    private String cpf;
    private String email;
    private String telefone;


    public Cliente(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    @Override

    public String toString() {
        return "Nome: " + nome
         + "\nCPF: " + cpf +
         "\nE-mail: " + email
        + "Telefone: " + telefone;
    }
    

}
