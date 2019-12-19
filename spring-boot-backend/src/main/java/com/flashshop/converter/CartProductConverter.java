package com.flashshop.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flashshop.dto.CartProductDTO;
import com.flashshop.entity.CartProductEntity;
import com.flashshop.repository.CartRepository;
import com.flashshop.repository.ProductRepository;

@Component
public class CartProductConverter {
	
	 @Autowired
	 private ProductConverter productConverter;
	
	@Autowired
    private CartRepository cartRepository;
	
	@Autowired
    private ProductRepository productRepository;
   
	 public CartProductEntity toEntity(CartProductDTO dto) {
		 CartProductEntity entity= new CartProductEntity();
	    	entity.setAmount(dto.getAmount());
	    	entity.setCart(cartRepository.findOne(dto.getCartId()));
	    	entity.setProduct(productRepository.findOne(dto.getProductId()));
	   	 return entity;
	    }
	    
	    public CartProductDTO toDTO(CartProductEntity entity) {
	    	CartProductDTO dto= new CartProductDTO();
	    	dto.setAmount(entity.getAmount());
	    	dto.setId(entity.getId());
	    	dto.setCartId(entity.getCart().getId());
	    	dto.setProductId(entity.getProduct().getId());
	    	dto.setProduct(productConverter.toDTO(entity.getProduct()));
	   	 return dto;
	    }
	    
	    public CartProductEntity toEntity(CartProductDTO dto,CartProductEntity entity) {
	    	entity.setAmount(dto.getAmount());
	    	entity.setCart(cartRepository.findOne(dto.getCartId()));
	    	entity.setProduct(productRepository.findOne(dto.getProductId()));
	   	 return entity;
	    }
}
