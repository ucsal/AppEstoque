package com.example.appestoque.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appestoque.R;
import com.example.appestoque.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class AdapterListaProduto extends RecyclerView.Adapter<AdapterListaProduto.CustomViewHolder> {
    private List<Produto> produtoList;

    public AdapterListaProduto(List<Produto> produtoList){
        this.produtoList = produtoList;
    }






    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_lista_produto, parent, false);
        return new AdapterListaProduto.CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int i) {
        holder.getNome().setText(produtoList.get(i).getCodigo() + " - " + produtoList.get(i).getNome());
        holder.getQuantidade().setText(String.valueOf(produtoList.get(i).getQuantidade()));



    }

    @Override
    public int getItemCount() {
        return produtoList.size();
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        private TextView nome;
        private TextView quantidade;




        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.textView_listaLayoutNomeProduto);
           quantidade = itemView.findViewById(R.id.textView_listaLayoutQiuantidadeProduto);

        }

        public TextView getNome() {
            return nome;
        }

        public TextView getQuantidade() {
            return quantidade;
        }
    }
}
