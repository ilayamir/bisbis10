package com.att.tdp.bisbis10.jparepositories;

import com.att.tdp.bisbis10.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrdersJpaRepository extends JpaRepository<Orders, String> {
}
