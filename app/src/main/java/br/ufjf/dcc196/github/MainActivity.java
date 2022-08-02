package br.ufjf.dcc196.github;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editTextPesquisa;
    Button btnCreditos;

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
        try{
            System.out.println(editTextPesquisa.getText().toString());
        }catch (Exception e){
            editTextPesquisa.requestFocus();
        }
    }

}