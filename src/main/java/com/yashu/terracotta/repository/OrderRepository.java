package com.yashu.terracotta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yashu.terracotta.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}