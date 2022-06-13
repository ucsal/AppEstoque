package com.example.appestoque.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appestoque.R;
import com.example.appestoque.model.Produto;
import com.example.appestoque.persistence.BancoDeDados;

public class RealizarVenda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar_venda);
    }

    public void vender(View view){
        EditText capturaCodigo = findViewById(R.id.editText_realizarInformarCodigo);
        EditText capturaQuantidade = findViewById(R.id.editTextNumber_realizarInformaQuantidade);

        //Verificando se o código e a quantidade estão vazios
        if(!capturaQuantidade.getText().toString().replaceAll(" ","").equals("0") && !capturaQuantidade.getText().toString().replaceAll(" ", "").equals("") && !capturaCodigo.getText().toString().replaceAll(" ", "").equals("")){

            //Variavel auxiliar utilizada para saber se foi encontrado algum objeto no Dao
            //Caso seja achado algum obbjeto ao final a váriavel será true;
            boolean achou = false;

            //Percorrendo o array para procurar o objeto
            BancoDeDados banco = BancoDeDados.getDbIntance(this.getApplicationContext());
            for(Produto p: banco.produtoDao().getAllProduto()){
            if(p.getCodigo().equalsIgnoreCase(capturaCodigo.getText().toString())){
                achou = true;
                int quantidadeInformada = Integer.parseInt(capturaQuantidade.getText().toString());

                //Conferindo se existe quantidade suficiente do produto para realizar a venda
                //Produto só pode ser vendido se a quantidade informada for <= quantidade de estoque
                if(quantidadeInformada <= p.getQuantidade()){
                    //Atualizando quantidade
                    p.setQuantidade(p.getQuantidade() - quantidadeInformada);
                    Toast.makeText(this,"A quantidade foi atualizada.",Toast.LENGTH_LONG).show();


                }else
                    Toast.makeText(this,"A quantidade informada é maior do que a quantidade em estoque.",Toast.LENGTH_LONG).show();
            break;

            }
        }

            //Conferindo se o objeto foi encontrado no banco de dados
            if(!achou){
                Toast.makeText(this,"O código informado não existe no banco de dados.",Toast.LENGTH_LONG).show();
            }

        }else
        Toast.makeText(this,"O código não pode ficar em branco e a quantidade não pode ser 0.",Toast.LENGTH_SHORT).show();

        //Limpando os campos
        capturaQuantidade.setText("");

        capturaCodigo.setText("");
    }
}