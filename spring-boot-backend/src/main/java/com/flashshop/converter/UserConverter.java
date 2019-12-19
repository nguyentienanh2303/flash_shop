package com.flashshop.converter;

import org.springframework.stereotype.Component;

import com.flashshop.dto.UserDTO;
import com.flashshop.entity.UserEntity;

@Component
public class UserConverter {
    public UserEntity toEntity(UserDTO dto) {
    	UserEntity entity= new UserEntity();
    	entity.setAdress(dto.getAdress());
    	entity.setEmail(dto.getEmail());
    	entity.setFirstName(dto.getFirstName());
    	entity.setLastName(dto.getLastName());
    	entity.setPassWord(dto.getPassWord());
    	entity.setPhone(dto.getPhone());
   	 return entity;
    }
    
    public UserDTO toDTO(UserEntity entity) {
    	UserDTO dto= new UserDTO();
    	dto.setAdress(entity.getAdress());
    	dto.setEmail(entity.getEmail());
    	dto.setFirstName(entity.getFirstName());
    	dto.setLastName(entity.getLastName());
    	dto.setPassWord(entity.getPassWord());
    	dto.setId(entity.getId());
    	dto.setPhone(entity.getPhone());
   	 return dto;
    }
    
    public UserEntity toEntity(UserDTO dto,UserEntity entity) {
    	entity.setAdress(dto.getAdress());
    	entity.setEmail(dto.getEmail());
    	entity.setFirstName(dto.getFirstName());
    	entity.setLastName(dto.getLastName());
    	entity.setPassWord(dto.getPassWord());
    	entity.setPhone(dto.getPhone());
   	 return entity;
    }
}
