package com.example.demo.service.implementation;

import com.example.demo.model.orders.CartItem;
import com.example.demo.model.orders.Order;
import com.example.demo.model.orders.OrderItem;
import com.example.demo.model.users.User;
import com.example.demo.service.interfaces.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl {

    @Autowired
    CartService cartService;
    public void createOrder(User user){

        //get cart items related to this user
        List<CartItem> cartItems = cartService.getCartItems(user);
        double totalPrice = 0.0;
        for (CartItem cartItem: cartItems){
            totalPrice += cartItem.getProduct().getPrice();
        }
        List<OrderItem> orderItems = new ArrayList();

        for (CartItem cartItem: cartItems){
            OrderItem orderItem = new OrderItem();
            orderItem.setPrice(cartItem.getProduct().getPrice());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setProduct(cartItem.getProduct());
            orderItems.add(orderItem);
        }

        Order order = new Order();
        order.setUserId(user.getUserId());
        order.setTotalPrice(totalPrice);
        order.setOrderItems(orderItems);
    }



}
