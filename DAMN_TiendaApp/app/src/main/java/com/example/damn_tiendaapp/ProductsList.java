package com.example.damn_tiendaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductsList extends AppCompatActivity {

    private RecyclerView listaProducto;
    private ArrayList<Product> listArrayProducts = new ArrayList<>();
    private Button iconShoppingCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        iconShoppingCart = findViewById(R.id.btnViewCar);
        listaProducto = findViewById(R.id.ListAllProducts);
        listaProducto.setLayoutManager(new LinearLayoutManager(this));

        listArrayProducts.add(new Product("1", "Casco","Describe Casco","711"));
        listArrayProducts.add(new Product("2", "Carcasa","Describe Carcasa","296"));
        listArrayProducts.add(new Product("3", "Billetera","Describe Billetera","172"));
        listArrayProducts.add(new Product("4", "Audifonos","Describe Audifonos","223"));
        listArrayProducts.add(new Product("6", "Gafas","Describe Gafas","588"));
        listArrayProducts.add(new Product("7", "Cargador","Describe Cargador","643"));
        listArrayProducts.add(new Product("8", "Cable HDMI","Describe Cable HDMI","754"));
        listArrayProducts.add(new Product("9", "Esfero","Describe Esfero","172"));
        listArrayProducts.add(new Product("10", "Lapiz","Describe Lapiz","617"));
        listArrayProducts.add(new Product("11", "Borrador","Describe Borrador","229"));
        listArrayProducts.add(new Product("12", "Portaminas","Describe Portaminas","148"));
        listArrayProducts.add(new Product("13", "Tijeras","Describe Tijeras","895"));

        ProducsListAdapter adapter = new ProducsListAdapter (listArrayProducts);
        listaProducto.setAdapter(adapter);

        iconShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProductsList.this, "ENLISTAR PRODUCTOS A COMPRAR", Toast.LENGTH_LONG).show();
            }
        });

    }
}