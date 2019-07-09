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

	public Questionario buscarQuestionarioPorId(Long idQuestionario){
		return questionarioRepositorio.findById(idQuestionario).get();
	}
	
	public List <Questionario> buscarTodosQuestionario() {
		return questionarioRepositorio.findAll();
	}
	
	public void deletarQuestionario(Long idQuestionario) {
		questionarioRepositorio.deleteById(idQuestionario);
	}
	
	public Questionario editarQuestionario(Long idQuestionario, Questionario questionario) {
		questionario.setIdQuestionario(idQuestionario);
		return questionarioRepositorio.save(questionario);
	}
	
	public Questionario criarQuestionario(Questionario questionario) {
		return questionarioRepositorio.save(questionario);
	}

}
