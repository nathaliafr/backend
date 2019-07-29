package com.SistemaDiangnostico.service;

import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.model.Doenca;
import com.SistemaDiangnostico.repositorio.DoencaRepositorio;

@Service
public class DoencaService {

	private DoencaRepositorio doencaRepositorio;
	
	public Doenca getDoencaId(Long doencaId){
		return doencaRepositorio.findById(doencaId).get();
	}
	
	
	
}
