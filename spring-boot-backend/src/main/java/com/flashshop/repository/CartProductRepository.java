package com.flashshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flashshop.entity.CartProductEntity;

public interface CartProductRepository extends JpaRepository<CartProductEntity, Long>{
}
