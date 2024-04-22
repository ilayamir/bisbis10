package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.model.Orders;
import com.att.tdp.bisbis10.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrdersController {

    private final OrdersService orderService;

    @Autowired
    public OrdersController(OrdersService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<UUID> placeOrder(@RequestBody Orders order) {
        UUID orderId = orderService.placeOrder(order);
        return new ResponseEntity<>(orderId, HttpStatus.OK);
    }
}
