package com.example.appestoque.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appestoque.R;

public class TelaUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_user);
    }

    public void sendToHomeEstoque(View view){
        Intent chamada = new Intent(this, HomeEstoque.class);
        startActivity(chamada);
    }

    public void sendToListaProduto (View view){
        Intent chamada = new Intent(this, ListaProduto.class);
        startActivity(chamada);
    }

    public void sendToIncluirProduto(View view){
        Intent chamada = new Intent(this, IncluirProduto.class);
        startActivity(chamada);
    }
}