package com.SistemaDiangnostico.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.dto.DoencaDto;
import com.SistemaDiangnostico.dto.PerguntaDto;
import com.SistemaDiangnostico.dto.RespostaDto;
import com.SistemaDiangnostico.model.Doenca;
import com.SistemaDiangnostico.model.Pergunta;
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
	
	public List<RespostaDto> buscarTodasRespostas() {
		List<Resposta> findAll = respostaRepositorio.findAll();
		
		ArrayList<RespostaDto> respostas = new ArrayList<RespostaDto>();
		for (Resposta resp : findAll) {
			RespostaDto respostaDtos = new RespostaDto(resp);
			respostas.add(respostaDtos);
		}
		return respostas;
	}

}
