package com.example.appestoque.persistence;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.appestoque.model.Produto;

import java.util.List;


@Dao
public interface ProdutoInterface {

    @Query("SELECT * FROM produto")
    List<Produto> getAllProduto();

    @Insert
    void addProduto(Produto... produto);

    @Delete
    void deleteProduto (Produto... produto);

}
