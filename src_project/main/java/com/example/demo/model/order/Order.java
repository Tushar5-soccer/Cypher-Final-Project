package com.example.demo.model.orders;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

public @Data class Order {

    @Id
    private Integer orderId;
    private Integer userId;

    private Double totalPrice;

    private List<OrderItem> orderItems;



}
