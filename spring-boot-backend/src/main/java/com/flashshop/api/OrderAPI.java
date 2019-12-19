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
import com.flashshop.service.impl.CartService;

@CrossOrigin
@RestController
public class OrderAPI {

	@Autowired
	private CartService cartService;
	
	@GetMapping(value = "/orderProduct")
    public List<CartDTO> showOrderProduct(@RequestParam(value="page",defaultValue = "1") int page,
    		                 @RequestParam(value="limit",defaultValue= "10000" ) int limit) {
		Pageable pageable = new PageRequest(page-1,limit);
		
      return cartService.findALL(pageable);
    }
	
	@GetMapping(value = "/orderProduct/{id}")
    public CartDTO showOneOrderProduct(@PathVariable("id") long id) {
		
      return cartService.findOne(id);
    }
	
	@PostMapping(value = "/orderProduct")
    public CartDTO createOrderProduct(@RequestBody CartDTO model) {
     return cartService.save(model);
    }
	
	@PutMapping(value = "/orderProduct/{id}")
    public CartDTO updateOrderProduct(@RequestBody CartDTO model, @PathVariable("id") long id) {
		model.setId(id);
     return cartService.update(model);
    }
	
	@DeleteMapping(value = "/orderProduct/{id}")
    public CartDTO deleteOrderProduct(@PathVariable("id") long id) {
     return cartService.delete(id);
    }
	

	
	

}
