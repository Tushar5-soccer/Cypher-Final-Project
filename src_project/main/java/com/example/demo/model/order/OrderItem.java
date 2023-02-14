package com.example.demo.model.orders;

import com.example.demo.model.products.Product;
import lombok.Data;

public @Data class OrderItem {

    private Integer orderItemId;

    private int quantity;

    private double price;

    private Product product;

    private int orderId;



}
