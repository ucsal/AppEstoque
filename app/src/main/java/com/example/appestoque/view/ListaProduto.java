package com.example.appestoque.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appestoque.R;
import com.example.appestoque.model.Produto;
import com.example.appestoque.persistence.BancoDeDados;

import java.util.ArrayList;
import java.util.List;

public class ListaProduto extends AppCompatActivity {
   List<Produto> produtoList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produto);

        BancoDeDados banco = BancoDeDados.getDbIntance(this.getApplicationContext());

        produtoList = banco.produtoDao().getAllProduto();


        RecyclerView recyclerView = findViewById(R.id.RecycleView_listaListaProdutos);
        AdapterListaProduto adaptador = new AdapterListaProduto(produtoList);
        recyclerView.setAdapter(adaptador);
      recyclerView.setLayoutManager(new GridLayoutManager(this,1));

    }
}