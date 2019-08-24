package com.SistemaDiangnostico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SistemaDiangnostico.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	Usuario findByEmail(String email);
}
