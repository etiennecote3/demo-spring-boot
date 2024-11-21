package com.example.demo.repository;

import com.example.demo.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {

    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository = new OrderRepository();
    }

    @Test
    void testSaveAndFindAll() {
        Order order = new Order(1L, "John Doe", "john.doe@example.com", Arrays.asList("Laptop", "Mouse"), "2024-11-19");
        orderRepository.save(order);

        List<Order> orders = orderRepository.findAll();
        assertEquals(1, orders.size());
        assertEquals("John Doe", orders.get(0).getCustomerName());
    }

    @Test
    void testFindById() {
        Order order = new Order(1L, "John Doe", "john.doe@example.com", Arrays.asList("Laptop"), "2024-11-19");
        orderRepository.save(order);

        Optional<Order> result = orderRepository.findById(1L);
        assertTrue(result.isPresent());
        assertEquals("John Doe", result.get().getCustomerName());
    }

    @Test
    void testDeleteById() {
        Order order = new Order(1L, "John Doe", "john.doe@example.com", Arrays.asList("Laptop"), "2024-11-19");
        orderRepository.save(order);

        orderRepository.deleteById(1L);
        assertTrue(orderRepository.findAll().isEmpty());
    }
}
