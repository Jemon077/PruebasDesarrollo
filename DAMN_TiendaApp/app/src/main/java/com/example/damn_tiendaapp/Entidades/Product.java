package com.example.damn_tiendaapp.Entidades;

import java.util.Currency;

public class Product {
    private String plu;
    private String name;
    private String description;
    private String value;

    public Product(String plu, String name, String description, String value) {
        this.plu = plu;
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public Product() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
