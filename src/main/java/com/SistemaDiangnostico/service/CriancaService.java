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

	public Crianca buscarCriancaPorId(Long id) {
		return criancaRepositorio.findById(id).get();
	}

	public List<Crianca> buscarTodasCrianca() {
		return criancaRepositorio.findAll();
	}

	public void deletarCrianca(Long id) {
		criancaRepositorio.deleteById(id);
	}

	public Crianca editarCrianca(Long id, Crianca crianca) {
		crianca.setId(id);
		return criancaRepositorio.save(crianca);
	}

	public Crianca criarCrianca(Crianca crianca) {
		return criancaRepositorio.save(crianca);
	}

}
