package com.SistemaDiangnostico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.model.Categoria;
import com.SistemaDiangnostico.repositorio.CategoriaRepositorio;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

	public Categoria buscarCategoriaPorId(Long id) {
		return categoriaRepositorio.findById(id).get();
	}

	public List<Categoria> buscarTodasCategoria() {
		return categoriaRepositorio.findAll();
	}

	public void deletarCategoria(Long id) {
		categoriaRepositorio.deleteById(id);
	}

	public Categoria editarCategoria(Long id, Categoria categoria) {
		categoria.setId(id);
		return categoriaRepositorio.save(categoria);
	}

	public Categoria criarCategoria(Categoria categoria) {
		return categoriaRepositorio.save(categoria);
	}

}
