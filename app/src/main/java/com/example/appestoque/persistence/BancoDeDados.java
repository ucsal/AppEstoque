package com.example.appestoque.persistence;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.appestoque.model.Produto;

@Database(entities = {Produto.class}, version = 1)
public abstract class BancoDeDados extends RoomDatabase {

    public abstract ProdutoInterface produtoDao();

    private static BancoDeDados INSTANCE;

    public static BancoDeDados getDbIntance (Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), BancoDeDados.class,"My DB")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

}
