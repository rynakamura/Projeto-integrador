package com.generation.redeSocialG2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.redeSocialG2.model.UserLoginModel;
import com.generation.redeSocialG2.model.UsuarioModel;
import com.generation.redeSocialG2.repository.UsuarioRepository;
import com.generation.redeSocialG2.service.UsuarioService;

@RestController
@RequestMapping ("/usuarios")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class UsuarioController 
{
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<UsuarioModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping ("/login")
	public ResponseEntity<UserLoginModel> login (@RequestBody Optional<UserLoginModel> userLogin)
	{
		return usuarioService.loginUsuario(userLogin)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED)
						.build());
	}
	
	@PostMapping ("/signin")
	public ResponseEntity<UsuarioModel> cadastrar (@RequestBody UsuarioModel usuarioCadastro)
	{
		Optional<UsuarioModel> user = usuarioService.cadastrarUsuario(usuarioCadastro);
		
		try 
		{
			return ResponseEntity.ok(user.get());
			
		} 
		catch (Exception e) 
		{
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping
	public ResponseEntity<UsuarioModel> Put(@RequestBody UsuarioModel usuario) {
		return ResponseEntity.ok(repository.save(usuario));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
