package com.example.demo.controller;

import com.example.demo.dto.OrderDto;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class OrderControllerTest {

    private MockMvc mockMvc;

    @Mock
    private OrderService orderService;

    @Mock
    private OrderMapper orderMapper;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    void testGetAllOrders() throws Exception {
        mockMvc.perform(get("/api/orders"))
                .andDo(print()) // Logs the response
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].customerName").value("John Doe"));

//        when(orderService.getAllOrders()).thenReturn(Arrays.asList(
//                new Order(1L, "John Doe", "john.doe@example.com", Arrays.asList("Laptop"), "2024-11-19")
//        ));
//
//        mockMvc.perform(get("/api/orders")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].customerName").value("John Doe"));
    }

    @Test
    void testCreateOrder() throws Exception {
        OrderDto orderDto = new OrderDto();
        orderDto.setCustomerName("John Doe");
        orderDto.setCustomerEmail("john.doe@example.com");
        orderDto.setProducts(Arrays.asList("Laptop"));
        orderDto.setOrderDate("2024-11-19");

        Order order = new Order(1L, "John Doe", "john.doe@example.com", Arrays.asList("Laptop"), "2024-11-19");
        when(orderMapper.toModel(orderDto)).thenReturn(order);

        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"customerName\":\"John Doe\",\"customerEmail\":\"john.doe@example.com\",\"products\":[\"Laptop\"],\"orderDate\":\"2024-11-19\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Order created successfully!"));
    }
}
