package com.flashshop.converter;

import org.springframework.stereotype.Component;

import com.flashshop.dto.ProductDTO;
import com.flashshop.entity.ProductEntity;

@Component
public class ProductConverter {
     public ProductEntity toEntity(ProductDTO dto) {
    	 ProductEntity entity= new ProductEntity();
    	 entity.setType(dto.getType());
    	 entity.setLinkImg(dto.getLinkImg());
    	 entity.setPrice(dto.getPrice());
    	 entity.setSummary(dto.getSummary());
    	 entity.setName(dto.getName());
    	 return entity;
     }
     
     public ProductDTO toDTO(ProductEntity entity) {
    	 ProductDTO dto = new ProductDTO();
    	 dto.setId(entity.getId());
    	 dto.setType(entity.getType());
    	 dto.setLinkImg(entity.getLinkImg());
    	 dto.setPrice(entity.getPrice());
    	 dto.setSummary(entity.getSummary());
    	 dto.setName(entity.getName());
    	 return dto;
     }
     
     public ProductEntity toEntity(ProductDTO dto,ProductEntity entity) {
    	 entity.setType(dto.getType());
    	 entity.setLinkImg(dto.getLinkImg());
    	 entity.setPrice(dto.getPrice());
    	 entity.setSummary(dto.getSummary());
    	 entity.setName(dto.getName());
    	 return entity;
     }
     
     
}
