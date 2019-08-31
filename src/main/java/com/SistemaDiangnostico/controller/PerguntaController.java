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

import com.SistemaDiangnostico.dto.CriterioDto;
import com.SistemaDiangnostico.dto.PerguntaDto;
import com.SistemaDiangnostico.model.Pergunta;
import com.SistemaDiangnostico.service.PerguntaService;

@Controller
@CrossOrigin
@RequestMapping ("/pergunta")
public class PerguntaController {

	@Autowired
	private PerguntaService perguntaService;
	
	@GetMapping("/{id}")
	public @ResponseBody Pergunta getPerguntaPorId(@PathVariable Long id) {
		return perguntaService.buscarPerguntaPorId(id);
	}
	
	@GetMapping("/")
	public @ResponseBody List<PerguntaDto> getTodasPergunta(){
		List<PerguntaDto> buscarTodasPergunta = perguntaService.buscarTodasPergunta();
		return buscarTodasPergunta;
	}
	
	@DeleteMapping
	public @ResponseBody boolean deletarPergunta(@PathVariable Long id) {
		perguntaService.deletarPergunta(id);
		return true;
	}
	
	@PostMapping
	public @ResponseBody Pergunta editarPergunta(@RequestBody Pergunta pergunta) {
		return perguntaService.editarPergunta(pergunta.getIdPergunta(), pergunta);
	}
	
	@PutMapping
	public @ResponseBody Pergunta criarPergunta(@RequestBody Pergunta pergunta) {
		return perguntaService.criarPergunta(pergunta);
	}
	
	/*@PostMapping ("/criterioPergunta")
	public @ResponseBody Pergunta criterioPergunta(@RequestBody CriterioDto criterio){
		Pergunta criterioPergunta = perguntaService.buscaCriterio(criterio);
		return criterioPergunta;
	}*/
}
