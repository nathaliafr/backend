package com.SistemaDiangnostico.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SistemaDiangnostico.model.Crianca;

public interface CriancaRepositorio extends JpaRepository<Crianca, Long>{
	List<Crianca> findByIdUsuario(Long idUsuario);
}
