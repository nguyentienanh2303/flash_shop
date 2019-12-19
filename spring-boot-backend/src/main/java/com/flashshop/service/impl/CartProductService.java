package com.flashshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.flashshop.converter.CartProductConverter;
import com.flashshop.dto.CartProductDTO;
import com.flashshop.entity.CartEntity;
import com.flashshop.entity.CartProductEntity;
import com.flashshop.entity.ProductEntity;
import com.flashshop.entity.UserEntity;
import com.flashshop.repository.CartProductRepository;
import com.flashshop.repository.CartRepository;
import com.flashshop.repository.ProductRepository;
import com.flashshop.repository.UserRepository;
import com.flashshop.service.ICartProductService;

@Service
public class CartProductService implements ICartProductService{
	
	@Autowired
    private CartProductRepository cartProductRepository;
	
    
	@Autowired
    private CartRepository cartRepository;
	
	
	@Autowired
    private ProductRepository productRepository;
	
	
	@Autowired
    private UserRepository userRepository;
 
	
    @Autowired
    private CartProductConverter cartProductConverter;
    


	@Override
	public List<CartProductDTO> findALL(Pageable pageable) {
		List<CartProductDTO> result=new ArrayList<>();
		List<CartProductEntity> entities= cartProductRepository.findAll(pageable).getContent();
		for(CartProductEntity item: entities) {
			CartProductDTO cartProductDTO = cartProductConverter.toDTO(item);
			result.add(cartProductDTO);
		}
		return result;
	}

	@Override
	public CartProductDTO findOne(long id) {
		CartProductEntity entity = cartProductRepository.findOne(id);
		return cartProductConverter.toDTO(entity);
	}

	@Override
	public CartProductDTO save(CartProductDTO cartProductDTO) {
		CartProductEntity entity = new CartProductEntity();
		entity=cartProductConverter.toEntity(cartProductDTO);
		cartProductRepository.save(entity);
		return cartProductConverter.toDTO(entity);
	}

	@Override
	public CartProductDTO update(CartProductDTO cartProductDTO) {
		CartProductEntity entity = cartProductRepository.findOne(cartProductDTO.getId());
		entity=cartProductConverter.toEntity(cartProductDTO,entity);
		cartProductRepository.save(entity);
		return cartProductConverter.toDTO(entity);
	}

	@Override
	public CartProductDTO delete(long id) {
		CartProductEntity entity = cartProductRepository.findOne(id);
		cartProductRepository.delete(entity.getId());
		return cartProductConverter.toDTO(entity);
	}
	
	public CartProductDTO addProductToCartByUserAndProductId(long userId, long productId) {
		boolean check=false;
		List<CartEntity> carts= cartRepository.findAll();
		CartEntity cart = new CartEntity();
		for(CartEntity item:carts) {
			if(item.getUser().getId()==userId && item.getStatus()==0) {                 //tìm cartEntity có userId thỏa mãn và trạng thái là chưa thanh toán(0)  
				cart=item;
				check=true;
				break;
			}
		}
		if(!check) return null;
		check=false;
		List<CartProductEntity> cartProducts= cartProductRepository.findAll();
		CartProductEntity resule = new CartProductEntity();
		for(CartProductEntity item:cartProducts) {
			if(item.getCart().getId()==cart.getId() && item.getProduct().getId()==productId) {          //tìm sản phẩm và số lượng dựa trên productId và cartId đã tìm đc
				resule=item;
				check=true;
				break;
			}
		}
		if(!check) {                                                             //tức là không có sản phẩm đó trong giỏ hàng
			ProductEntity product = productRepository.findOne(productId);
			resule.setCart(cart);
			resule.setProduct(product);
			resule.setAmount(1);
			cartProductRepository.save(resule);
			return cartProductConverter.toDTO(resule);	
		}
		else {                                                          //tức là đã tồn tại sản phẩm trong giỏ hàng
			resule.setAmount((resule.getAmount()+1));
			cartProductRepository.save(resule);
		}
		return cartProductConverter.toDTO(resule);

	}
	
	
	
//	public CartProductDTO updateAmountProductToCartByUserAndProductId(long userId, long productId, int amount) {
//		boolean check=false;
//		List<CartEntity> carts= cartRepository.findAll();
//		CartEntity cart = new CartEntity();
//		for(CartEntity item:carts) {
//			if(item.getUser().getId()==userId && item.getStatus()==0) {                 //tìm cartEntity có userId thỏa mãn và trạng thái là chưa thanh toán(0)  
//				cart=item;
//				check=true;
//				break;
//			}
//		}
//		if(!check) return null;
//		List<CartProductEntity> cartProducts= cartProductRepository.findAll();
//		CartProductEntity resule = new CartProductEntity();
//		for(CartProductEntity item:cartProducts) {
//			if(item.getCart().getId()==cart.getId() && item.getProduct().getId()==productId) {             //tìm sản phẩm và số lượng dựa trên productId và cartId đã tìm đc
//				resule=item;
//				break;
//			}
//		}                                                        //tức là đã tồn tại sản phẩm trong giỏ hàng
//			resule.setAmount(amount);
//			cartProductRepository.save(resule);
//		return cartProductConverter.toDTO(resule);
//
//	}
	
	public List<CartProductDTO> findAllProductCartByUser(long userId) {
		UserEntity userEntity = userRepository.findOne(userId);
		CartEntity cart = new CartEntity();
		for(CartEntity item: userEntity.getCarts()) {
			if(item.getStatus()==0) {
				cart=item;
				break;
			}
		}
		
		List<CartProductDTO> results= new ArrayList<>();
		for(CartProductEntity item: cart.getCartProducts()) {
			results.add(cartProductConverter.toDTO(item));
		}
		return results;
	}
	
	
	
	public int countProductCartByUser(long userId) {
		int count=0;
		UserEntity userEntity = userRepository.findOne(userId);
		CartEntity cart = new CartEntity();
		for(CartEntity item: userEntity.getCarts()) {
			if(item.getStatus()==0) {
				cart=item;
				break;
			}
		}
		
	
		for(CartProductEntity item: cart.getCartProducts()) {
			count=count+item.getAmount();
		}
		return count;
	}

}
