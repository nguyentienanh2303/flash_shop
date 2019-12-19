package com.flashshop.service.impl;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.el.lang.FunctionMapperImpl.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashshop.converter.ProductConverter;
import com.flashshop.dto.ProductDTO;
import com.flashshop.entity.ProductEntity;
import com.flashshop.repository.ProductRepository;



@Service
public class TestService {
//	@Autowired
//    private CartRepository cartRepository;

//    @Autowired
//    private UserRepository userRepository;
    
//    @Autowired
//    private ProductRepository productRepository;
    
//    @Autowired
//    private CartProductRepository cartProductRepository;
    
    @Autowired
    private ProductConverter productConverter;
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<ProductDTO> Test(List<String> keys) {
    	List<ProductEntity>  allProductEntity= productRepository.findAll();
    	List<ProductDTO>  allProductDTO= new ArrayList();
    	List<ProductDTO>  result= new ArrayList();
    	result=allProductDTO;
    	for (ProductEntity item:allProductEntity)  {
    		allProductDTO.add(productConverter.toDTO(item));
		}
        
    	for(String tmp : keys ) {
    		String key=this.removeAccent(tmp.toLowerCase());
    	result=result.stream().filter(item->{
    		if(this.removeAccent(item.getName()).toLowerCase().contains(key)
    		   ||this.removeAccent(item.getType()).toLowerCase().contains(key)
    		   ||this.removeAccent(item.getLinkImg()).toLowerCase().contains(key)
    		   ||this.removeAccent(item.getSummary()).toLowerCase().contains(key)
    		   ||this.removeAccent(String.valueOf(item.getPrice())).toLowerCase().contains(key)
                )
    			return true;
    		else return false;
    	}).collect(Collectors.toList()); 
    	}
    	return result;
    	
 
    }
    
    public  String removeAccent(String s) {                    // chuyển chữ hoa thành chữ thường
    	  String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
    	  Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    	  return pattern.matcher(temp).replaceAll("").replace('đ','d').replace('Đ','D');
    	 }
}
