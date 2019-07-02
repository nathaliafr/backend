package com.SistemaDiangnostico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.model.Questionario;
import com.SistemaDiangnostico.repositorio.QuestionarioRepositorio;

@Service
public class QuestionarioService {
	@Autowired
 	private QuestionarioRepositorio questionarioRepositorio;

	public Questionario buscarQuestionarioPorId(Long id){
		return questionarioRepositorio.findById(id).get();
	}
	
	public List <Questionario> buscarTodosQuestionario() {
		return questionarioRepositorio.findAll();
	}
	
	public void deletarQuestionario(Long id) {
		questionarioRepositorio.deleteById(id);
	}
	
	public Questionario editarQuestionario(Long id, Questionario questionario) {
		questionario.setId(id);
		return questionarioRepositorio.save(questionario);
	}
	
	public Questionario criarQuestionario(Questionario questionario) {
		return questionarioRepositorio.save(questionario);
	}

}
