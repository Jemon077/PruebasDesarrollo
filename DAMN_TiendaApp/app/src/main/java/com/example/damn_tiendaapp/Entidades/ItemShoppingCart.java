package com.example.damn_tiendaapp.Entidades;

public class ItemShoppingCart {
    private String plu;
    private String name;
    private int cant;
    private int priceUnit;
    private int priceFull;

    public ItemShoppingCart() {
    }

    public ItemShoppingCart(String plu, String name, int cant, int priceUnit, int priceFull) {
        this.plu = plu;
        this.name = name;
        this.cant = cant;
        this.priceUnit = priceUnit;
        this.priceFull = priceFull;
    }

    public String getPlu() {

        return plu;
    }

    public void setPlu(String plu) {
        this.plu = plu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public int getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(int priceUnit) {
        this.priceUnit = priceUnit;
    }

    public int getPriceFull() {
        return priceFull;
    }

    public void setPriceFull(int priceFull) {
        this.priceFull = priceFull;
    }
}
