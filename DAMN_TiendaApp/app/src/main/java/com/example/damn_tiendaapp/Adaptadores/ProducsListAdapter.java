package com.example.damn_tiendaapp.Adaptadores;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.damn_tiendaapp.Entidades.ItemShoppingCart;
import com.example.damn_tiendaapp.Entidades.Product;
import com.example.damn_tiendaapp.ProductsList;
import com.example.damn_tiendaapp.R;
import com.example.damn_tiendaapp.ShoppingCart;

import java.util.ArrayList;

public class ProducsListAdapter extends RecyclerView.Adapter<ProducsListAdapter.ProductViewHolder>{
    private ArrayList<Product> listaProducto;


    //Metodo constructor para crear una nueva lista
    public ProducsListAdapter(ArrayList<Product> listaProducto) {
        this.listaProducto = listaProducto;
    }



    // Método llamado para crear una nueva vista de elemento del RecyclerView.
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflar la vista del elemento a partir de un archivo XML llamado "item_data".
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_producs_list_adapter, parent, false);
        return new ProductViewHolder(view);
    }

    // Método llamado para asignar datos a una vista de elemento del RecyclerView.
    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        // Obtener el producto correspondiente desde la lista.
        Product producto = listaProducto.get(position);
        // Asignar el nombre, descripcion y precio del producto a las vistas correspondientes.
        holder.viewPlu.setText(producto.getPlu());
        holder.viewNombre.setText(producto.getName());
        holder.viewDescripcion.setText(producto.getDescription());
        holder.viewPrecio.setText(producto.getValue());
    }

    // Método que devuelve el número de elementos en la lista de personas.
    @Override
    public int getItemCount() {
        return listaProducto.size();
    }

    // Clase interna que mantiene las referencias a las vistas en un elemento del RecyclerView.
    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView viewPlu;
        TextView viewNombre;
        TextView viewDescripcion;
        TextView viewPrecio;
        Button btnBuy;

        // Constructor que asigna las vistas a partir de la vista del elemento del RecyclerView.
        public ProductViewHolder(View itemView) {
            super(itemView);
            viewPlu = itemView.findViewById(R.id.viewPlu);
            viewNombre = itemView.findViewById(R.id.viewName);
            viewDescripcion = itemView.findViewById(R.id.viewDescription);
            viewPrecio = itemView.findViewById(R.id.viewPrice);
            btnBuy = itemView.findViewById(R.id.btnBuy);

            btnBuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ItemShoppingCart itemAdd = new ItemShoppingCart();
                    int valorU = Integer.parseInt(viewPrecio.getText().toString());
                    itemAdd.setPlu(viewPlu.getText().toString());
                    itemAdd.setName(viewNombre.getText().toString());
                    itemAdd.setCant(1);
                    itemAdd.setPriceUnit(valorU);
                    itemAdd.setPriceFull(valorU);
                    ProductsList productsList = new ProductsList();
                    productsList.addItem(itemAdd);
                }
            });
        }
    }

}