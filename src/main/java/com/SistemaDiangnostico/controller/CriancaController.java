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

import com.SistemaDiangnostico.model.Crianca;
import com.SistemaDiangnostico.service.CriancaService;

@Controller
@CrossOrigin
@RequestMapping("/crianca")
public class CriancaController {

	@Autowired
	CriancaService criancaService;

	@GetMapping("/{id}")
	public @ResponseBody Crianca getCriancaPorId(@PathVariable Long id) {
		return criancaService.buscarCriancaPorId(id);
	}

	@GetMapping("/")
	public @ResponseBody List<Crianca> getTodasCrianca() {

		List<Crianca> buscarTodasCrianca = criancaService.buscarTodasCrianca();

		return buscarTodasCrianca;
	}

	@DeleteMapping("/{id}")
	public @ResponseBody boolean deletarCrianca(@PathVariable Long id) {
		criancaService.deletarCrianca(id);
		return true;
	}

	@PostMapping
	public @ResponseBody Crianca editarCrianca(@RequestBody Crianca crianca) {
		return criancaService.editarCrianca(crianca.getIdCrianca(), crianca);
	}

	@PutMapping
	public @ResponseBody Crianca criarCrianca(@RequestBody Crianca crianca) {
		return criancaService.criarCrianca(crianca);
	}
}