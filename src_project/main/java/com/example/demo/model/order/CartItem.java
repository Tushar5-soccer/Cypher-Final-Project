package com.example.demo.model.orders;

import com.example.demo.model.products.Product;
import lombok.Data;

public  @Data class CartItem {

    private Integer cartId;

    private Integer quantity;

    private Product product;


}
