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

	public Categoria buscarCategoriaPorId(Long idCategoria) {
		return categoriaRepositorio.findById(idCategoria).get();
	}

	public List<Categoria> buscarTodasCategoria() {
		return categoriaRepositorio.findAll();
	}

	public void deletarCategoria(Long idCategoria) {
		categoriaRepositorio.deleteById(idCategoria);
	}

	public Categoria editarCategoria(Long idCategoria, Categoria categoria) {
		categoria.setIdCategoria(idCategoria);
		return categoriaRepositorio.save(categoria);
	}

	public Categoria criarCategoria(Categoria categoria) {
		return categoriaRepositorio.save(categoria);
	}

}
