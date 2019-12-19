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

import com.flashshop.dto.UserDTO;
import com.flashshop.service.impl.UserService;
@CrossOrigin
@RestController
public class UserAPI {
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/user")
    public List<UserDTO> showUser(@RequestParam(value="page",defaultValue = "1") int page,
    		                 @RequestParam(value="limit",defaultValue= "10000" ) int limit) {
		Pageable pageable = new PageRequest(page-1,limit);
		
      return userService.findALL(pageable);
    }
	
	@GetMapping(value = "/user/{id}")
    public UserDTO showOneUser(@PathVariable("id") long id) {
		
      return userService.findOne(id);
    }
	
	@GetMapping(value = "/userAdress/{id}")
    public UserDTO showAdressUser(@PathVariable("id") long id) {
		
      return userService.findOneNotPass(id);
    }
	
	
	@PostMapping(value = "/user/check")
    public long checkUserByEmailAndPassWord(@RequestBody UserDTO model) {

      return userService.checkUserByEmailAndPassWord(model);
    }
	
	@PostMapping(value = "/user/checkemail")
    public Boolean checkUserByEmail(@RequestBody UserDTO model) {

      return userService.checkUserByEmail(model);
    }
	
	@GetMapping(value = "/user/check/{id}")
    public Boolean checkById(@PathVariable("id") long id) {

      return userService.checkById(id);
    }
	
	@PostMapping(value = "/user")
    public UserDTO createProduct(@RequestBody UserDTO model) {
     return userService.save(model);
    }
	
	@PutMapping(value = "/user/{id}")
    public UserDTO updateProduct(@RequestBody UserDTO model, @PathVariable("id") long id) {
		model.setId(id);
     return userService.update(model);
    }
	
	@DeleteMapping(value = "/user/{id}")
    public UserDTO deleteProduct(@PathVariable("id") long id) {
     return userService.delete(id);
    }

	

}
