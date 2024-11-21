package com.example.demo.mapper;

import com.example.demo.dto.OrderDto;
import com.example.demo.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    // Convert DTO to Model
    public Order toModel(OrderDto dto) {
        Order order = new Order();
        order.setCustomerName(dto.getCustomerName());
        order.setCustomerEmail(dto.getCustomerEmail());
        order.setProducts(dto.getProducts());
        order.setOrderDate(dto.getOrderDate());
        return order;
    }

    // Convert Model to DTO
    public OrderDto toDto(Order model) {
        OrderDto dto = new OrderDto();
        dto.setCustomerName(model.getCustomerName());
        dto.setCustomerEmail(model.getCustomerEmail());
        dto.setProducts(model.getProducts());
        dto.setOrderDate(model.getOrderDate());
        return dto;
    }
}
