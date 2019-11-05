package com.SistemaDiangnostico.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.SistemaDiangnostico.dto.GraficoResultadoDto;
import com.SistemaDiangnostico.dto.QuestionarioDto;
import com.SistemaDiangnostico.dto.ResponderPerguntaRequestList;
import com.SistemaDiangnostico.dto.RespostaEspecialistaDTO;
import com.SistemaDiangnostico.model.Questionario;
import com.SistemaDiangnostico.service.QuestionarioService;

@Controller
@CrossOrigin
@RequestMapping ("/questionario")
public class QuestionarioController {

	@Autowired
	QuestionarioService questionarioService;
	
	@GetMapping ("/{id}")
	public @ResponseBody Questionario getQuestionarioPorId (@PathVariable Long id) {
		return questionarioService.buscarQuestionarioPorId(id);
	}
	
	@GetMapping ("/grafico/{idQuestionario}")
	public @ResponseBody GraficoResultadoDto getGraficoDiangnostivoPorId (@PathVariable Long idQuestionario) {
		return questionarioService.getGrafico(idQuestionario);
	}
	
	@GetMapping ("/crianca/{idCrianca}")
	public @ResponseBody List<QuestionarioDto> buscarQuestionarioPorIdQuestionarioEIdCrianca (@PathVariable Long idCrianca) {
		return questionarioService.buscarQuestionarioPorIdQuestionarioEIdCrianca(idCrianca);
	}
	
	
	
	@GetMapping("/")
	public @ResponseBody List<Questionario> getTodosQuestionario () {
		
		List<Questionario> buscarTodosQuestionario = questionarioService.buscarTodosQuestionario();
		 
		return buscarTodosQuestionario;
	}
	
	
	
	
	@DeleteMapping ("/{id}")
	public @ResponseBody boolean deletarQuestionario(@PathVariable Long id) {
		questionarioService.deletarQuestionario(id);
		return true;
	}
	
	

	@PostMapping("/respostaDoEscialista")
	public @ResponseBody ResponseEntity<Map<String, String>> editarQuestionario(@RequestBody RespostaEspecialistaDTO req) {
		return ResponseEntity.ok().body(questionarioService.respostaDoEspecialista(req));
	}
	
	
	@PostMapping
	public @ResponseBody Questionario respostaEspecialista(@RequestBody Questionario questionario) {
		return questionarioService.editarQuestionario(questionario.getIdQuestionario(), questionario);
	}
	
	@PostMapping("/responderPergunta")
	public @ResponseBody GraficoResultadoDto responderPergunta(@RequestBody ResponderPerguntaRequestList responderPerguntaRequest) {
		GraficoResultadoDto graficoResultadoDto = questionarioService.responderPerguntaRequest(responderPerguntaRequest.getCriancaId() , responderPerguntaRequest.getResponderPerguntaRequestList());
 		return graficoResultadoDto;
	}
	
	
	
	
	@PutMapping
	public @ResponseBody Questionario criarQuestionario(@RequestBody Questionario questionario) {
		return questionarioService.criarQuestionario(questionario);
	}
	
	
	
}