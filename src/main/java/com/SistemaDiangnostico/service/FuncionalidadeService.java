package com.SistemaDiangnostico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.model.Funcionalidade;
import com.SistemaDiangnostico.repositorio.FuncionalidadeRepositorio;

@Service
public class FuncionalidadeService {

	@Autowired
 	private FuncionalidadeRepositorio funcionalidadeRepositorio;

	public Funcionalidade buscarFuncionalidadePorId(Long idFuncionalidade){
		return funcionalidadeRepositorio.findById(idFuncionalidade).get();
	}
	
	public List <Funcionalidade> buscarTodasFuncionalidade() {
		return funcionalidadeRepositorio.findAll();
	}
	
	public void deletarFuncionalidade(Long idFuncionalidade) {
		funcionalidadeRepositorio.deleteById(idFuncionalidade);
	}
	
	public Funcionalidade editarFuncionalidade(Long idFuncionalidade, Funcionalidade funcionalidade) {
		funcionalidade.setIdFuncionalidade(idFuncionalidade);
		return funcionalidadeRepositorio.save(funcionalidade);
	}
	
	public Funcionalidade criarFuncionalidade(Funcionalidade funcionalidade) {
		return funcionalidadeRepositorio.save(funcionalidade);
	}

}
