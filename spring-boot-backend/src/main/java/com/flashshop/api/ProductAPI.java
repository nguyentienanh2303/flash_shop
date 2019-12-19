package com.flashshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flashshop.dto.ProductDTO;
import com.flashshop.service.impl.ProductService;




@CrossOrigin
@RestController
public class ProductAPI {
	@Autowired
	private ProductService productService;
	
//	@GetMapping(value = "/product")
//    public List<ProductDTO> showProduct(@RequestParam(value="page",defaultValue = "1") int page,
//    		                 @RequestParam(value="limit",defaultValue= "10000" ) int limit) {
//		Pageable pageable = new PageRequest(page-1,limit);
//		
//      return productService.findALL(pageable);
//    }
	
	@GetMapping(value = "/product")
    public List<ProductDTO> showProduct(@RequestParam(value="page",defaultValue = "1") int page,
    		                 @RequestParam(value="limit",defaultValue= "10000" ) int limit,
    		                 @RequestParam(value="type",defaultValue= "all" ) String type) {
		
      return productService.findALL(page, limit, type);
    }
	
	@GetMapping(value = "/product/{id}")
    public ProductDTO showOneProduct(@PathVariable("id") long id) {
		
      return productService.findOne(id);
    }
	
	@PostMapping(value = "/product")
    public ProductDTO createProduct(@RequestBody ProductDTO model) {
     return productService.save(model);
    }
	
	@PutMapping(value = "/product/{id}")
    public ProductDTO updateProduct(@RequestBody ProductDTO model, @PathVariable("id") long id) {
		model.setId(id);
     return productService.update(model);
    }
	
	@DeleteMapping(value = "/product/{id}")
    public ProductDTO deleteProduct(@PathVariable("id") long id) {
     return productService.delete(id);
    }
	
	

	@PostMapping(value = "/product/search")
public List<ProductDTO> searchProduct(@RequestBody List<String> keys) {
		return productService.searchProduct(keys);   
	    }

}
