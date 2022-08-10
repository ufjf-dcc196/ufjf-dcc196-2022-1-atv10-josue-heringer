package br.ufjf.dcc196.github;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

public class RankingActivity extends AppCompatActivity {
    private RecyclerView recyclerViewRanking;
    List<Usuario> usuarios;
    UsuarioRepositorio repo;
    private ItemTouchHelper.SimpleCallback touchHelperCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        repo = new UsuarioRepositorio(getApplicationContext());
        usuarios = repo.getUsuario();
        recyclerViewRanking = findViewById(R.id.recyclerViewRanking);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewRanking.setLayoutManager(layoutManager);

        UsuarioAdapter usuarioAdapter = new UsuarioAdapter(usuarios);

        recyclerViewRanking.setAdapter(usuarioAdapter);

        touchHelperCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.ACTION_STATE_IDLE, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                usuarios.remove(position);
                repo.setUsuario(usuarios);usuarios = repo.getUsuario();
                usuarioAdapter.notifyItemRemoved(position);

            }
        };
        new ItemTouchHelper((touchHelperCallback)).attachToRecyclerView(recyclerViewRanking);

    }
}