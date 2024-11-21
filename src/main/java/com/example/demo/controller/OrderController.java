package com.example.demo.controller;

import com.example.demo.dto.OrderDto;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import com.example.demo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper; // Helper class for mapping

    // Create a new order
    @PostMapping
    public String createOrder(@RequestBody OrderDto orderDto) {
        // Map DTO to Model
        Order order = orderMapper.toModel(orderDto);

        // Pass the Model to the service layer
        orderService.createOrder(order);

        return "Order created successfully!";
    }

    // Get an order by ID
    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable Long id) {
        // Call the service and get the Model
        Order order = orderService.getOrderById(id);

        // Map Model to DTO
        return orderMapper.toDto(order);
    }

    // Get all orders
    @GetMapping
    public List<OrderDto> getAllOrders() {
        // Call the service and get a list of Models
        List<Order> orders = orderService.getAllOrders();

        // Map Models to DTOs
        return orders.stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }
}
