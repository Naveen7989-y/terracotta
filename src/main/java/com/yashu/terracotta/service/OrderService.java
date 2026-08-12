package com.yashu.terracotta.service;

import org.springframework.stereotype.Service;

import com.yashu.terracotta.dto.OrderItemRequest;
import com.yashu.terracotta.dto.OrderRequest;
import com.yashu.terracotta.entity.Order;
import com.yashu.terracotta.entity.OrderItem;
import com.yashu.terracotta.repository.OrderItemRepository;
import com.yashu.terracotta.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderService(
            OrderRepository orderRepository,
            OrderItemRepository orderItemRepository) {

        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public Order placeOrder(OrderRequest request) {

        double total = 0;

        for (OrderItemRequest item : request.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }

        Order order = new Order();

        order.setUserId(request.getUserId());
        order.setTotalAmount(total);
        order.setStatus("PLACED");

        Order savedOrder = orderRepository.save(order);

        for (OrderItemRequest item : request.getItems()) {

            OrderItem orderItem = new OrderItem();

            orderItem.setOrderId(savedOrder.getId());
            orderItem.setProductName(item.getProductName());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(item.getPrice());

            orderItemRepository.save(orderItem);
        }

        return savedOrder;
    }
}