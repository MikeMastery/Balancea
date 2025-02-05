package com.example.myapplicationv4;

import android.net.Uri;

public class Product {
    private String name;
    private String description;
    private double price;
    private int stock;
    private Uri imageUri;

    public Product(String name, String description, double price, int stock, Uri imageUri) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.imageUri = imageUri;
    }

    // Getters y Setters
}
