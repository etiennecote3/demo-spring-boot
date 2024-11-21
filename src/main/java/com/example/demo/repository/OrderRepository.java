package com.example.demo.repository;

import com.example.demo.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    private final List<Order> orders = new ArrayList<>();

    public List<Order> findAll() {
        return orders;
    }

    public Optional<Order> findById(Long id) {
        return orders.stream().filter(order -> order.getId().equals(id)).findFirst();
    }

    public void save(Order order) {
        orders.add(order);
    }

    public void deleteById(Long id) {
        orders.removeIf(order -> order.getId().equals(id));
    }
}
