package com.example.appestoque.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appestoque.R;
import com.example.appestoque.model.Produto;
import com.example.appestoque.persistence.BancoDeDados;

public class IncluirProduto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incluir_produto);
    }

    public void incluirProduto(View view){
        EditText capturaCodigo = findViewById(R.id.editTextText_incluirInformarCodigo);
        EditText capturaNome = findViewById(R.id.editTextText_incluirInformarNome);
        EditText capturaQuantidade = findViewById(R.id.editTextNumber_incluirInformarQuantidade);


        //Verificando se nome e codigo estão vazios
        if(!capturaCodigo.getText().toString().replaceAll(" ", "").equals("") && !capturaNome.getText().toString().replaceAll(" ","").equals("")){
           String codigo = capturaCodigo.getText().toString();
           String nome = capturaNome.getText().toString();
            int quantidade;
           //Caso a quantidade esteja em branco significa que ela é 0
           if(capturaQuantidade.getText().toString().equals("")){
               quantidade = 0;
           }
           else quantidade = Integer.parseInt(capturaQuantidade.getText().toString());


            //Fazendo tentativa de inserir objeto no banco e conferindo se foi adicionado
            BancoDeDados banco = BancoDeDados.getDbIntance(this.getApplicationContext());
            banco.produtoDao().addProduto(new Produto(codigo,nome,quantidade));

                //Limpando os campos
                Toast.makeText(this,"Produto adicionado.",Toast.LENGTH_LONG).show();
                capturaCodigo.setText("");
                capturaNome.setText("");
                capturaQuantidade.setText("");



        }else
            Toast.makeText(this,"Os campos de Código e Nome não podem ficar vazios.",Toast.LENGTH_LONG).show();

    }


}