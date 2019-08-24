package com.SistemaDiangnostico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SistemaDiangnostico.dto.LoginDto;
import com.SistemaDiangnostico.dto.ResetSenhaDto;
import com.SistemaDiangnostico.model.Usuario;
import com.SistemaDiangnostico.service.LoginService;

@CrossOrigin
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping
	public @ResponseBody ResponseEntity<Usuario> login(@RequestBody LoginDto login) {
		try {
			return ResponseEntity.ok(loginService.login(login));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping("/resetSenha")
	public @ResponseBody ResponseEntity<Usuario> resetSenha(@RequestBody ResetSenhaDto resetSenha) {
		try {
			return ResponseEntity.ok(loginService.resetSenha(resetSenha));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

}
