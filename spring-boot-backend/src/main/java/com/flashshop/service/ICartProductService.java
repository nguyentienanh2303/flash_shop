package com.flashshop.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.flashshop.dto.CartProductDTO;

public interface ICartProductService {
	public List<CartProductDTO> findALL(Pageable pageable);
	public CartProductDTO findOne(long id);
	public CartProductDTO save(CartProductDTO cartProductDTO);
	public CartProductDTO update(CartProductDTO cartProductDTO);
	public CartProductDTO delete(long id);
}
