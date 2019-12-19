package com.flashshop.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.flashshop.dto.CartDTO;

public interface ICartService {
	public List<CartDTO> findALL(Pageable pageable);
	public CartDTO findOne(long id);
	public CartDTO save(CartDTO cartDTO);
	public CartDTO update(CartDTO cartDTO);
	public CartDTO delete(long id);
}
