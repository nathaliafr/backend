package com.SistemaDiangnostico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SistemaDiangnostico.model.Doenca;

public interface DoencaRepositorio extends JpaRepository<Doenca, Long>{

}
