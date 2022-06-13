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

public class AdapterHomeEstoque extends RecyclerView.Adapter<AdapterHomeEstoque.CustomViewHolder> {
    private List<Produto> produtoList;

    public AdapterHomeEstoque(List<Produto> produtoList){
        this.produtoList = produtoList;
    }






    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_home_estoque, parent, false);
        return new AdapterHomeEstoque.CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int i) {
        holder.getNome().setText(produtoList.get(i).getNome());




    }

    @Override
    public int getItemCount() {
        return produtoList.size();
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        private TextView nome;





        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.textView_listaLayoutNomeProduto);


        }

        public TextView getNome() {
            return nome;
        }


    }
}
