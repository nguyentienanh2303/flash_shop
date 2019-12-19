package com.flashshop.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.flashshop.dto.UserDTO;

public interface IUserService {
	public List<UserDTO> findALL(Pageable pageable);
	public UserDTO findOne(long id);
	public UserDTO save(UserDTO productDTO);
	public UserDTO update(UserDTO productDTO);
	public UserDTO delete(long id);
}
