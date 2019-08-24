package com.SistemaDiangnostico.service;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.dto.LoginDto;
import com.SistemaDiangnostico.dto.ResetSenhaDto;
import com.SistemaDiangnostico.model.Usuario;
import com.SistemaDiangnostico.repositorio.UsuarioRepositorio;

@Service
public class LoginService {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	public Usuario login(LoginDto login) throws Exception {

		Usuario usuario = usuarioRepositorio.findByEmail(login.getEmail());

		if (usuario != null && usuario.getSenha().equals(login.getSenha())) {

			return usuario;
		} else {
			throw new Exception("Email ou Senha incorreta");
		}

	}

	public Usuario resetSenha(ResetSenhaDto resetSenha) throws Exception {
		
		Usuario usuario = usuarioRepositorio.findByEmail(resetSenha.getEmail());

		if (usuario == null) {
			throw new Exception("Dados invalidos");
		}

		String dataNacimento = formatarData(usuario);
		
		return validarResetSenha(resetSenha, usuario, dataNacimento);
	}

	private Usuario validarResetSenha(ResetSenhaDto resetSenha, Usuario usuario, String dataNacimento) throws Exception {
		if (usuario.getDocumento().equals(resetSenha.getDocumento())
				&& dataNacimento.equals(resetSenha.getDataNascimento())) {
			usuario.setSenha(resetSenha.getNovaSenha());
			return usuarioRepositorio.save(usuario);
		} else {
			throw new Exception("Dados invalidos");
		}
	}

	private String formatarData(Usuario usuario) {
		SimpleDateFormat dataDateFormat =  new SimpleDateFormat("dd/MM/yyyy");
		String dataNacimento = dataDateFormat.format(usuario.getDataNascimento());
		return dataNacimento;
	}

}
