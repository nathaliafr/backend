package com.SistemaDiangnostico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.dto.ResponderPerguntaRequest;
import com.SistemaDiangnostico.model.Crianca;
import com.SistemaDiangnostico.model.Criterio;
import com.SistemaDiangnostico.model.Diagnostico;
import com.SistemaDiangnostico.model.Doenca;
import com.SistemaDiangnostico.model.Pergunta;
import com.SistemaDiangnostico.model.Questionario;
import com.SistemaDiangnostico.model.Resposta;
import com.SistemaDiangnostico.repositorio.DiagnosticoRepositorio;
import com.SistemaDiangnostico.repositorio.QuestionarioRepositorio;

@Service
public class QuestionarioService {
	@Autowired
	private QuestionarioRepositorio questionarioRepositorio;
	@Autowired
	private CriancaService criancaService;
	@Autowired
	private RespostaService respostaService;
	@Autowired
	private PerguntaService perguntaService;
	@Autowired
	private DiagnosticoRepositorio diagnosticoRepositorio;

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

	public Questionario responderPerguntaRequest(Long idCrianca,
			List<ResponderPerguntaRequest> responderPerguntaRequestList) {
		Questionario questionario = new Questionario();
 		Crianca crianca = criancaService.buscarCriancaPorId(idCrianca);
		questionario.setCriança(crianca);
		questionario = questionarioRepositorio.save(questionario);

		for (ResponderPerguntaRequest responderPerguntaRequest : responderPerguntaRequestList) {
			Diagnostico diagnostico = new Diagnostico();
			diagnostico.setIdQuestionario(questionario.getIdQuestionario());
			Resposta resposta = respostaService.buscarRespostaPorId(responderPerguntaRequest.getIdResposta());
			diagnostico.setResposta(resposta);
			Pergunta pergunta = perguntaService.buscarPerguntaPorId(responderPerguntaRequest.getIdPergunta());
			diagnostico.setPergunta(pergunta);

			diagnosticoRepositorio.save(diagnostico);
		}

		analisarDoenca(questionario.getIdQuestionario());

		return null;
	}

	private void analisarDoenca(Long idQuestionario) {
		List<Diagnostico> diagnosticos = diagnosticoRepositorio.findByIdQuestionario(idQuestionario);
		
		for (Diagnostico diagnostico : diagnosticos) {
			Resposta resposta = diagnostico.getResposta();
			Criterio criterio = resposta.getCriterio();
			List<Doenca> doencas = criterio.getDoenca();
			if(doencas.size()>1){
				Pergunta pergunta = diagnostico.getPergunta();
				Doenca doenca = pergunta.getDoenca();
			
			}else{
				Doenca doenca = doencas.stream().findFirst().get();
			
			
			}
		
		}

	}

}
