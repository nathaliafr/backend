package com.SistemaDiangnostico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.model.Menu;
import com.SistemaDiangnostico.repositorio.MenuRepositorio;

@Service
public class MenuService {

	@Autowired
 	private MenuRepositorio menuRepositorio;

	public Menu buscarMenuPorId(Long id){
		return menuRepositorio.findById(id).get();
	}
	
	public List <Menu> buscarTodosMenu() {
		return menuRepositorio.findAll();
	}
	
	public void deletarMenu(Long id) {
		menuRepositorio.deleteById(id);
	}
	
	public Menu editarMenu(Long id, Menu menu) {
		menu.setId(id);
		return menuRepositorio.save(menu);
	}
	
	public Menu criarMenu(Menu menu) {
		return menuRepositorio.save(menu);
	}

}
