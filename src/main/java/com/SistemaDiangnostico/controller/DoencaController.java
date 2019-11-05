package com.SistemaDiangnostico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SistemaDiangnostico.dto.DoencaDto;
import com.SistemaDiangnostico.service.DoencaService;

@Controller
@CrossOrigin
@RequestMapping("/doenca")
public class DoencaController {

	@Autowired
	private DoencaService doencaService;
	
	@GetMapping("/")
	public @ResponseBody List<DoencaDto> buscarTodasDoencasMenosSaudavel() {
		List<DoencaDto> buscarTodasDoencas = doencaService.buscarTodasDoencasMenosSaudavel();
		return buscarTodasDoencas;
	}

	
	
	@GetMapping("/todas")
	public @ResponseBody List<DoencaDto> getTodasDoencas() {
		List<DoencaDto> buscarTodasDoencas = doencaService.getTodasDoencas();
		return buscarTodasDoencas;
	}
}
