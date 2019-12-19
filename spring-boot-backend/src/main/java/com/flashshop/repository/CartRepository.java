package com.flashshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flashshop.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
	CartEntity findByIdAndStatus(Long id, Long Status);
}

