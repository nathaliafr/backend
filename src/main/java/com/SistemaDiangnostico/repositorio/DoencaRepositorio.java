package com.SistemaDiangnostico.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SistemaDiangnostico.model.Doenca;

public interface DoencaRepositorio extends JpaRepository<Doenca, Long>{
	List<Doenca> findByNomeNot(String nome);
}
