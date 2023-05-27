package com.mycompany.padrinhodobem;

public class Usuario {
    private int id;
    private String email;
    private String cpf;
    private String nome;
    private String password;
    // adicionar o tipo

    public Usuario(String email, String cpf, String nome, String password) {
        this.email = email;
        this.cpf = cpf;
        this.nome = nome;
        this.password = password;
    }

    public Usuario(int id, String email, String cpf, String nome, String password) {
        this.id = id;
        this.email = email;
        this.cpf = cpf;
        this.nome = nome;
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\nEmail: " + this.email + "\nCpf: " + this.cpf + "\nId: " + this.id;
    }
}
