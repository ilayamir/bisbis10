package com.att.tdp.bisbis10.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
public class Orders {
    @Id
    @UuidGenerator
    private String orderId;
    @JsonIgnore
    private int restaurantId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private List<OrderItem> orderItems;

    public Orders(){
        super();
    }
    public Orders(int restaurantId, List<OrderItem> orderItems) {
        super();
        this.orderId = UUID.randomUUID().toString();
        this.restaurantId = restaurantId;
        this.orderItems = orderItems;
    }
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public int getRestaurantId() { return restaurantId; }
    public void setRestaurantId(int restaurantId) { this.restaurantId = restaurantId; }
    public List<OrderItem> getOrderItems() { return orderItems; }
    public void setOrderItems(List<OrderItem> orderItems) { this.orderItems = orderItems; }
}
