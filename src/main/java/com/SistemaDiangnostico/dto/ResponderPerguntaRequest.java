package com.SistemaDiangnostico.dto;

 


public class ResponderPerguntaRequest {

	private Long idQuestionario;
 	private Long idDoença;
	private Long criancaId;
	private Long idPergunta;
	private Long idResposta;
	
	public Long getIdQuestionario() {
		return idQuestionario;
	}
	public void setIdQuestionario(Long idQuestionario) {
		this.idQuestionario = idQuestionario;
	}
	 
	 
	public Long getCriancaId() {
		return criancaId;
	}
	public void setCriancaId(Long criancaId) {
		this.criancaId = criancaId;
	}
	public Long getIdDoença() {
		return idDoença;
	}
	public void setIdDoença(Long idDoença) {
		this.idDoença = idDoença;
	}
	public Long getIdPergunta() {
		return idPergunta;
	}
	public void setIdPergunta(Long idPergunta) {
		this.idPergunta = idPergunta;
	}
	public Long getIdResposta() {
		return idResposta;
	}
	public void setIdResposta(Long idResposta) {
		this.idResposta = idResposta;
	}
	 
	
}
