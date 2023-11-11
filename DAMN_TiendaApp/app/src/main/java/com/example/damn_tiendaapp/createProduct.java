package com.example.damn_tiendaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.damn_tiendaapp.DB.DBProduct;

public class createProduct extends AppCompatActivity {

    EditText nombre, describe, valor;
    private Button createRegister;
    private Button cancelRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product);

        nombre = findViewById(R.id.nameProductNew);
        describe = findViewById(R.id.describeProductNew);
        valor = findViewById(R.id.valueProductNew);

        createRegister = findViewById(R.id.RegisterProductNew);
        cancelRegister = findViewById(R.id.register_CancelNew);

        cancelRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(createProduct.this, "CANCELA CREACION", Toast.LENGTH_LONG).show();
                returnActivity();

            }
        });

        createRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuevoProducto(nombre.getText().toString(), describe.getText().toString(), valor.getText().toString());
            }
        });


    }

    private void nuevoProducto(String nombre, String descri, String valor){
        DBProduct dbProduct = new DBProduct(createProduct.this);
        long r = dbProduct.insertProduct(nombre,descri,valor);
        if (r > 0){
            Toast.makeText(createProduct.this, "PRODUCTO CREADO", Toast.LENGTH_LONG).show();
            clearForm();
        }else{
            Toast.makeText(createProduct.this, "ERROR AL CREAR. INTENTE DE NUEVO", Toast.LENGTH_LONG).show();
        }
    }

    private void clearForm(){
        nombre.setText("");
        describe.setText("");
        valor.setText("");
    }

    private void returnActivity (){
        Intent intent = new Intent(createProduct.this, ProductsList.class);
        startActivity(intent);
    }




}