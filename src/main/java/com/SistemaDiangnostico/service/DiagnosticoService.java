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

	public Diagnostico buscarDiagnosticoPorId(Long idDiagnostico) {
		return diagnosticoRepositorio.findById(idDiagnostico).get();
	}

	public List<Diagnostico> buscarTodosDiagnostico() {
		return diagnosticoRepositorio.findAll();
	}

	public void deletarDiagnostico(Long idDiagnostico) {
		diagnosticoRepositorio.deleteById(idDiagnostico);
	}

	public Diagnostico editarDiagnostico(Long idDiagnostico, Diagnostico diagnostico) {
		diagnostico.setIdDiagnostico(idDiagnostico);
		return diagnosticoRepositorio.save(diagnostico);
	}

	public Diagnostico criarDiagnostico(Diagnostico diagnostico) {
		return diagnosticoRepositorio.save(diagnostico);
	}

}
