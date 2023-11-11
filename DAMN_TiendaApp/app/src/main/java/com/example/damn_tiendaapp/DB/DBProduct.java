package com.example.damn_tiendaapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.damn_tiendaapp.Entidades.Product;

import java.util.ArrayList;

public class DBProduct extends DBHelper {
    Context context;

    public DBProduct(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertProduct(String name, String description, String value) {
        long id = 0;
        try {
            // Crear una instancia de DBHelper para administrar la base de datos
            DBHelper dbHelper = new DBHelper(context);
            // Obtener una instancia de la base de datos en modo escritura
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            // Crear un objeto ContentValues para almacenar los valores del contacto
            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("description", description);
            values.put("value", value);

            // Insertar los valores en la tabla de Product obtiene el ID del nuevo producto
            id = db.insert(TABLE_PRODUCT, null, values);
        } catch (Exception ex) {
            ex.toString();
        }
        // Devolver el ID del producto insertado (o 0 si ocurrió un error)
        return id;
    }

    public ArrayList<Product> listProducts(){
        // Crear una instancia de DBHelper para administrar la base de datos
        DBHelper dbHelper = new DBHelper(context);
        // Obtener una instancia de la base de datos en modo escritura
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<Product> listaProductos = new ArrayList<>();
        Product producto = null;
        Cursor cursorProductos = null;

        cursorProductos = db.rawQuery("SELECT * FROM "+TABLE_PRODUCT,null);

        if (cursorProductos.moveToFirst()){
            do{
                producto = new Product();
                producto.setPlu(cursorProductos.getString(0));
                producto.setName(cursorProductos.getString(1));
                producto.setDescription(cursorProductos.getString(2));
                producto.setValue(cursorProductos.getString(3));
                listaProductos.add(producto);
            } while (cursorProductos.moveToNext());

        }
        cursorProductos.close();

        return listaProductos;
    }
}
