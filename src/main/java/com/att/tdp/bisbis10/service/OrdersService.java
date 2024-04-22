package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.jparepositories.OrdersJpaRepository;
import com.att.tdp.bisbis10.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrdersService {
    @Autowired
    private OrdersJpaRepository orderJpaRepo;

    public UUID placeOrder(Orders order) {
        return orderJpaRepo.save(order).getId();
    }
}
