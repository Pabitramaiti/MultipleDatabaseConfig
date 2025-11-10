package com.pabi.demo.dpm.repsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pabi.demo.dpm.entity.OrderEntity;

public interface OrderRepo extends JpaRepository<OrderEntity, Long> {

}
