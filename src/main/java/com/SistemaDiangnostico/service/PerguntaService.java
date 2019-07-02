package com.SistemaDiangnostico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.model.Pergunta;
import com.SistemaDiangnostico.repositorio.PerguntaRepositorio;

@Service
public class PerguntaService {

	@Autowired
	private PerguntaRepositorio perguntaRepositorio;
	
	public Pergunta buscarPerguntaPorId(Long id) {
		return perguntaRepositorio.findById(id).get();
	}
	
	public List<Pergunta> buscarTodasPergunta() {
		return perguntaRepositorio.findAll();
	}
	
	public void deletarPergunta(Long id) {
		perguntaRepositorio.deleteById(id);
	}
	
	public Pergunta editarPergunta(Long id, Pergunta pergunta) {
		pergunta.setId(id);
		return perguntaRepositorio.save(pergunta);
	}
	
	public Pergunta criarPergunta(Pergunta pergunta) {
		return perguntaRepositorio.save(pergunta);
	}
	
}
