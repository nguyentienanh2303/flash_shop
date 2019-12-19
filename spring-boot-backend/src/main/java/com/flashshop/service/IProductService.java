package com.flashshop.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.flashshop.dto.ProductDTO;


public interface IProductService {
	public List<ProductDTO> findALL(Pageable pageable);
	public List<ProductDTO> findALL(int page, int limit, String type );
	public ProductDTO findOne(long id);
	public ProductDTO save(ProductDTO productDTO);
	public ProductDTO update(ProductDTO productDTO);
	public ProductDTO delete(long id);
}
