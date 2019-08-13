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

import com.SistemaDiangnostico.model.Menu;
import com.SistemaDiangnostico.service.MenuService;

@Controller
@CrossOrigin
@RequestMapping ("/menu")
public class MenuController {

	@Autowired
	MenuService menuService;
	
	@GetMapping ("/{id}")
	public @ResponseBody Menu getMenuPorId (@PathVariable Long id) {
		return menuService.buscarMenuPorId(id);
	}
	
	@GetMapping("/")
	public @ResponseBody List<Menu> getTodosMenu () {
		
		List<Menu> buscarTodosMenu = menuService.buscarTodosMenu();
		 
		return buscarTodosMenu;
	}
	
	@DeleteMapping ("/{id}")
	public @ResponseBody boolean deletarMenu(@PathVariable Long id) {
		menuService.deletarMenu(id);
		return true;
	}
	
	@PostMapping
	public @ResponseBody Menu editarMenu(@RequestBody Menu menu) {
		return menuService.editarMenu(menu.getIdMenu(), menu);
	}
	
	@PutMapping
	public @ResponseBody Menu criarMenu(@RequestBody Menu menu) {
		return menuService.criarMenu(menu);
	}
}