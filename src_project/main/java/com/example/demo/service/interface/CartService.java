package com.example.demo.service.interfaces;

import com.example.demo.model.orders.CartItem;
import com.example.demo.model.products.Product;
import com.example.demo.model.users.User;

import java.util.List;

public interface CartService {

    public abstract void addToCart(Integer productId, Integer quantity, Integer userId);

    public abstract List<CartItem> getCartItems(User user);

    public void deleteCartItem(Integer cartId, Integer userId);

    public void deleteAllCartItems(Integer userId);

    public void updateCartItem(CartItem cartItem, User user, Product product);


}
