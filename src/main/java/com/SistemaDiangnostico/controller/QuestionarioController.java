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

import com.SistemaDiangnostico.model.Questionario;
import com.SistemaDiangnostico.service.QuestionarioService;

@Controller
@RequestMapping ("/questionario")
public class QuestionarioController {

	@Autowired
	QuestionarioService questionarioService;
	
	@GetMapping ("/{id}")
	public @ResponseBody Questionario getQuestionarioPorId (@PathVariable Long id) {
		return questionarioService.buscarQuestionarioPorId(id);
	}
	
	@GetMapping("/")
	public @ResponseBody List<Questionario> getTodosQuestionario () {
		
		List<Questionario> buscarTodosQuestionario = questionarioService.buscarTodosQuestionario();
		 
		return buscarTodosQuestionario;
	}
	
	@DeleteMapping ("/{id}")
	public @ResponseBody boolean deletarQuestionario(@PathVariable Long id) {
		questionarioService.deletarQuestionario(id);;
		return true;
	}
	
	@PostMapping
	public @ResponseBody Questionario editarQuestionario(@RequestBody Questionario questionario) {
		return questionarioService.editarQuestionario(questionario.getIdQuestionario(), questionario);
	}
	
	@PutMapping
	public @ResponseBody Questionario criarQuestionario(@RequestBody Questionario questionario) {
		return questionarioService.criarQuestionario(questionario);
	}
}