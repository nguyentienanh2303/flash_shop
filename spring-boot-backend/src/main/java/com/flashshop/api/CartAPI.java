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

import com.flashshop.dto.CartDTO;
import com.flashshop.dto.UserDTO;
import com.flashshop.service.impl.CartService;
import com.flashshop.service.impl.UserService;
@CrossOrigin
@RestController
public class CartAPI {
	@Autowired
	private CartService cartService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/cart")
    public List<CartDTO> showCart(@RequestParam(value="page",defaultValue = "1") int page,
    		                 @RequestParam(value="limit",defaultValue= "10000" ) int limit) {
		Pageable pageable = new PageRequest(page-1,limit);
		
      return cartService.findALL(pageable);
    }
	
	@GetMapping(value = "/cart/{id}")
    public CartDTO showOneCart(@PathVariable("id") long id) {
		
      return cartService.findOne(id);
    }
	
	@PostMapping(value = "/cart")
    public CartDTO createCart(@RequestBody CartDTO model) {
     return cartService.save(model);
    }
	
	@PutMapping(value = "/cart/{id}")
    public CartDTO updateProduct(@RequestBody CartDTO model, @PathVariable("id") long id) {
		model.setId(id);
     return cartService.update(model);
    }
	
	@DeleteMapping(value = "/cart/{id}")
    public CartDTO deleteProduct(@PathVariable("id") long id) {
     return cartService.delete(id);
    }
	
	
	@PostMapping(value = "/pay/user")
    public boolean createCart(@RequestBody UserDTO userDTO) {
	  if(userDTO.getId()==null || (userService.checkById(userDTO.getId()) ==false) ) return false;
      return cartService.pay(userDTO);
    }
	

	@GetMapping(value = "/cartPayed")
    public List<CartDTO> showCartPayed(@RequestParam(value="page",defaultValue = "1") int page,
    		                 @RequestParam(value="limit",defaultValue= "10000" ) int limit) {
      return cartService.findALLCartPayed(page, limit);
    }
	
	@GetMapping(value = "/cartPayed/{userId}")
    public List<CartDTO> showCartPayedByUserId(@RequestParam(value="page",defaultValue = "1") int page,
    		                           @RequestParam(value="limit",defaultValue= "10000" ) int limit,
    		                           @PathVariable("userId") long userId) {
      return cartService.findALLCartPayedByUserId(page, limit, userId);
    }
	
}
