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

	public Funcionalidade buscarFuncionalidadePorId(Long id){
		return funcionalidadeRepositorio.findById(id).get();
	}
	
	public List <Funcionalidade> buscarTodasFuncionalidade() {
		return funcionalidadeRepositorio.findAll();
	}
	
	public void deletarFuncionalidade(Long id) {
		funcionalidadeRepositorio.deleteById(id);
	}
	
	public Funcionalidade editarFuncionalidade(Long id, Funcionalidade funcionalidade) {
		funcionalidade.setId(id);
		return funcionalidadeRepositorio.save(funcionalidade);
	}
	
	public Funcionalidade criarFuncionalidade(Funcionalidade funcionalidade) {
		return funcionalidadeRepositorio.save(funcionalidade);
	}

}
