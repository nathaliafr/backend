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

import com.SistemaDiangnostico.dto.RespostaDto;
import com.SistemaDiangnostico.model.Resposta;
import com.SistemaDiangnostico.service.RespostaService;

@Controller
@CrossOrigin
@RequestMapping ("/resposta")
public class RespostaController {

	@Autowired
	RespostaService respostaService;
	
	@GetMapping("/{id}")
	public @ResponseBody Resposta getRespostaPorId(@PathVariable Long id) {
		return respostaService.buscarRespostaPorId(id);
	}
	
	/*
	 * @GetMapping("/") public @ResponseBody List<RespostaDto> getTodasResposta(){
	 * List<RespostaDto> buscarTodasResposta =
	 * respostaService.buscarTodasResposta(); return buscarTodasResposta; }
	 */
	
	@GetMapping("/")
	public @ResponseBody List<RespostaDto> getTodasResposta(){
		List<RespostaDto> buscarTodasRespostas = respostaService.buscarTodasRespostas();
		return buscarTodasRespostas;
	}
	
	@DeleteMapping
	public @ResponseBody boolean deletarResposta(@PathVariable Long id) {
		respostaService.deletarResposta(id);
		return true;
	}
	
	@PostMapping
	public @ResponseBody Resposta editarResposta(@RequestBody Resposta resposta) {
		return respostaService.editarResposta(resposta.getIdResposta(), resposta);
	}
	
	@PutMapping
	public @ResponseBody Resposta criarResposta(@RequestBody Resposta resposta) {
		return respostaService.criarResposta(resposta);
	}
	
}
