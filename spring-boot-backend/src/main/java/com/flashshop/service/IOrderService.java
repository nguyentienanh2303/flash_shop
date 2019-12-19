package com.flashshop.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.flashshop.dto.OrderProductDTO;

public interface IOrderService {
	public List<OrderProductDTO> findALL(Pageable pageable);
	public OrderProductDTO findOne(long id);
	public OrderProductDTO save(OrderProductDTO orderProductDTO);
	public OrderProductDTO update(OrderProductDTO orderProductDTO);
	public OrderProductDTO delete(long id);
}
