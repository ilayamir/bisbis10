package com.att.tdp.bisbis10.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.UUID;
@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private UUID id;
    private Integer dishId;
    private int amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Orders order;
    public OrderItem(){
        super();
    }
    public OrderItem(int dishId, int amount) {
        super();
        this.dishId = dishId;
        this.amount = amount;
    }
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public Integer getDishId() { return dishId; }
    public void setDishId(Integer dishId) { this.dishId = dishId; }
    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }
    public Orders getOrder() {return order;}
    public void setOrder(Orders order) {this.order = order;}
}

