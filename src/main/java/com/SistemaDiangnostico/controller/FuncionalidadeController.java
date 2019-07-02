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

import com.SistemaDiangnostico.model.Funcionalidade;
import com.SistemaDiangnostico.service.FuncionalidadeService;


@Controller
@RequestMapping ("/funcionalidade")
public class FuncionalidadeController {

	@Autowired
	FuncionalidadeService funcionalidadeService;
	
	@GetMapping ("/{id}")
	public @ResponseBody Funcionalidade getFuncionalidadePorId (@PathVariable Long id) {
		return funcionalidadeService.buscarFuncionalidadePorId(id);
	}
	
	@GetMapping("/")
	public @ResponseBody List<Funcionalidade> getTodasFuncionalidade () {
		
		List<Funcionalidade> buscarTodasFuncionalidade = funcionalidadeService.buscarTodasFuncionalidade();
		 
		return buscarTodasFuncionalidade;
	}
	
	@DeleteMapping ("/{id}")
	public @ResponseBody boolean deleteFuncionalidade(@PathVariable Long id) {
		funcionalidadeService.deletarFuncionalidade(id);
		return true;
	}
	
	@PostMapping
	public @ResponseBody Funcionalidade editarFuncionalidade(@RequestBody Funcionalidade funcionalidade) {
		return funcionalidadeService.editarFuncionalidade(funcionalidade.getId(), funcionalidade);
	}
	
	@PutMapping
	public @ResponseBody Funcionalidade criarFuncionalidade(@RequestBody Funcionalidade funcionalidade) {
		return funcionalidadeService.criarFuncionalidade(funcionalidade);
	}
}