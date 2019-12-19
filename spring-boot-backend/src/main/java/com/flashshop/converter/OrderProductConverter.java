package com.flashshop.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flashshop.dto.CartProductDTO;
import com.flashshop.dto.OrderProductDTO;
import com.flashshop.dto.ProductDTO;
import com.flashshop.entity.CartProductEntity;
import com.flashshop.entity.OrderProductEntity;
import com.flashshop.repository.CartRepository;
//import com.flashshop.repository.ProductRepository;
@Component
public class OrderProductConverter {
//	@Autowired
//	private ProductConverter productConverter;

	@Autowired
	private CartRepository cartRepository;

//	@Autowired
//	private ProductRepository productRepository;

	public OrderProductEntity toEntity(OrderProductDTO dto) {
		OrderProductEntity entity = new OrderProductEntity();
		entity.setAmount(dto.getAmount());
		entity.setCart(cartRepository.findOne(dto.getCartId()));
		entity.setName(dto.getProduct().getName());
		entity.setType(dto.getProduct().getType());
		entity.setLinkImg(dto.getProduct().getLinkImg());
		entity.setSummary(dto.getProduct().getSummary());
		entity.setPrice(dto.getProduct().getPrice());
		return entity;
	}
	
	public OrderProductEntity toEntity(CartProductDTO dto) {      // chuyển từ    CartProductDTO sang  OrderProductEntity (chồng phương thức)            
		OrderProductEntity entity = new OrderProductEntity();
		entity.setAmount(dto.getAmount());
		entity.setCart(cartRepository.findOne(dto.getCartId()));
		entity.setName(dto.getProduct().getName());
		entity.setType(dto.getProduct().getType());
		entity.setLinkImg(dto.getProduct().getLinkImg());
		entity.setSummary(dto.getProduct().getSummary());
		entity.setPrice(dto.getProduct().getPrice());
		return entity;
	}
	
	public OrderProductEntity toEntity(CartProductEntity model) {      // chuyển từ    CartProductDTO sang  OrderProductEntity (chồng phương thức)            
		OrderProductEntity entity = new OrderProductEntity();
		entity.setAmount(model.getAmount());
		entity.setCart(model.getCart());
		entity.setName(model.getProduct().getName());
		entity.setType(model.getProduct().getType());
		entity.setLinkImg(model.getProduct().getLinkImg());
		entity.setSummary(model.getProduct().getSummary());
		entity.setPrice(model.getProduct().getPrice());
		return entity;
	}
	
	public CartProductDTO toCartProductDTO(OrderProductEntity entity) {  
		CartProductDTO dto = new CartProductDTO();
		dto.setAmount(entity.getAmount());
		dto.setCartId(entity.getCart().getId());
		ProductDTO productDTO= new ProductDTO();
		productDTO.setLinkImg(entity.getLinkImg());
		productDTO.setName(entity.getName());
		productDTO.setPrice(entity.getPrice());
		productDTO.setSummary(entity.getSummary());
		productDTO.setType(entity.getType());
		dto.setProduct(productDTO);
		return dto;
	}

	public OrderProductDTO toDTO(OrderProductEntity entity) {
		OrderProductDTO dto = new OrderProductDTO();
		dto.setAmount(entity.getAmount());
		dto.setId(entity.getId());
		dto.setCartId(entity.getCart().getId());
		ProductDTO productDTO= new ProductDTO();
		productDTO.setLinkImg(entity.getLinkImg());
		productDTO.setName(entity.getName());
		productDTO.setPrice(entity.getPrice());
		productDTO.setSummary(entity.getSummary());
		productDTO.setType(entity.getType());
		dto.setProduct(productDTO);
		return dto;
	}

	public OrderProductEntity toEntity(OrderProductDTO dto, OrderProductEntity entity) {
		entity.setAmount(dto.getAmount());
		entity.setCart(cartRepository.findOne(dto.getCartId()));
		entity.setName(dto.getProduct().getName());
		entity.setType(dto.getProduct().getType());
		entity.setLinkImg(dto.getProduct().getLinkImg());
		entity.setSummary(dto.getProduct().getSummary());
		entity.setPrice(dto.getProduct().getPrice());
		return entity;
	}
}
