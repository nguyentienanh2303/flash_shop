package com.flashshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flashshop.dto.CartProductDTO;
import com.flashshop.service.impl.CartProductService;
@CrossOrigin
@RestController
public class CartProductAPI {
	@Autowired
	private CartProductService cartProductService;
	
	@GetMapping(value = "/cartproduct")
    public List<CartProductDTO> showProduct(@RequestParam(value="page",defaultValue = "1") int page,
    		                 @RequestParam(value="limit",defaultValue= "10000" ) int limit) {
		Pageable pageable = new PageRequest(page-1,limit);
		
      return cartProductService.findALL(pageable);
    }
	
	@GetMapping(value = "/cartproduct/{id}")
    public CartProductDTO showOneProduct(@PathVariable("id") long id) {
		
      return cartProductService.findOne(id);
    }
	
	@PostMapping(value = "/cartproduct")
    public CartProductDTO createProduct(@RequestBody CartProductDTO model) {
     return cartProductService.save(model);
    }
	
	@PutMapping(value = "/cartproduct/{id}")
    public CartProductDTO updateProduct(@RequestBody CartProductDTO model, @PathVariable("id") long id) {
		model.setId(id);
     return cartProductService.update(model);
    }
	
	@DeleteMapping(value = "/cartproduct/{id}")
    public CartProductDTO deleteProduct(@PathVariable("id") long id) {
     return cartProductService.delete(id);
    }
	
	@GetMapping(value = "/advancecartproduct")
    public CartProductDTO addProductToCartByUserAndProductId(@RequestParam(value="userId") long userId,
    		                 @RequestParam(value="productId" ) long productId) {
		
      return cartProductService.addProductToCartByUserAndProductId(userId, productId);
    }
	
	@PostMapping(value = "/advancecartproduct")    //thêm sản phẩm vào giỏ hàng, nếu sản phẩm chưa có sẵn trong giở hàng thì khởi tạo, nếu đã có thì tăng số lượng lên 1
    public CartProductDTO addProductIdToCart(@RequestParam(value="userId") long userId,
    		                 @RequestParam(value="productId" ) long productId) {
		
      return cartProductService.addProductToCartByUserAndProductId(userId, productId);
    }
	
//	@PutMapping(value = "/advancecartproduct")    //thêm n sản phẩm vào giỏ hàng, nếu sản phẩm chưa có sẵn trong giở hàng thì khởi tạo, nếu đã có thì tăng số lượng lên 1
//    public CartProductDTO updateAmountProductIdToCart(@RequestParam(value="userId") long userId,
//    		                 @RequestParam(value="productId" ) long productId,
//    		                 @RequestParam(value="amount" ) int amount) {
//		
//      return cartProductService.updateAmountProductToCartByUserAndProductId(userId, productId, amount);
//    }
	
	@GetMapping(value = "/cartproduct/user/{id}")
    public List<CartProductDTO> showAllProductByUserId(@PathVariable("id") long userId) {
		
      return cartProductService.findAllProductCartByUser(userId);
}
	
	@GetMapping(value = "/countProduct/user/{id}")
    public int countProductByUserId(@PathVariable("id") long userId) {
		
      return cartProductService.countProductCartByUser(userId);
}
}
