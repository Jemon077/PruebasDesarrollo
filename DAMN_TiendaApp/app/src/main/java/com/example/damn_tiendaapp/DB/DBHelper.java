package com.example.damn_tiendaapp.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "tienda.db";
    public static final String TABLE_USER = "user_app";
    public static final String TABLE_PRODUCT = "product";

    public DBHelper(@Nullable Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_USER + "(" +
            " id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "surename TEXT NOT NULL," +
            "userName TEXT NOT NULL," +
            "email TEXT NOT NULL," +
            "cellphone TEXT NOT NULL," +
            "password TEXT NOT NULL)"
        );
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PRODUCT + "(" +
                "plu INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "description TEXT NOT NULL," +
                "value TEXT NOT NULL)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Eliminar las tablas "t_contactos" si ya existen
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_PRODUCT);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_USER);
        // Llamar al método onCreate() para crear una nueva versión de las tablas
        onCreate(sqLiteDatabase);
    }
}
