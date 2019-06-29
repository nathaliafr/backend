package com.SistemaDiangnostico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SistemaDiangnostico.model.Usuario;
import com.SistemaDiangnostico.service.UsuarioService;


@RestController
@RequestMapping ("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping ("/{id}")
	public Usuario getUsuarioPorId (@PathVariable Long id) {
		return usuarioService.buscarUsuarioPorId(id);
	}
	
	@GetMapping
	public List <Usuario> getTodosUsuario () {
		return usuarioService.buscarTodosUsuario();
	}
	
	@DeleteMapping ("/{id}")
	public boolean deleteUsuario(@PathVariable Long id) {
		usuarioService.deletarUsuario(id);
		return true;
	}
	
	@PostMapping
	public Usuario editarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.editarUsuario(usuario.getId(), usuario);
	}
	
	@PutMapping
	public Usuario criarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.criarUsuario(usuario);
	}
}