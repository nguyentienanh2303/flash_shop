package com.flashshop.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flashshop.dto.CartDTO;
import com.flashshop.dto.CartProductDTO;
import com.flashshop.entity.CartEntity;
import com.flashshop.entity.CartProductEntity;
import com.flashshop.entity.OrderProductEntity;
import com.flashshop.repository.UserRepository;

@Component
public class CartConverter {
	
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private OrderProductConverter orderProductConverter;
    
    @Autowired
    private CartProductConverter cartProductConverter;

	
    public CartEntity toEntity(CartDTO dto) {
    	CartEntity entity= new CartEntity();
    	entity.setStatus(dto.getStatus());
		entity.setUser(userRepository.findOne(dto.getUserId()));
		entity.setAdress(dto.getAdress());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setPhone(dto.getPhone());
   	 return entity;
    }
    
    public CartDTO toDTO(CartEntity entity) {
    	CartDTO dto= new CartDTO();
    	dto.setId(entity.getId());
    	dto.setStatus(entity.getStatus());
    	dto.setUserId(entity.getUser().getId());
    	dto.setAdress(entity.getAdress());
    	dto.setCreateData(entity.getCreateData());
    	dto.setFirstName(entity.getFirstName());
    	dto.setLastName(entity.getLastName());
    	dto.setModifiedData(entity.getModifiedData());
    	dto.setPhone(entity.getPhone());
    	if(!entity.getStatus().equals(0L)) {
    		List<CartProductDTO> list= new ArrayList<>();
    		for(OrderProductEntity item: entity.getOrderProduct() ) {
    			list.add(orderProductConverter.toCartProductDTO(item));
    		}
    		
    		if(list.size()>0) dto.setListCartProduct(list);
    	}
    	
    	if(entity.getStatus().equals(0L)) {
    		List<CartProductDTO> list= new ArrayList<>();
    		for(CartProductEntity item: entity.getCartProducts() ) {
    			list.add(cartProductConverter.toDTO(item));
    		}
    		
    		if(list.size()>0) dto.setListCartProduct(list);
    	}
   	 return dto;
    }
    
    public CartEntity toEntity(CartDTO dto,CartEntity entity) {
    	entity.setStatus(dto.getStatus());
		entity.setUser(userRepository.findOne(dto.getUserId()));
		entity.setAdress(dto.getAdress());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setPhone(dto.getPhone());
   	 return entity;
    }

}
