package com.SistemaDiangnostico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.model.Doenca;
import com.SistemaDiangnostico.repositorio.DoencaRepositorio;

@Service
public class DoencaService {
	@Autowired
	private DoencaRepositorio doencaRepositorio ;

	public Doenca getDoencaId(Long doencaId) {
		return doencaRepositorio.findById(doencaId).get();
	}

}
