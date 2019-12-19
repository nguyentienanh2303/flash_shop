package com.flashshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flashshop.entity.OrderProductEntity;


public interface OrderProductRepository extends JpaRepository<OrderProductEntity, Long> {

}
