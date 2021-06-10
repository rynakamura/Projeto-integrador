package com.generation.redeSocialG2.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.generation.redeSocialG2.model.UsuarioModel;
//implements - interface 
//extends - classe

public class UserDetailsImplements implements UserDetails
{
	private static final long serialVersionUID = 1L;
	//atributos
	private String userName;
	private String password;
	private List<GrantedAuthority> authorities;
	
	//como funciona esse construtor ?
	//construtores
	public UserDetailsImplements(UsuarioModel user) {
		super();
		this.userName = user.getNomeCompleto();
		this.password = user.getSenha();
	}
	
	public UserDetailsImplements() {
		//super();
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	

}
