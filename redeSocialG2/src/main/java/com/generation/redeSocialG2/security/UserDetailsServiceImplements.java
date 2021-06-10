package com.generation.redeSocialG2.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.redeSocialG2.model.UsuarioModel;
import com.generation.redeSocialG2.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImplements implements UserDetailsService
{
	//autowired sempre private, porque a interface n pode ser modificada
	@Autowired
	private UsuarioRepository usuarioRepository;

	//throws UsernameNotFoundException 
	@Override
	public UserDetails loadUserByUsername(String userName)
	{
		Optional<UsuarioModel> user = usuarioRepository.findByEmail(userName);
		
		user.orElseThrow(()-> new UsernameNotFoundException(userName+ "Not Found"));
	
		//variação da expressão lambda
		return user.map(UserDetailsImplements::new).get();
	}
	

}
