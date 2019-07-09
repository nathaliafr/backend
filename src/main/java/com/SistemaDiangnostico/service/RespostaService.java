package com.SistemaDiangnostico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.model.Resposta;
import com.SistemaDiangnostico.repositorio.RespostaRepositorio;

@Service
public class RespostaService {

	@Autowired
	private RespostaRepositorio respostaRepositorio;
	
	public Resposta buscarRespostaPorId (Long idResposta) {
		return respostaRepositorio.findById(idResposta).get();
	}
	
	public List<Resposta> buscarTodasResposta() {
		return respostaRepositorio.findAll();
	}
	
	public void deletarResposta(Long idResposta) {
		respostaRepositorio.deleteById(idResposta);
	}
	
	public Resposta editarResposta(Long idResposta, Resposta resposta) {
		resposta.setIdResposta(idResposta);
		return respostaRepositorio.save(resposta);
	}
	
	public Resposta criarResposta(Resposta resposta) {
		return respostaRepositorio.save(resposta);
	}

}
