package com.SistemaDiangnostico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.model.Usuario;
import com.SistemaDiangnostico.repositorio.UsuarioRepositorio;

@Service
public class LoginService {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	public Usuario findbyEmail(String email) {
		return usuarioRepositorio.findbyEmail(email);
	}
}
