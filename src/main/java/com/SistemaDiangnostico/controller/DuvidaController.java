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

import com.SistemaDiangnostico.model.Duvida;
import com.SistemaDiangnostico.service.DuvidaService;

@Controller
@RequestMapping("/duvida")
public class DuvidaController {

	@Autowired
	DuvidaService duvidaService;

	@GetMapping("/{id}")
	public @ResponseBody Duvida getDuvidaPorId(@PathVariable Long id) {
		return duvidaService.buscarDuvidaPorId(id);
	}

	@GetMapping("/")
	public @ResponseBody List<Duvida> getTodasDuvida() {

		List<Duvida> buscarTodasDuvida = duvidaService.buscarTodasDuvida();

		return buscarTodasDuvida;
	}

	@DeleteMapping("/{id}")
	public @ResponseBody boolean deletarDuvida(@PathVariable Long id) {
		duvidaService.deletarDuvida(id);
		return true;
	}

	@PostMapping
	public @ResponseBody Duvida editarDuvida(@RequestBody Duvida duvida) {
		return duvidaService.editarDuvida(duvida.getIdDuvida(), duvida);
	}

	@PutMapping
	public @ResponseBody Duvida criardDuvida(@RequestBody Duvida duvida) {
		return duvidaService.criarDuvida(duvida);
	}
}