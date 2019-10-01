package com.SistemaDiangnostico.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.dto.DoencaDto;
import com.SistemaDiangnostico.model.Doenca;
import com.SistemaDiangnostico.repositorio.DoencaRepositorio;

@Service
public class DoencaService {
	@Autowired
	private DoencaRepositorio doencaRepositorio ;

	public Doenca getDoencaId(Long doencaId) {
		return doencaRepositorio.findById(doencaId).get();
	}

	public List<DoencaDto> buscarTodasDoencas() {
		List<Doenca> list = doencaRepositorio.findByNomeNot("Saudavel");
		
		ArrayList<DoencaDto> doencas = new ArrayList<DoencaDto>();
		for (Doenca doenca : list) {
			DoencaDto doencaDto = new DoencaDto(doenca);
			doencas.add(doencaDto);
		}
		return doencas;
	}

}
