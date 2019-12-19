package com.flashshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flashshop.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByEmailAndPassWord(String email, String adress);
	UserEntity findOneByEmail(String email);
}
