package com.generation.redeSocialG2.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.generation.redeSocialG2.model.UserLoginModel;
import com.generation.redeSocialG2.model.UsuarioModel;
import com.generation.redeSocialG2.repository.UsuarioRepository;

@Service
public class UsuarioService 
{
	@Autowired
	private UsuarioRepository repository;
	
	// aqui utilizamos o optional para nao cadastrar o mesmo user 2 vezes 
	public Optional<UsuarioModel> cadastrarUsuario (UsuarioModel user)
	{
		if (repository.findByEmail(user.getEmail()).isPresent())
		{
			return null;
			// da pra por uma mensagem de 'email ja cadastrado' ?
			// esse return funciona como um break ?
		}
		//instanciando a criptografia
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//tem como fazer essa variação aqui ??
		//encoder = (BCryptPasswordEncoder::new);
		String senhaEncoder = encoder.encode(user.getSenha());
		user.setSenha(senhaEncoder);
		return Optional.of(repository.save(user));
	}
	
	public Optional<UserLoginModel> loginUsuario (Optional<UserLoginModel> userLogin)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Optional<UsuarioModel> userDB = repository.findByEmail(userLogin.get().getEmail());
		
		if (userDB.isPresent())
		{
			if (encoder.matches(userLogin.get().getSenha(), userDB.get().getSenha()))
			{
				//auth = autenticação
				String authToken = userLogin.get().getEmail() 
						+ ":" + userLogin.get().getSenha();	
				
				// nosso token gerado (encoded Auth Token)
				byte []encodedAuthToken = Base64.encodeBase64(authToken.getBytes(Charset.forName("US-ASCII")));
				
				String tokenFinal = "Basic " + new String (encodedAuthToken); 
				
				userLogin.get().setToken(tokenFinal);
				
				userLogin.get().setNomeCompleto(userDB.get().getNomeCompleto());
			
				userLogin.get().setSenha(userDB.get().getSenha());
				
				return userLogin;
			}
		}
		
		return Optional.empty();
	}
	
	

}
