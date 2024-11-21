package com.example.demo.dto;

import java.util.List;

public class OrderDto {

    private String customerName;   // Name of the customer placing the order
    private String customerEmail;  // Email of the customer
    private List<String> products; // List of products in the order
    private String orderDate;      // Date of the order (e.g., "2024-11-18")

    // Getters and Setters
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
