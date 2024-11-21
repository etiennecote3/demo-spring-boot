package com.example.demo.model;

import java.util.List;

public class Order {
    private Long id;
    private String customerName;
    private String customerEmail;
    private List<String> products;
    private String orderDate;

    public Order() {
    }

    public Order(Long id, String customerName, String customerEmail, List<String> products, String orderDate) {
        this.id = id;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.products = products;
        this.orderDate = orderDate;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
