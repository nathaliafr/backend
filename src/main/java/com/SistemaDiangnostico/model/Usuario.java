package com.SistemaDiangnostico.model;

 import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	private Long id;
	
	@Column
	private String documento;
	
	@Column
	private String nome;
	
	@Column
	private Date dataNascimento;
	
	@Column
	private String email;
	
	@Column
	private String nacionalidade;
	
	@Column
	private String endereco;
	
	@Column
	private String bairro;
	
	@Column
	private int cep;
	
	@Column
	private String uf;
	
	@Column
	private String cidade;
	
	@Column
	private String complememto;
	
	@Column
	private int numero;
	
	@ManyToMany
	@JoinTable(name="contato", joinColumns = {
			@JoinColumn(name="usuario_id")}, inverseJoinColumns = {
					@JoinColumn(name="telefone_id")})
	private List contato;
	
	@ManyToMany
	@JoinTable(name="crianca_has_usuario", joinColumns = {
			@JoinColumn(name="usuario_id")}, inverseJoinColumns = {
					@JoinColumn(name="crianca_id")})
	private List crianca;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getComplememto() {
		return complememto;
	}
	public void setComplememto(String complememto) {
		this.complememto = complememto;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public List getContato() {
		return contato;
	}
	public void setContato(List contato) {
		this.contato = contato;
	}
	public List getCrianca() {
		return crianca;
	}
	public void setCrianca(List crianca) {
		this.crianca = crianca;
	}

}
