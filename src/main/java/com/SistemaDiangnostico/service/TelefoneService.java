package com.SistemaDiangnostico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.model.Telefone;
import com.SistemaDiangnostico.repositorio.TelefoneRepositorio;

@Service
public class TelefoneService {

	@Autowired
	private TelefoneRepositorio telefoneRepositorio;
	
	public Telefone buscarTelefonePorId(Long id) {
		return telefoneRepositorio.findById(id).get();
	}
	
	public List<Telefone> buscarTodosTelefone(){
		return telefoneRepositorio.findAll();
	}
	
	public void deletarTelefone(Long id) {
		telefoneRepositorio.deleteById(id);
	}
	
	public Telefone editarTelefone(Long id, Telefone telefone) {
		telefone.setIdTelefone(id);
		return telefoneRepositorio.save(telefone);
	}
	
	public Telefone criarTelefone(Telefone telefone) {
		return telefoneRepositorio.save(telefone);
	}
}
