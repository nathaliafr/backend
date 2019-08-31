package com.SistemaDiangnostico.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SistemaDiangnostico.model.Criterio;
import com.SistemaDiangnostico.model.Pergunta;

public interface PerguntaRepositorio extends JpaRepository<Pergunta, Long>{
  
 
	List<Pergunta> findByCriterio(Criterio criterio);
}
 