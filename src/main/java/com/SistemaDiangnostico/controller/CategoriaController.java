package com.SistemaDiangnostico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SistemaDiangnostico.model.Categoria;
import com.SistemaDiangnostico.service.CategoriaService;

@Controller
@CrossOrigin
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@GetMapping("/{id}")
	public @ResponseBody Categoria getCategoriaPorId(@PathVariable Long id) {
		return categoriaService.buscarCategoriaPorId(id);
	}

	@GetMapping("/")
	public @ResponseBody List<Categoria> getTodasCategoria() {

		List<Categoria> buscarTodasCategoria = categoriaService.buscarTodasCategoria();

		return buscarTodasCategoria;
	}

	@DeleteMapping("/{id}")
	public @ResponseBody boolean deletearCategoria(@PathVariable Long id) {
		categoriaService.deletarCategoria(id);
		return true;
	}

	@PostMapping
	public @ResponseBody Categoria editarCategoria(@RequestBody Categoria categoria) {
		return categoriaService.editarCategoria(categoria.getIdCategoria(), categoria);
	}

	@PutMapping
	public @ResponseBody Categoria criarUsuario(@RequestBody Categoria categoria) {
		return categoriaService.criarCategoria(categoria);
	}
}