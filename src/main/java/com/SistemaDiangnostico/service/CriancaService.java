package com.SistemaDiangnostico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.model.Crianca;
import com.SistemaDiangnostico.repositorio.CriancaRepositorio;

@Service
public class CriancaService {

	@Autowired
	private CriancaRepositorio criancaRepositorio;

	public Crianca buscarCriancaPorId(Long idCrianca) {
		
		return criancaRepositorio.findById(idCrianca).get();
	}
	
	public List<Crianca> buscarCriancaPorIdUsuario(Long idCrianca) {
		
		return criancaRepositorio.findByIdUsuario(idCrianca);
	}
	
	
	
	
	public List<Crianca> buscarTodasCrianca() {
		return criancaRepositorio.findAll();
	}

	public void deletarCrianca(Long idCrianca) {
		criancaRepositorio.deleteById(idCrianca);
	}

	public Crianca editarCrianca(Long idCrianca, Crianca crianca) {
		crianca.setIdCrianca(idCrianca);
		return criancaRepositorio.save(crianca);
	}

	public Crianca criarCrianca(Crianca crianca) {
		return criancaRepositorio.save(crianca);
	}

}
