package com.SistemaDiangnostico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SistemaDiangnostico.model.Questionario;

public interface QuestionarioRepositorio extends JpaRepository<Questionario, Long>{

}
