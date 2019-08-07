package com.SistemaDiangnostico.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.dto.DoencaDto;
import com.SistemaDiangnostico.dto.GraficoResultadoDto;
import com.SistemaDiangnostico.dto.ResponderPerguntaRequest;
import com.SistemaDiangnostico.dto.ValorDePorcentagemDoenca;
import com.SistemaDiangnostico.model.Crianca;
import com.SistemaDiangnostico.model.Criterio;
import com.SistemaDiangnostico.model.Diagnostico;
import com.SistemaDiangnostico.model.Doenca;
import com.SistemaDiangnostico.model.Pergunta;
import com.SistemaDiangnostico.model.Questionario;
import com.SistemaDiangnostico.model.Resposta;
import com.SistemaDiangnostico.repositorio.DiagnosticoRepositorio;
import com.SistemaDiangnostico.repositorio.DoencaRepositorio;
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
	private DoencaRepositorio doencaRepositorio;
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

	public GraficoResultadoDto  responderPerguntaRequest(Long idCrianca,
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

		List<ValorDePorcentagemDoenca> analisarDoenca = analisarDoenca(questionario.getIdQuestionario(), responderPerguntaRequestList.size());
		GraficoResultadoDto graficoResultadoDto =  new GraficoResultadoDto();
		graficoResultadoDto.setGraficoDados(analisarDoenca);
		return graficoResultadoDto;
	}

	private List<ValorDePorcentagemDoenca> analisarDoenca(Long idQuestionario, int totalDePerguntasRespondidas) {
		List<Diagnostico> diagnosticos = diagnosticoRepositorio.findByIdQuestionario(idQuestionario);

		Map<Long, Long> contador = new HashMap<>();
		for (Diagnostico diagnostico : diagnosticos) {
			Resposta resposta = diagnostico.getResposta();
			Criterio criterio = resposta.getCriterio();
			List<Doenca> doencas = criterio.getDoenca();
			if (doencas.size() > 1) {
				Pergunta pergunta = diagnostico.getPergunta();
				Doenca doenca = pergunta.getDoenca();
				cadastrarPergunta(doenca, contador);
			} else {
				Doenca doenca = doencas.stream().findFirst().get();
				cadastrarPergunta(doenca, contador);

			}

		}

		List<ValorDePorcentagemDoenca> valorPorcentagens = calcularPorcentagens(contador, totalDePerguntasRespondidas);
		return valorPorcentagens;
	}

	private List<ValorDePorcentagemDoenca> calcularPorcentagens(Map<Long, Long> contador,
			int totalDePerguntasRespondidas) {
		ArrayList<Long> IdsDoencas = new ArrayList<>(contador.keySet());
		List<ValorDePorcentagemDoenca> valorDePorcentagemDoenças = new ArrayList<>();

		for (Long idDoenca : IdsDoencas) {
			Optional<Doenca> doenca = doencaRepositorio.findById(idDoenca);
			ValorDePorcentagemDoenca valorDePorcentagemDoença = new ValorDePorcentagemDoenca();
			valorDePorcentagemDoença.setDoenca(new DoencaDto( doenca.get()));
			Double porcentagem = (double) ((contador.get(idDoenca) * 100) / totalDePerguntasRespondidas);
			valorDePorcentagemDoença.setPorcentagem(porcentagem);
			valorDePorcentagemDoenças.add(valorDePorcentagemDoença);

		}
		return valorDePorcentagemDoenças;
	}

	private void cadastrarPergunta(Doenca doenca, Map<Long, Long> contador) {

		Long valorAtual = contador.get(doenca.getIdDoenca());
		if (valorAtual == null) {
			valorAtual = 0L;
		}
		contador.put(doenca.getIdDoenca(), ++valorAtual);

	}

}
