package com.SistemaDiangnostico.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.SistemaDiangnostico.model.Crianca;
import com.SistemaDiangnostico.model.Diagnostico;
import com.SistemaDiangnostico.model.Questionario;

public class QuestionarioDto {

	private Long idQuestionario;

	private CriancaDto criança;

	private LocalDateTime data;
	private String doenca;

	private List<DiagnosticoDto> diagnostico;

	public QuestionarioDto(Questionario questionario) {
		this.idQuestionario = questionario.getIdQuestionario();
		this.data = questionario.getData();
		this.doenca = questionario.getDoenca().getNome();
		this.setCriança(new CriancaDto(questionario.getCriança()));
		this.setDiagnostico(parseDtoDiaguinostivo(questionario.getDiagnostico()));
	}

	private List<DiagnosticoDto> parseDtoDiaguinostivo(List<Diagnostico> diagnostico) {
		List<DiagnosticoDto> diagDto = new ArrayList<DiagnosticoDto>();
		for (Diagnostico diag : diagnostico) {
			diagDto.add(new DiagnosticoDto(diag));
		}

		return diagDto;
	}

	public Long getIdQuestionario() {
		return idQuestionario;
	}

	public void setIdQuestionario(Long idQuestionario) {
		this.idQuestionario = idQuestionario;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public CriancaDto getCriança() {
		return criança;
	}

	public void setCriança(CriancaDto criança) {
		this.criança = criança;
	}

	public List<DiagnosticoDto> getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(List<DiagnosticoDto> diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getDoenca() {
		return doenca;
	}

	public void setDoenca(String doenca) {
		this.doenca = doenca;
	}

}
