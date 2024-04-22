package com.att.tdp.bisbis10.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;
@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private UUID id;
    private int dishId;
    private int amount;

    public OrderItem(int dishId, int amount) {
        this.dishId = dishId;
        this.amount = amount;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public int getDishId() { return dishId; }
    public void setDishId(int dishId) { this.dishId = dishId; }
    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }
}

