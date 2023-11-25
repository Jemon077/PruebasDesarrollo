package com.example.damn_tiendaapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.damn_tiendaapp.Entidades.Users;

public class DBUsers extends DBHelper{
    Context context;

    public DBUsers(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long createUser(String name, String surename, String userName, String email, String cellphone, String password){
        long i = 0;
        try {
            // Crear Instancia de DBHelper
            DBHelper dbHelper = new DBHelper(context);
            // Obtener Instancia de la DB
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            // Crear Objeto User para almacenar datos
            ContentValues users = new ContentValues();
            users.put("name", name);
            users.put("surename", surename);
            users.put("userName", userName);
            users.put("email", email);
            users.put("cellphone", cellphone);
            users.put("password", password);

            //Insertar objeto Users en la DB y obtener Id
            i = db.insert(TABLE_USER, null, users);
        } catch(Exception ex){
            ex.toString();
        }
        return i;
    }

    public boolean validateUser(String user, String pass){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursorUser = db.rawQuery("SELECT userName, password FROM " + TABLE_USER + " WHERE username= '" + user + "' AND password= '" + pass + "'",null );
        if(cursorUser.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }

}
