package com.flashshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.flashshop.converter.OrderProductConverter;
import com.flashshop.dto.OrderProductDTO;
import com.flashshop.entity.OrderProductEntity;
import com.flashshop.repository.OrderProductRepository;
import com.flashshop.service.IOrderService;

@Service
public class OrderService  implements IOrderService{
	@Autowired
    private OrderProductRepository orderProductRepository;
	
    
//	@Autowired
//    private CartRepository cartRepository;
//	
//	
//	@Autowired
//    private ProductRepository productRepository;
//	
//	
//	@Autowired
//    private UserRepository userRepository;
// 
	
    @Autowired
    private OrderProductConverter orderProductConverter;
    
	@Override
	public List<OrderProductDTO> findALL(Pageable pageable) {
		List<OrderProductDTO> result=new ArrayList<>();
		List<OrderProductEntity> entities= orderProductRepository.findAll(pageable).getContent();
		for(OrderProductEntity item: entities) {
			OrderProductDTO orderProductDTO = orderProductConverter.toDTO(item);
			result.add(orderProductDTO);
		}
		return result;
	}

	@Override
	public OrderProductDTO findOne(long id) {
		OrderProductEntity entity = orderProductRepository.findOne(id);
		return orderProductConverter.toDTO(entity);
	}

	@Override
	public OrderProductDTO save(OrderProductDTO cartProductDTO) {
		OrderProductEntity entity = new OrderProductEntity();
		entity=orderProductConverter.toEntity(cartProductDTO);
		orderProductRepository.save(entity);
		return orderProductConverter.toDTO(entity);
	}

	@Override
	public OrderProductDTO update(OrderProductDTO cartProductDTO) {
		OrderProductEntity entity = orderProductRepository.findOne(cartProductDTO.getId());
		entity=orderProductConverter.toEntity(cartProductDTO,entity);
		orderProductRepository.save(entity);
		return orderProductConverter.toDTO(entity);
	}

	@Override
	public OrderProductDTO delete(long id) {
		OrderProductEntity entity = orderProductRepository.findOne(id);
		orderProductRepository.delete(entity.getId());
		return orderProductConverter.toDTO(entity);
	}
	

}
