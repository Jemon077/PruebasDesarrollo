package com.example.damn_tiendaapp.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.damn_tiendaapp.Entidades.ItemShoppingCart;
import com.example.damn_tiendaapp.Entidades.Product;
import com.example.damn_tiendaapp.R;

import java.util.ArrayList;

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ItemCartViewHolder>{

    private ArrayList<ItemShoppingCart> listaProductoAgregado;

    //Metodo constructor para crear una nueva lista
    public ShoppingCartAdapter(ArrayList<ItemShoppingCart> listaProductoAgregado) {
        this.listaProductoAgregado = listaProductoAgregado;
    }


    // Método llamado para crear una nueva vista de elemento del RecyclerView.
    @Override
    public ItemCartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflar la vista del elemento a partir de un archivo XML llamado "item_data".
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_shopping_cart_adapter, parent, false);
        return new ItemCartViewHolder(view);
    }

    // Método llamado para asignar datos a una vista de elemento del RecyclerView.
    @Override
    public void onBindViewHolder(ShoppingCartAdapter.ItemCartViewHolder holder, int position) {
        // Obtener el producto correspondiente desde la lista.
        ItemShoppingCart itemCart = listaProductoAgregado.get(position);
        // Asignar el nombre, descripcion y precio del producto a las vistas correspondientes.
        holder.viewPlu.setText(itemCart.getPlu());
        holder.viewNombre.setText(itemCart.getName());
        holder.viewCantidad.setText(itemCart.getCant());
        holder.viewPrecioUni.setText(itemCart.getPriceUnit());
        holder.viewPrecioTot.setText(itemCart.getPriceFull());
    }

    // Método que devuelve el número de elementos en la lista de personas.
    @Override
    public int getItemCount() {
        return listaProductoAgregado.size();
    }

    // Clase interna que mantiene las referencias a las vistas en un elemento del RecyclerView.
    public class ItemCartViewHolder extends RecyclerView.ViewHolder {
        TextView viewPlu;
        TextView viewNombre;
        TextView viewCantidad;
        TextView viewPrecioUni;
        TextView viewPrecioTot;


        // Constructor que asigna las vistas a partir de la vista del elemento del RecyclerView.
        public ItemCartViewHolder(View itemView) {
            super(itemView);
            viewPlu = itemView.findViewById(R.id.viewPlu);
            viewNombre = itemView.findViewById(R.id.viewName);
            viewCantidad = itemView.findViewById(R.id.viewCant);
            viewPrecioUni = itemView.findViewById(R.id.viewPrice);
            viewPrecioTot = itemView.findViewById(R.id.viewPriceFull);

        }
    }


}
