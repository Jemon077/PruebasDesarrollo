package com.example.damn_tiendaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ProductsList extends AppCompatActivity {

    private RecyclerView listaProducto;
    private ArrayList<Product> listArrayProducts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        listaProducto = findViewById(R.id.ListAllProducts);
        listaProducto.setLayoutManager(new LinearLayoutManager(this));

        listArrayProducts.add(new Product("Casco","Describe Casco",711));
        listArrayProducts.add(new Product("Carcasa","Describe Carcasa",296));
        listArrayProducts.add(new Product("Billetera","Describe Billetera",172));
        listArrayProducts.add(new Product("Audifonos","Describe Audifonos",223));
        listArrayProducts.add(new Product("Gafas","Describe Gafas",588));
        listArrayProducts.add(new Product("Cargador","Describe Cargador",643));
        listArrayProducts.add(new Product("Cable HDMI","Describe Cable HDMI",754));
        listArrayProducts.add(new Product("Esfero","Describe Esfero",172));
        listArrayProducts.add(new Product("Lapiz","Describe Lapiz",617));
        listArrayProducts.add(new Product("Borrador","Describe Borrador",229));
        listArrayProducts.add(new Product("Portaminas","Describe Portaminas",148));
        listArrayProducts.add(new Product("Tijeras","Describe Tijeras",895));

        ProducsListAdapter adapter = new ProducsListAdapter (listArrayProducts);
        listaProducto.setAdapter(adapter);
    }
}