package com.SistemaDiangnostico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.model.Diagnostico;
import com.SistemaDiangnostico.repositorio.DiagnosticoRepositorio;

@Service
public class DiagnosticoService {

	@Autowired
	private DiagnosticoRepositorio diagnosticoRepositorio;

	public Diagnostico buscarDiagnosticoPorId(Long id) {
		return diagnosticoRepositorio.findById(id).get();
	}

	public List<Diagnostico> buscarTodosDiagnostico() {
		return diagnosticoRepositorio.findAll();
	}

	public void deletarDiagnostico(Long id) {
		diagnosticoRepositorio.deleteById(id);
	}

	public Diagnostico editarDiagnostico(Long id, Diagnostico diagnostico) {
		diagnostico.setId(id);
		return diagnosticoRepositorio.save(diagnostico);
	}

	public Diagnostico criarDiagnostico(Diagnostico diagnostico) {
		return diagnosticoRepositorio.save(diagnostico);
	}

}
