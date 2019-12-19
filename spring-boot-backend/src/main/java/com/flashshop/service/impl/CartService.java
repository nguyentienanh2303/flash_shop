package com.flashshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.flashshop.converter.CartConverter;
import com.flashshop.converter.OrderProductConverter;
import com.flashshop.dto.CartDTO;
import com.flashshop.dto.UserDTO;
import com.flashshop.entity.CartEntity;
import com.flashshop.entity.CartProductEntity;
import com.flashshop.entity.OrderProductEntity;
import com.flashshop.repository.CartProductRepository;
import com.flashshop.repository.CartRepository;
import com.flashshop.repository.OrderProductRepository;
import com.flashshop.service.ICartService;


@Service
public class CartService implements ICartService {
	
	@Autowired
    private CartRepository cartRepository;
	
	@Autowired
    private CartProductRepository cartProductRepository;
	
	@Autowired
    private OrderProductRepository orderProductRepository;
    
 
    @Autowired
    private CartConverter cartConverter;
    
    @Autowired
    private OrderProductConverter orderProductConverter;
    


	@Override
	public List<CartDTO> findALL(Pageable pageable) {
		List<CartDTO> result=new ArrayList<>();
		List<CartEntity> entities= cartRepository.findAll(pageable).getContent();
		for(CartEntity item: entities) {
			CartDTO cartDTO = cartConverter.toDTO(item);
			result.add(cartDTO);
		}
		return result;
	}

	@Override
	public CartDTO findOne(long id) {
		CartEntity entity = cartRepository.findOne(id);
		return cartConverter.toDTO(entity);
	}

	@Override
	public CartDTO save(CartDTO cartDTO) {
		CartEntity entity = new CartEntity();
		entity=cartConverter.toEntity(cartDTO);
		cartRepository.save(entity);
		return cartConverter.toDTO(entity);
	}

	@Override
	public CartDTO update(CartDTO cartDTO) {
		CartEntity entity = cartRepository.findOne(cartDTO.getId());
		entity=cartConverter.toEntity(cartDTO,entity);
		cartRepository.save(entity);
		return cartConverter.toDTO(entity);
	}

	@Override
	public CartDTO delete(long id) {
		CartEntity entity = cartRepository.findOne(id);
		cartRepository.delete(entity.getId());
		return cartConverter.toDTO(entity);
	}
	
	public boolean pay(UserDTO userDTO) {
		boolean check=false;
		List<CartEntity> carts= cartRepository.findAll();
		CartEntity cart = new CartEntity();
		for(CartEntity item:carts) {
			if(item.getUser().getId()==userDTO.getId() && item.getStatus()==0) {                 //tìm cartEntity có userId thỏa mãn và trạng thái là chưa thanh toán(0)  
				cart=item;
				check=true;
				break;
			}
		}
		
		if(!check) return false;
		
		
		CartEntity newCartPay = new CartEntity(); //tạo mới 1 cart và thiết lập địa chỉ thanh toán và status 1
		
		newCartPay.setUser(cart.getUser());
		newCartPay.setAdress(userDTO.getAdress());
		newCartPay.setFirstName(userDTO.getFirstName());
		newCartPay.setLastName(userDTO.getLastName());
		newCartPay.setPhone(userDTO.getPhone());
		newCartPay.setStatus(1L);
		
		newCartPay=cartRepository.save(newCartPay); // lưu vào để lấy id
		
	     if(cart.getCartProducts().size()<1) {         // ko có hàng trong giỏ
	    	 cartRepository.delete(newCartPay);
	    	 return false;
	     }
	     
	     
		 List<OrderProductEntity> listAdd = new ArrayList<>();
		 List<CartProductEntity> listDelete = new ArrayList<>();
		 
		for(CartProductEntity item : cart.getCartProducts() ) {
			OrderProductEntity orderProductEntity= orderProductConverter.toEntity(item); // chuyển từ entity của CartProduct sang OrderProduct, id mới = null
			orderProductEntity.setCart(newCartPay); // cập nhật lại id của cart mới
			listAdd.add(orderProductEntity);   //thêm vào danh sách hàng đã thanh toán
			listDelete.add(item);  //thêm vào danh sách để xóa các hàng trong giỏ hàng
		}
	 
		  if(listDelete.size()<1) {                //check lại xem có lỗi ko
		    	 cartRepository.delete(newCartPay);
		    	 return false;
		     }
		  
		  orderProductRepository.save(listAdd);
		  cartProductRepository.delete(listDelete);
		  	
		return true;
	}


	public List<CartDTO> findALLCartPayed(int page, int limit) {
		List<CartDTO> result=new ArrayList<>();
		List<CartDTO> finalResult=new ArrayList<>();
		List<CartEntity> entities= cartRepository.findAll();
		for(CartEntity item: entities) {
			if (item.getStatus()<1L) continue;
			CartDTO cartDTO = cartConverter.toDTO(item);
			result.add(cartDTO);
		}
		
		int start =(page-1)*limit+1;
		int end=start+limit-1;
		int sumItem= result.size();
		if (start>sumItem) return null;
		if (end>sumItem) end=sumItem;
		
	    for(int i=(start-1);i<end;i++) {
	    	finalResult.add(result.get(i));
	    }
	    return finalResult;

	}
	
	public List<CartDTO> findALLCartPayedByUserId(int page, int limit, long userId) {
		List<CartDTO> result=new ArrayList<>();
		List<CartDTO> finalResult=new ArrayList<>();
		List<CartEntity> entities= cartRepository.findAll();
		for(CartEntity item: entities) {
			if (item.getStatus()<1L || item.getUser().getId()!=userId) continue;
			CartDTO cartDTO = cartConverter.toDTO(item);
			result.add(cartDTO);
		}
		
		int start =(page-1)*limit+1;
		int end=start+limit-1;
		int sumItem= result.size();
		if (start>sumItem) return null;
		if (end>sumItem) end=sumItem;
		
	    for(int i=(start-1);i<end;i++) {
	    	finalResult.add(result.get(i));
	    }
	    return finalResult;

	}

}
