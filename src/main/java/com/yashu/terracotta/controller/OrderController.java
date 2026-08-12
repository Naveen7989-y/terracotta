package com.yashu.terracotta.controller;

import org.springframework.web.bind.annotation.*;

import com.yashu.terracotta.dto.OrderRequest;
import com.yashu.terracotta.entity.Order;
import com.yashu.terracotta.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order placeOrder(@RequestBody OrderRequest request) {

        return orderService.placeOrder(request);
    }
}