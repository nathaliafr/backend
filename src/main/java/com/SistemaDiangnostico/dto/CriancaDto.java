package com.SistemaDiangnostico.dto;

import java.time.LocalDate;

import com.SistemaDiangnostico.model.Crianca;

public class CriancaDto {

	private Long idCrianca;
	private String nome;
	private String documento;
	private String nacionalidade;
	private LocalDate dataNascimento;
	private Long idUsuario;
  

	public CriancaDto(Crianca criança) {
		this.idCrianca=criança.getIdCrianca();
		this.nome=criança.getNome();
		this.documento= criança.getDocumento();
		this.nacionalidade=criança.getNacionalidade();
		this.dataNascimento=criança.getDataNascimento();
		this.idUsuario = criança.getIdUsuario();
	}

	public Long getIdCrianca() {
		return idCrianca;
	}

	public void setIdCrianca(Long idCrianca) {
		this.idCrianca = idCrianca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
}
