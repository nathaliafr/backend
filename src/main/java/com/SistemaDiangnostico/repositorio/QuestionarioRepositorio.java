package com.SistemaDiangnostico.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SistemaDiangnostico.model.Crianca;
import com.SistemaDiangnostico.model.Questionario;

public interface QuestionarioRepositorio extends JpaRepository<Questionario, Long>{

	
	List<Questionario> findByCriança(Crianca crianca);
}
