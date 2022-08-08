package br.ufjf.dcc196.github;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nome;
    private String login;
    private String bio;
    private String cadastro;
    private int seguidores;
    private String avatar;

    public Usuario(String nome, String login, String bio, String cadastro, Integer seguidores, String avatar){
        this.nome = nome;
        this.login = login;
        this.bio = bio;
        this.cadastro = cadastro;
        this.avatar =avatar;
        this.seguidores = seguidores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public int getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(int seguidores) {
        this.seguidores = seguidores;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
