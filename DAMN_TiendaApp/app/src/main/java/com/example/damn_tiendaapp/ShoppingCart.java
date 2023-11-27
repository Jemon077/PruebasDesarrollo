package com.example.damn_tiendaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.damn_tiendaapp.Adaptadores.ShoppingCartAdapter;
import com.example.damn_tiendaapp.Entidades.ItemShoppingCart;

import java.util.ArrayList;

public class ShoppingCart extends AppCompatActivity {

    private RecyclerView listaItems;
    private ArrayList<ItemShoppingCart> listArraySelectProducts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        listaItems = findViewById(R.id.ListAllProductsCart);
        listaItems.setLayoutManager(new LinearLayoutManager(this));
        ProductsList productsList = new ProductsList();

        ShoppingCartAdapter adapter = new ShoppingCartAdapter (productsList.getlistItems());
        listaItems.setAdapter(adapter);

    }
}