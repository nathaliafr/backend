package com.SistemaDiangnostico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SistemaDiangnostico.model.Telefone;

public interface TelefoneRepositorio extends JpaRepository<Telefone, Long> {

}
