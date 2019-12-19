package com.flashshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.flashshop.converter.UserConverter;
import com.flashshop.dto.UserDTO;
import com.flashshop.entity.CartEntity;
import com.flashshop.entity.UserEntity;
import com.flashshop.repository.CartRepository;
import com.flashshop.repository.UserRepository;
import com.flashshop.service.IUserService;

@Service
public class UserService implements IUserService{
	 @Autowired
	    private UserRepository userRepository;
	 
	 @Autowired
	    private CartRepository cartRepository;
	 
	 @Autowired
	    private UserConverter userConverter;

	@Override
	public List<UserDTO> findALL(Pageable pageable) {
		List<UserDTO> result=new ArrayList<>();
		List<UserEntity> entities= userRepository.findAll(pageable).getContent();
		for(UserEntity item: entities) {
			UserDTO userDTO = userConverter.toDTO(item);
			result.add(userDTO);
		}
		return result;
	}

	@Override
	public UserDTO findOne(long id) {
		UserEntity entity = userRepository.findOne(id);
		if(entity==null) return null;
		return userConverter.toDTO(entity);
	}
	
	public UserDTO findOneNotPass(long id) {
		UserEntity entity = userRepository.findOne(id);
		if(entity==null) return null;
		entity.setPassWord(null);
		return userConverter.toDTO(entity);
	}

	@Override
	public UserDTO save(UserDTO userDTO) {
		if(userRepository.findByEmailAndPassWord(userDTO.getEmail(),userDTO.getPassWord())!=null) return null;
		UserEntity entity = new UserEntity();
		entity=userConverter.toEntity(userDTO);
		entity=userRepository.save(entity);
		CartEntity cartEntity = new CartEntity();
		cartEntity.setStatus(0L);
		cartEntity.setUser(entity);
		cartEntity.setAdress(userDTO.getAdress());
		cartEntity.setFirstName(userDTO.getFirstName());
		cartEntity.setLastName(userDTO.getLastName());
		cartEntity.setPhone(userDTO.getPhone());
		cartRepository.save(cartEntity);
		
		return userConverter.toDTO(entity);
	}

	@Override
	public UserDTO update(UserDTO userDTO) {
		UserEntity entity = userRepository.findOne(userDTO.getId());
		entity=userConverter.toEntity(userDTO,entity);
		userRepository.save(entity);
		return userConverter.toDTO(entity);
	}

	@Override
	public UserDTO delete(long id) {
		UserEntity entity = userRepository.findOne(id);
		userRepository.delete(entity.getId());
		return userConverter.toDTO(entity);
	}
	 
	public long checkUserByEmailAndPassWord(UserDTO userDTO) {
		UserEntity user = userRepository.findByEmailAndPassWord(userDTO.getEmail(),userDTO.getPassWord());
		if(user!=null) return user.getId();

		else return 0;
	}
	 
	public Boolean checkUserByEmail(UserDTO userDTO) {
		if(userRepository.findOneByEmail(userDTO.getEmail()) !=null) return true;

		else return false;
		
	}
	
	public Boolean checkById(Long id) {
		return userRepository.exists(id);

		
	}
	 

}
