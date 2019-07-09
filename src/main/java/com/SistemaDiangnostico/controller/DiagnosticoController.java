package com.SistemaDiangnostico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SistemaDiangnostico.model.Diagnostico;
import com.SistemaDiangnostico.service.DiagnosticoService;


	@Controller
	@RequestMapping ("/diagnostico")
public class DiagnosticoController {
		
		@Autowired
		DiagnosticoService diagnosticoService;
		
		@GetMapping ("/{id}")
		public @ResponseBody Diagnostico getDiagnosticoPorId (@PathVariable Long id) {
			return diagnosticoService.buscarDiagnosticoPorId(id);
		}
		
		@GetMapping("/")
		public @ResponseBody List<Diagnostico> getTodosDiagnostico () {
			
			List<Diagnostico> buscarTodosDiagnostico = diagnosticoService.buscarTodosDiagnostico();
			 
			return buscarTodosDiagnostico;
		}
		
		@DeleteMapping ("/{id}")
		public @ResponseBody boolean deleteDiagnostico(@PathVariable Long id) {
			diagnosticoService.deletarDiagnostico(id);
			return true;
		}
		
		@PostMapping
		public @ResponseBody Diagnostico editarDiagnostico(@RequestBody Diagnostico diagnostico) {
			return diagnosticoService.editarDiagnostico(diagnostico.getIdDiagnostico(), diagnostico);
		}
		
		@PutMapping
		public @ResponseBody Diagnostico criarDiagnostico(@RequestBody Diagnostico diagnostico) {
			return diagnosticoService.criarDiagnostico(diagnostico);
		}
	}