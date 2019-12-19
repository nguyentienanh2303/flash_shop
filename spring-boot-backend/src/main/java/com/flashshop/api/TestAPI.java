package com.flashshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flashshop.dto.ProductDTO;
import com.flashshop.service.impl.TestService;
@CrossOrigin
@RestController
public class TestAPI {
	
	@Autowired
	private TestService testService;
	
	
	@PostMapping(value = "/test")
	    public List<ProductDTO> testSpringBoot(@RequestBody List<String> keys) {
		
		return testService.Test(keys);
	        
	    }
	@GetMapping(value = "/test1")
    public String test() {
	 return "ok";
        
    }
}