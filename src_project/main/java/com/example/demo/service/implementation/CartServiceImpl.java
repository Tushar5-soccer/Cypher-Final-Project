package com.example.demo.service.implementation;


import com.example.demo.model.orders.CartItem;
import com.example.demo.model.products.Product;
import com.example.demo.model.users.User;
import com.example.demo.service.interfaces.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Override
    public void addToCart(Integer productId, Integer quantity, Integer userId) {

    }

    @Override
    public List<CartItem> getCartItems(User user) {
        return null;
    }

    @Override
    public void deleteCartItem(Integer cartId, Integer userId) {

    }

    @Override
    public void deleteAllCartItems(Integer userId) {

    }

    @Override
    public void updateCartItem(CartItem cartItem, User user, Product product) {

    }
}
