package com.SistemaDiangnostico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SistemaDiangnostico.model.Usuario;
import com.SistemaDiangnostico.service.UsuarioService;


@Controller
@RequestMapping ("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping ("/{id}")
	public @ResponseBody Usuario getUsuarioPorId (@PathVariable Long id) {
		return usuarioService.buscarUsuarioPorId(id);
	}
	
	@GetMapping("/")
	public @ResponseBody List<Usuario> getTodosUsuario () {
		
		List<Usuario> buscarTodosUsuario = usuarioService.buscarTodosUsuario();
		 
		return buscarTodosUsuario;
	}
	
	@DeleteMapping ("/{id}")
	public @ResponseBody boolean deleteUsuario(@PathVariable Long id) {
		usuarioService.deletarUsuario(id);
		return true;
	}
	
	@PostMapping
	public @ResponseBody Usuario editarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.editarUsuario(usuario.getIdUsuario(), usuario);
	}
	
	@PutMapping
	public @ResponseBody Usuario criarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.criarUsuario(usuario);
	}
}