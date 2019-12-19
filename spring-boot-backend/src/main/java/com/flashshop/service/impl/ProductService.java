package com.flashshop.service.impl;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.flashshop.converter.ProductConverter;
import com.flashshop.dto.ProductDTO;
import com.flashshop.entity.ProductEntity;
import com.flashshop.repository.ProductRepository;
import com.flashshop.service.IProductService;

@Service
public class ProductService implements IProductService{
	
    
    @Autowired
    private ProductRepository productRepository;
    
 
    @Autowired
    private ProductConverter productConverter;
    
	@Override
	public List<ProductDTO> findALL(Pageable pageable) {
		List<ProductDTO> result=new ArrayList<>();
		List<ProductEntity> entities= productRepository.findAll(pageable).getContent();
		for(ProductEntity item: entities) {
			ProductDTO productDTO = productConverter.toDTO(item);
			result.add(productDTO);
		}
		return result;
	}
	
	@Override
	public List<ProductDTO> findALL(int page, int limit, String type) {
		List<ProductDTO> result=new ArrayList<>();
		List<ProductDTO> finalResult=new ArrayList<>();
		List<ProductEntity> entities= productRepository.findAll();
		for(ProductEntity item: entities) {                           //lọc tất cả sản phẩm theo type
			ProductDTO productDTO = productConverter.toDTO(item);
			if(type.equals("all")) result.add(productDTO);
			else {
				if(productDTO.getType().equals(type)) result.add(productDTO);
			}
			
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

	@Override
	public ProductDTO findOne(long id) {
		ProductEntity entity = productRepository.findOne(id);
		return productConverter.toDTO(entity);
	}

	@Override
	public ProductDTO save(ProductDTO productDTO) {
		ProductEntity entity = new ProductEntity();
		entity=productConverter.toEntity(productDTO);
        productRepository.save(entity);
		return productConverter.toDTO(entity);
	}
	
	@Override
	public ProductDTO update(ProductDTO productDTO) {
		ProductEntity entity = productRepository.findOne(productDTO.getId());
		entity=productConverter.toEntity(productDTO,entity);
        productRepository.save(entity);
		return productConverter.toDTO(entity);
	}

	@Override
	public ProductDTO delete(long id) {
		ProductEntity entity = productRepository.findOne(id);
		productRepository.delete(entity.getId());
		return productConverter.toDTO(entity);
	}
	
	public int totalItem() {
		return (int) productRepository.count();
	}

	
	
    public List<ProductDTO> searchProduct(List<String> keys) {
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
