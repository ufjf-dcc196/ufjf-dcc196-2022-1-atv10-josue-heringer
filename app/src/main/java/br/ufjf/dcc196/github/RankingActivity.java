package br.ufjf.dcc196.github;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RankingActivity extends AppCompatActivity {
    private RecyclerView recyclerViewRanking;
    List<Usuario> usuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        recyclerViewRanking = findViewById(R.id.recyclerViewRanking);
        usuarios = new ArrayList<Usuario>(){{
            add(new Usuario("nome", "login", "bio", "cadastro", 23,"https://avatars.githubusercontent.com/u/43760220"));
            add(new Usuario("nome", "login", "bio", "cadastro", 23,"https://avatars.githubusercontent.com/u/43760220"));
            add(new Usuario("nome", "login", "bio", "cadastro", 23,"https://avatars.githubusercontent.com/u/43760220"));
            add(new Usuario("nome", "login", "bio", "cadastro", 23,"https://avatars.githubusercontent.com/u/43760220"));
            add(new Usuario("nome", "login", "bio", "cadastro", 23,"https://avatars.githubusercontent.com/u/43760220"));
        }};

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewRanking.setLayoutManager(layoutManager);

        UsuarioAdapter usuarioAdapter = new UsuarioAdapter(usuarios);

        recyclerViewRanking.setAdapter(usuarioAdapter);

    }
}