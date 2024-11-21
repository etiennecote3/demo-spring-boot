package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllOrders() {
        Order order = new Order(1L, "John Doe", "john.doe@example.com", Arrays.asList("Laptop"), "2024-11-19");
        when(orderRepository.findAll()).thenReturn(Arrays.asList(order));

        assertEquals(1, orderService.getAllOrders().size());
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    void testGetOrderById() {
        Order order = new Order(1L, "John Doe", "john.doe@example.com", Arrays.asList("Laptop"), "2024-11-19");
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        Order result = orderService.getOrderById(1L);
        assertNotNull(result);
        assertEquals("John Doe", result.getCustomerName());
        verify(orderRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateOrder() {
        Order order = new Order(1L, "John Doe", "john.doe@example.com", Arrays.asList("Laptop"), "2024-11-19");
        orderService.createOrder(order);

        verify(orderRepository, times(1)).save(order);
    }

    @Test
    void testDeleteOrder() {
        orderService.deleteOrder(1L);

        verify(orderRepository, times(1)).deleteById(1L);
    }
}
