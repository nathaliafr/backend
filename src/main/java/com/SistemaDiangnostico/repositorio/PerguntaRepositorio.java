package com.SistemaDiangnostico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SistemaDiangnostico.model.Pergunta;

public interface PerguntaRepositorio extends JpaRepository<Pergunta, Long>{

}
