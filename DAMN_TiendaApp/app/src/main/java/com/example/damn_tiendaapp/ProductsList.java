package com.example.damn_tiendaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.damn_tiendaapp.Adaptadores.ProducsListAdapter;
import com.example.damn_tiendaapp.Adaptadores.ShoppingCartAdapter;
import com.example.damn_tiendaapp.DB.DBProduct;
import com.example.damn_tiendaapp.Entidades.ItemShoppingCart;
import com.example.damn_tiendaapp.Entidades.Product;

import java.util.ArrayList;

public class ProductsList extends AppCompatActivity {

    private RecyclerView listaProducto;
    private ArrayList<Product> listArrayProducts = new ArrayList<>();
    private ArrayList<ItemShoppingCart> listArraySelectProducts = new ArrayList<>();
    private Button iconShoppingCart;
    private Button btnAddProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        iconShoppingCart = findViewById(R.id.btnViewCar);
        btnAddProduct = findViewById(R.id.btnAddProduct);
        listaProducto = findViewById(R.id.ListAllProducts);
        listaProducto.setLayoutManager(new LinearLayoutManager(this));
        DBProduct dbProduct = new DBProduct(ProductsList.this);

        ProducsListAdapter adapter = new ProducsListAdapter (dbProduct.listProducts());
        listaProducto.setAdapter(adapter);

        iconShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(ProductsList.this, ShoppingCart.class);
                startActivity(intentLogin);
                Toast.makeText(ProductsList.this, "ENLISTAR PRODUCTOS A COMPRAR", Toast.LENGTH_LONG).show();
            }
        });

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProductsList.this, "CREAR PRODUCTO NUEVO", Toast.LENGTH_LONG).show();
                nuevoRegistro();
            }
        });
    }

    private void nuevoRegistro() {
        // Crear un intent para iniciar la actividad "NuevoActivity"
        Intent intent = new Intent(this, createProduct.class);
        // Iniciar la actividad "NuevoActivity"
        startActivity(intent);
    }

    public ArrayList<ItemShoppingCart> getlistItems(){
        return listArraySelectProducts;
    }

    public void addItem(ItemShoppingCart item){
        boolean exist = false;
        for (ItemShoppingCart i: listArraySelectProducts) {
            if(i.getPlu() == item.getPlu()){
                exist = true;
                i.setCant(i.getCant() + item.getCant());
                i.setPriceFull(i.getCant() * i.getPriceUnit());
            }
        }
        if(!exist){
            listArraySelectProducts.add(item);
        }
    }

    public boolean deleteItem(ItemShoppingCart item){
        boolean result = false;
        for(ItemShoppingCart i: listArraySelectProducts){
            if(i.getPlu() == item.getPlu()){
                listArraySelectProducts.remove(i);
                result = true;
            }
        }
        return result;
    }




/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflar (crear) el menú de opciones desde el archivo de recursos "menu_principal.xml"
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_initial, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final int nuevo = R.id.menuNuevo;
        switch (item.getItemId()) {
            case 0:
                // Cuando se selecciona la opción "Nuevo" en el menú de opciones, llamar al método nuevoRegistro()
                nuevoRegistro();
                return true;
            default:
                // Si no se selecciona ninguna opción específica, permitir que la superclase maneje la selección
                return super.onOptionsItemSelected(item);
        }
    }
*/
    // Método para iniciar una nueva actividad cuando se selecciona la opción "Nuevo" en el menú de opciones

}