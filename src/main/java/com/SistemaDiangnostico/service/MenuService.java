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

	public Menu buscarMenuPorId(Long idMenu){
		return menuRepositorio.findById(idMenu).get();
	}
	
	public List <Menu> buscarTodosMenu() {
		return menuRepositorio.findAll();
	}
	
	public void deletarMenu(Long idMenu) {
		menuRepositorio.deleteById(idMenu);
	}
	
	public Menu editarMenu(Long idMenu, Menu menu) {
		menu.setIdMenu(idMenu);
		return menuRepositorio.save(menu);
	}
	
	public Menu criarMenu(Menu menu) {
		return menuRepositorio.save(menu);
	}

}
