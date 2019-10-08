package com.SistemaDiangnostico.dto;

import com.SistemaDiangnostico.model.Diagnostico;

public class DiagnosticoDto {

	private Long idDiagnostico;
	private Long idQuestionario;
	private PerguntaDto pergunta;
	private RespostaDto resposta;
	
	public DiagnosticoDto(Diagnostico diag) {
		this.idDiagnostico = diag.getIdDiagnostico();
		this.idQuestionario  = diag.getIdQuestionario();
	 
	}
	public Long getIdDiagnostico() {
		return idDiagnostico;
	}
	public void setIdDiagnostico(Long idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}
	public Long getIdQuestionario() {
		return idQuestionario;
	}
	public void setIdQuestionario(Long idQuestionario) {
		this.idQuestionario = idQuestionario;
	}
	public PerguntaDto getPergunta() {
		return pergunta;
	}
	public void setPergunta(PerguntaDto pergunta) {
		this.pergunta = pergunta;
	}
	public RespostaDto getResposta() {
		return resposta;
	}
	public void setResposta(RespostaDto resposta) {
		this.resposta = resposta;
	}
 
 

	 
 
 
 
	 

}
