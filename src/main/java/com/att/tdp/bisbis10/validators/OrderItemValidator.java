package com.att.tdp.bisbis10.validators;

import com.att.tdp.bisbis10.model.*;
import org.hibernate.query.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

@Component
public class OrderItemValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return OrderItem.class.equals(clazz);
    }
    @Override
    public void validate(Object obj, Errors errors) {
        OrderItem orderItems = (OrderItem) obj;
        if (orderItems.getDishId() == null) {
            errors.rejectValue("dishId", "dishId.empty", "DishId must not be empty");
        }
        if (orderItems.getAmount() <= 0) {
            errors.rejectValue("amount", "amount.invalid", "Amount must be greater than zero");
        }
    }

}
