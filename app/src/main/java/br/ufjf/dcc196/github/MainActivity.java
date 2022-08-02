package br.ufjf.dcc196.github;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    EditText editTextPesquisa;
    Button btnCreditos;
    OkHttpClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreditos = findViewById(R.id.buttonCreditos);
        btnCreditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreditoActivity.class);
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
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();
                    Gson gson = new Gson();

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            System.out.println();
                        }
                    });
                }
            }
        });

    }


}