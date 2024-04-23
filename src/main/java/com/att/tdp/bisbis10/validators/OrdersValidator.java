package com.att.tdp.bisbis10.validators;

import com.att.tdp.bisbis10.model.*;
import org.hibernate.query.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

import java.util.List;

@Component
public class OrdersValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Orders.class.equals(clazz);
    }
    @Override
    public void validate(Object obj, Errors errors) {
        Orders order = (Orders) obj;
        if (order.getRestaurantId() == null) {
            errors.rejectValue("restaurantId", "restaurantId.empty", "RestaurantId must not be empty");
        }
        List<OrderItem> itemList = order.getOrderItems();
        if (itemList == null || itemList.isEmpty()){
            errors.rejectValue("orderItems", "orderItems.empty", "orderItems must not be empty");
        }
    }

}
