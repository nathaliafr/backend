package com.SistemaDiangnostico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.dto.ResponderPerguntaRequest;
import com.SistemaDiangnostico.model.Crianca;
import com.SistemaDiangnostico.model.Doenca;
import com.SistemaDiangnostico.model.Pergunta;
import com.SistemaDiangnostico.model.Questionario;
import com.SistemaDiangnostico.model.Resposta;
import com.SistemaDiangnostico.repositorio.QuestionarioRepositorio;

@Service
public class QuestionarioService {
	@Autowired
	private QuestionarioRepositorio questionarioRepositorio;
	@Autowired
	private DoencaService doencaService;
	@Autowired
	private CriancaService criancaService;
	@Autowired
	private RespostaService respostaService;
	@Autowired
	private PerguntaService perguntaService;

	public Questionario buscarQuestionarioPorId(Long idQuestionario) {
		return questionarioRepositorio.findById(idQuestionario).get();
	}

	public List<Questionario> buscarTodosQuestionario() {
		return questionarioRepositorio.findAll();
	}

	public void deletarQuestionario(Long idQuestionario) {
		questionarioRepositorio.deleteById(idQuestionario);
	}

	public Questionario editarQuestionario(Long idQuestionario, Questionario questionario) {
		questionario.setIdQuestionario(idQuestionario);
		return questionarioRepositorio.save(questionario);
	}

	public Questionario criarQuestionario(Questionario questionario) {
		return questionarioRepositorio.save(questionario);
	}

	public Questionario responderPerguntaRequest(List<ResponderPerguntaRequest> responderPerguntaRequestList) {
		for (ResponderPerguntaRequest responderPerguntaRequest : responderPerguntaRequestList) {

			Questionario questionario = new Questionario();
			Doenca doenca = doencaService.getDoencaId(responderPerguntaRequest.getIdDoença());
			questionario.setDoenca(doenca);
			Crianca crianca = criancaService.buscarCriancaPorId(responderPerguntaRequest.getCriancaId());
			questionario.setCriança(crianca);
			Resposta resposta = respostaService.buscarRespostaPorId(responderPerguntaRequest.getIdResposta());
			questionario.setResposta(resposta);
			Pergunta pergunta = perguntaService.buscarPerguntaPorId(responderPerguntaRequest.getIdPergunta());
			questionario.setPergunta(pergunta);

			questionarioRepositorio.save(questionario);
		}

		analisarDoenca();

		return null;
	}

	private void analisarDoenca() {
		 

	}

}
