package com.SistemaDiangnostico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.model.Duvida;
import com.SistemaDiangnostico.repositorio.DuvidaRepositorio;

@Service
public class DuvidaService {

	@Autowired
	private DuvidaRepositorio duvidaRepositorio;

	public Duvida buscarDuvidaPorId(Long idDuvida) {
		return duvidaRepositorio.findById(idDuvida).get();
	}

	public List<Duvida> buscarTodasDuvida() {
		return duvidaRepositorio.findAll();
	}

	public void deletarDuvida(Long idDuvida) {
		duvidaRepositorio.deleteById(idDuvida);
	}

	public Duvida editarDuvida(Long idDuvida, Duvida duvida) {
		duvida.setIdDuvida(idDuvida);
		return duvidaRepositorio.save(duvida);
	}

	public Duvida criarDuvida(Duvida duvida) {
		return duvidaRepositorio.save(duvida);
	}

}
