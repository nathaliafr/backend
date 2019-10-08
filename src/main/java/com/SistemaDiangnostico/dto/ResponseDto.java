package com.SistemaDiangnostico.dto;

public class ResponseDto<T> {
	private String mensagem;
	private T response;
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	
	
	
}
