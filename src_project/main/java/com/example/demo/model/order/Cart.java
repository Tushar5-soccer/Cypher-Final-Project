package com.example.demo.model.orders;

import com.example.demo.model.users.User;
import lombok.Data;

import java.util.List;

public @Data class Cart {

    private List<CartItem> cartItems;
    private Double totalPrice;

    private User user;

}
