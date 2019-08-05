package com.SistemaDiangnostico.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SistemaDiangnostico.model.Diagnostico;

public interface DiagnosticoRepositorio extends JpaRepository<Diagnostico, Long>{
	List<Diagnostico> findByIdQuestionario(Long idQuestionario);

}
