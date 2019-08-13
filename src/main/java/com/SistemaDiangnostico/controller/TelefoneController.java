package com.SistemaDiangnostico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SistemaDiangnostico.model.Telefone;
import com.SistemaDiangnostico.service.TelefoneService;

@Controller
@CrossOrigin
@RequestMapping ("/telefone")
public class TelefoneController {

	@Autowired
	TelefoneService telefoneService;
	
	@GetMapping("/{id}")
	public @ResponseBody Telefone getTelefonePorId (@PathVariable Long id) {
		return telefoneService.buscarTelefonePorId(id);
	}
	
	@GetMapping("/")
	public @ResponseBody List<Telefone> getTodosTelefones(){
		List<Telefone> buscarTodosTelefones = telefoneService.buscarTodosTelefone();
		return buscarTodosTelefones;
	}
	
	@DeleteMapping
	public @ResponseBody boolean deletarTelefone(@PathVariable Long id) {
		telefoneService.deletarTelefone(id);
		return true;
	}
	
	@PostMapping
	public @ResponseBody Telefone editarTelefone(@RequestBody Telefone telefone) {
		return telefoneService.editarTelefone(telefone.getIdTelefone(), telefone);
	}
	
	@PutMapping
	public @ResponseBody Telefone criarTelefone(@RequestBody Telefone telefone) {
		return telefoneService.criarTelefone(telefone);
	}

}
