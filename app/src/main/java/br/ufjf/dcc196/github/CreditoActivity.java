package br.ufjf.dcc196.github;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreditoActivity extends AppCompatActivity {
    Button btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credito);
        btnVoltar = findViewById(R.id.buttonVoltarCredito);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreditoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}