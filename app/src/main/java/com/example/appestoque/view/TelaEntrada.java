package com.example.appestoque.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appestoque.R;
import com.example.appestoque.model.Produto;
import com.example.appestoque.persistence.BancoDeDados;

import java.util.Random;

public class TelaEntrada extends AppCompatActivity {

    Random gerador = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
adicionarBanco();
       }

    public void sendToTelaUser(View view){
        Intent chamada = new Intent(this,TelaUser.class);
        startActivity(chamada);

    }

    public void adicionarBanco(){

        for(int i = 0; i < 30; i++){

            String aux = String.valueOf(i + 1);
            for(int j = aux.length(); j < 3; j++){
                aux = "0" + aux;
            }
            String codigoProduto = "PD" + aux;
            BancoDeDados banco = BancoDeDados.getDbIntance(this.getApplicationContext());
            Produto p = new Produto(codigoProduto, "Produto " + (i + 1), gerador.nextInt(1000) + 1);
            banco.produtoDao().addProduto(p);


        }


    }


}