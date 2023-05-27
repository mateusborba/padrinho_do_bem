package com.mycompany.padrinhodobem;

public class Crianca {
    private int id;
    private String nome;
    private int idade;
    private String historia;
    private String local;

    public Crianca(String nome, String historia, String local, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.historia = historia;
        this.local = local;
    }

    public Crianca(int id, String nome, String historia, String local, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.historia = historia;
        this.local = local;
    }

    public String getNome() {
        return this.nome;
    }

    public int getId() {
        return this.id;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getLocal() {
        return this.local;
    }

    public String getHistoria() {
        return this.historia;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    @Override
    public String toString() {
        return "nome :" + this.nome + "\nid:" + this.id;
    }
}
