package br.ufjf.dcc196.github;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    UsuarioRepositorio repo;
    EditText editTextPesquisa;
    TextView textViewUsuarioNome;
    TextView textViewUsuarioLogin;
    TextView textViewUsuarioBio;
    TextView textViewUsuarioCadastro;
    List<Usuario> usuarios;
    Button btnCreditos;
    Button btnRanking;
    OkHttpClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repo = new UsuarioRepositorio(getApplicationContext());
        usuarios = new ArrayList<Usuario>() {{
            add(new Usuario("The Laravel Framework", "laravel", "Laravel is a web ecosystem full of delightful tools that are supercharged for developer happiness and productivity.", "2011-08-04T03:44:54Z", 79, "https://avatars.githubusercontent.com/u/958072?v=4"));
            add(new Usuario("React Community", "reactjs", "React website and its localizations", "2014-01-15T17:46:37Z", 85, "https://avatars.githubusercontent.com/u/6412038?v=4"));
            add(new Usuario("Node.js", "nodejs", null, "2014-11-25T17:10:50Z", 197, "https://avatars.githubusercontent.com/u/9950313?v=4"));
            add(new Usuario("Vuejs", "vuejs", "All Over the World", "2013-12-07T06:13:00Z", 118, "https://avatars.githubusercontent.com/u/6128107?v=4"));
            add(new Usuario("Django", "django", null, "2008-10-06T19:43:18Z", 21, "https://avatars.githubusercontent.com/u/27804?v=4"));
        }};
        repo.setUsuario(usuarios);
        btnCreditos = findViewById(R.id.buttonCreditos);
        btnCreditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreditoActivity.class);
                startActivity(intent);
            }
        });

        btnRanking = findViewById(R.id.buttonRanking);
        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RankingActivity.class);
                startActivity(intent);
            }
        });

    }

    public void pesquisarGitHub(View view){
        editTextPesquisa = findViewById(R.id.editTextPesquisar);
        client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/users/" + editTextPesquisa.getText().toString())
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            public void onResponse(Call call, Response response) throws IOException {
                usuarios = repo.getUsuario();
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();
                   String[] result = myResponse.split(",");
                    textViewUsuarioBio = findViewById(R.id.textViewUsuarioBio);
                    textViewUsuarioNome = findViewById(R.id.textViewUsuarioNome);
                    textViewUsuarioLogin = findViewById(R.id.textViewUsuarioLogin);
                    textViewUsuarioCadastro = findViewById(R.id.textViewUsuarioCadastro);
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                           String login = result[0].replace("\"", "").replace("login: ", "");
                            String nome = result[18].replace("\"", "").replace("name:", "");
                            String bio = result[24].replace("\"", "").replace("bio:", "");
                            String cadastro = result[30].replace("\"", "").replace("created_at:", "");
                            String avatar = result[3].replace("\"", "").replace("avatar_url:", "");
                            String seguidores = (result[28].replace("\"", "").replace("followers:", ""));
                            Usuario usuario = new Usuario(nome, login, bio,cadastro, Integer.parseInt(seguidores),avatar);
                            usuarios.add(usuario);
                            repo.setUsuario(usuarios);
                            textViewUsuarioBio.setText("Bio: " + usuario.getBio());
                            textViewUsuarioNome.setText("Nome: " + usuario.getNome());
                            textViewUsuarioLogin.setText("Login: " + usuario.getLogin());
                            textViewUsuarioCadastro.setText("Cadastro: "+usuario.getCadastro());
                        }
                    });
                }
            }
        });

    }


}