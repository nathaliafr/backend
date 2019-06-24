package com.SistemaDiangnostico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SistemaDiangnostico.model.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{

}
