package br.ufjf.dcc196.github;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nome;
    private String url;
    private String bio;
    private String cadastro;

    public Usuario(String nome, String url, String bio, String cadastro){
        this.nome = nome;
        this.url = url;
        this.bio = bio;
        this.cadastro = cadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCadastro() {
        return cadastro;
    }

    public void setCadastro(String cadastro) {
        this.cadastro = cadastro;
    }
}
