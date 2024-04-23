package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.DTO.OrderDTO;
import com.att.tdp.bisbis10.jparepositories.DishJpaRepository;
import com.att.tdp.bisbis10.model.Dish;
import com.att.tdp.bisbis10.model.OrderItem;
import com.att.tdp.bisbis10.model.Orders;
import com.att.tdp.bisbis10.model.Restaurant;
import com.att.tdp.bisbis10.service.DishService;
import com.att.tdp.bisbis10.service.OrdersService;
import com.att.tdp.bisbis10.service.RestaurantService;
import com.att.tdp.bisbis10.validators.OrderItemValidator;
import com.att.tdp.bisbis10.validators.OrdersValidator;
import com.att.tdp.bisbis10.validators.RatingValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrdersController {
    private final OrdersService orderService;
    @Autowired
    public OrdersController(OrdersService orderService) {
        this.orderService = orderService;
    }
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private DishService dishService;
    @Autowired
    private DishJpaRepository dishJpaRepository;
    @Autowired
    private OrdersValidator validator;
    @Autowired
    private OrderItemValidator itemValidator;
    @PostMapping
    public ResponseEntity<Object> placeOrder(@Valid @RequestBody Orders order, BindingResult bindingResult) {
        validator.validate(order, bindingResult);
        Restaurant restaurant = restaurantService.getRestaurantById(order.getRestaurantId());
        if (restaurant == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Restaurant not found");
        }
        if (order.getOrderItems() != null){
            for (OrderItem orderItem : order.getOrderItems()){
                itemValidator.validate(orderItem, bindingResult);
                if (dishJpaRepository.findById(orderItem.getDishId()).isEmpty()){
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).
                            body(String.format("Dish: %d not in the menu", orderItem.getDishId()));
                }
            }
        }
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().
                    body("Validation failed: " + bindingResult.getAllErrors());
        }
        orderService.placeOrder(order);
        OrderDTO orderResponse = new OrderDTO();
        orderResponse.setOrderId(order.getOrderId());
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }
}
