package br.ufjf.dcc196.github;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Usuario implements Comparable<Usuario> {
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Calendar calendar = new GregorianCalendar();
        sdf.format(calendar.getTime()).toString();


        return sdf.format(calendar.getTime()).toString();
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

    public int compareTo(Usuario outroUsuario) {
        if (this.seguidores > outroUsuario.getSeguidores()) {
            return -1;
        } if (this.seguidores < outroUsuario.getSeguidores()) {
            return 1;
        }
        return 0;
    }
}
