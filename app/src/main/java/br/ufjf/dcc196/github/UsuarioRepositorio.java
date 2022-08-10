package br.ufjf.dcc196.github;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UsuarioRepositorio {
    private Context context;
    private SharedPreferences preferences;
    private final String PREFERENCES_NAME = "br.ufjf.dcc196.josueodh.github";
    private final String USUARIO_KEY = "USUARIO_KEY";

    public UsuarioRepositorio(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public void setUsuario(List<Usuario> usuario){
        Gson gson = new GsonBuilder().serializeNulls().create();
        Type type = new TypeToken<List<Usuario>>(){}.getType();
        String jsonUsuario = gson.toJson(usuario, type);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(USUARIO_KEY, jsonUsuario);
        editor.commit();
    }

    public List<Usuario> getUsuario(){
        Gson gson = new Gson();
        List<Usuario> usuariosFromShared = new ArrayList<>();
        String jsonPreferences = preferences.getString(USUARIO_KEY, "");
        Type type = new TypeToken<List<Usuario>>(){}.getType();
        usuariosFromShared = gson.fromJson(jsonPreferences, type);
        Collections.sort(usuariosFromShared);
        return usuariosFromShared;
    }




}
