package com.SistemaDiangnostico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.model.Usuario;
import com.SistemaDiangnostico.repositorio.UsuarioRepositorio;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	public Usuario buscarUsuarioPorId(Long id){
		return usuarioRepositorio.findById(id).get();
	}
	
	public List <Usuario> buscarTodosUsuario() {
		return usuarioRepositorio.findAll();
	}
	
	public void deletarUsuario(Long id) {
		usuarioRepositorio.deleteById(id);
	}
	
	public Usuario editarUsuario(Long id, Usuario usuario) {
		usuario.setId(id);
		return usuarioRepositorio.save(usuario);
	}
	
	public Usuario criarUsuario(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}

}
