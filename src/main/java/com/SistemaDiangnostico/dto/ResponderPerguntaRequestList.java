package com.SistemaDiangnostico.dto;

import java.util.List;

public class ResponderPerguntaRequestList {
	private Long criancaId;
	
	private List<ResponderPerguntaRequest> responderPerguntaRequestList;

	public List<ResponderPerguntaRequest> getResponderPerguntaRequestList() {
		return responderPerguntaRequestList;
	}

	public void setResponderPerguntaRequestList(List<ResponderPerguntaRequest> responderPerguntaRequestList) {
		this.responderPerguntaRequestList = responderPerguntaRequestList;
	}

	public Long getCriancaId() {
		return criancaId;
	}

	public void setCriancaId(Long criancaId) {
		this.criancaId = criancaId;
	}
	   
}
