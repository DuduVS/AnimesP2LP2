package com.animes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.animes.domain.Usuario;
import com.animes.repository.UsuarioRepository;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping("/usuarios")
	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios = repository.findAll();
		
		return usuarios;
	}

	@GetMapping("/usuarios/{id}")
	public Optional<Usuario> getUsuario(@PathVariable int id) {
		Optional<Usuario> usuario = repository.findById(id);
		
		return usuario;
	}
	
	@PostMapping("/usuarios")
	public void saveUsuario(@RequestBody Usuario usuario) {
		repository.save(usuario);
	}
}
