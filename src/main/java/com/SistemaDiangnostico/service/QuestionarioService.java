package com.SistemaDiangnostico.service;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.dto.DoencaDto;
import com.SistemaDiangnostico.dto.GraficoResultadoDto;
import com.SistemaDiangnostico.dto.QuestionarioDto;
import com.SistemaDiangnostico.dto.ResponderPerguntaRequest;
import com.SistemaDiangnostico.dto.RespostaEspecialistaDTO;
import com.SistemaDiangnostico.dto.ValorDePorcentagemDoenca;
import com.SistemaDiangnostico.model.Crianca;
import com.SistemaDiangnostico.model.Criterio;
import com.SistemaDiangnostico.model.Diagnostico;
import com.SistemaDiangnostico.model.Doenca;
import com.SistemaDiangnostico.model.Pergunta;
import com.SistemaDiangnostico.model.Questionario;
import com.SistemaDiangnostico.model.Resposta;
import com.SistemaDiangnostico.model.TaxaDeAcertos;
import com.SistemaDiangnostico.repositorio.DiagnosticoRepositorio;
import com.SistemaDiangnostico.repositorio.DoencaRepositorio;
import com.SistemaDiangnostico.repositorio.QuestionarioRepositorio;
import com.SistemaDiangnostico.repositorio.TaxaDeAcertosRepositorio;

@Service
public class QuestionarioService {
	private static final int CRITERIO_DE_INDECISAO = 20;
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
	@Autowired
	private TaxaDeAcertosRepositorio taxaDeAcertosRepositorio;

	public Questionario buscarQuestionarioPorId(Long idQuestionario) {
		return questionarioRepositorio.findById(idQuestionario).get();
	}

	public List<QuestionarioDto> buscarQuestionarioPorIdQuestionarioEIdCrianca(Long idCrianca) {
		Crianca crianca = criancaService.buscarCriancaPorId(idCrianca);

		List<Questionario> questionarios = questionarioRepositorio.findByCriança(crianca);
		List<QuestionarioDto> questionariosDto = new ArrayList<>();

		for (Questionario questionarioDto : questionarios) {

			questionariosDto.add(new QuestionarioDto(questionarioDto));
		}

		return questionariosDto;
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

	public Map<String, String> respostaDoEspecialista(RespostaEspecialistaDTO req) {
		Map<String, String> map = new HashMap<>();
		map.put("resultado", "ok");
		if (req.getIdDoenca() != null) {
			Doenca doenca = doencaRepositorio.findById(req.getIdDoenca()).get();
			Questionario questionario = questionarioRepositorio.findById(req.getIdQuestionario()).get();

			GraficoResultadoDto grafico = getGrafico(req.getIdQuestionario());
			ValorDePorcentagemDoenca maiorValor = procurarMaiorValor(grafico);
			alterarTaxaDeErro(doenca, questionario, maiorValor);

			questionario.setDoenca(doenca);
			questionarioRepositorio.save(questionario);

			return map;
		} else {
			return map;

		}

	}

	private void alterarTaxaDeErro(Doenca doenca, Questionario questionario, ValorDePorcentagemDoenca maiorValor) {

		TaxaDeAcertos taxaDeAcertos = taxaDeAcertosRepositorio.findById(1L).get();
		if (questionario.getDoenca() == null && doenca.getNome().equals(maiorValor.getDoenca().getNome())) {
			taxaDeAcertos.setAcertos(taxaDeAcertos.getAcertos() + 1);
			
		} else if (questionario.getDoenca() == null && !doenca.getNome().equals(maiorValor.getDoenca().getNome())) {
			taxaDeAcertos.setErros(taxaDeAcertos.getErros() + 1);
			
		} else if (questionario.getDoenca() != null
				&& !questionario.getDoenca().getNome().equals(doenca.getNome())
				&& doenca.getNome().equals(maiorValor.getDoenca().getNome())) {
			
			taxaDeAcertos.setErros(taxaDeAcertos.getErros() - 1);
			taxaDeAcertos.setAcertos(taxaDeAcertos.getAcertos() + 1);
		} else if (questionario.getDoenca() != null
				&& !questionario.getDoenca().getNome().equals(doenca.getNome())
				&& !doenca.getNome().equals(maiorValor.getDoenca().getNome())) {
			
			taxaDeAcertos.setErros(taxaDeAcertos.getErros() + 1);
			taxaDeAcertos.setAcertos(taxaDeAcertos.getAcertos() - 1);
		}

		taxaDeAcertosRepositorio.save(taxaDeAcertos);
	}

	private ValorDePorcentagemDoenca procurarMaiorValor(GraficoResultadoDto grafico) {
		List<ValorDePorcentagemDoenca> graficoDados = grafico.getGraficoDados();
		ValorDePorcentagemDoenca doencaComMaiorRelevancia = new ValorDePorcentagemDoenca();
		double maiorValor = 0;
		for (ValorDePorcentagemDoenca valorDePorcentagemDoenca : graficoDados) {
			if (maiorValor < valorDePorcentagemDoenca.getPorcentagem()) {
				maiorValor = valorDePorcentagemDoenca.getPorcentagem();
				doencaComMaiorRelevancia = valorDePorcentagemDoenca;
			}
		}

		return doencaComMaiorRelevancia;
	}

	public Questionario criarQuestionario(Questionario questionario) {
		return questionarioRepositorio.save(questionario);
	}

	public GraficoResultadoDto responderPerguntaRequest(Long idCrianca,
			List<ResponderPerguntaRequest> responderPerguntaRequestList) {
		Questionario questionario = new Questionario();
		Crianca crianca = criancaService.buscarCriancaPorId(idCrianca);
		questionario.setCriança(crianca);
		questionario.setData(LocalDateTime.now());
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

		List<ValorDePorcentagemDoenca> analisarDoenca = analisarDoenca(questionario.getIdQuestionario(),
				responderPerguntaRequestList.size());
		GraficoResultadoDto graficoResultadoDto = new GraficoResultadoDto();
		graficoResultadoDto.setGraficoDados(analisarDoenca);
		return graficoResultadoDto;
	}

	public GraficoResultadoDto getGrafico(Long idQuestionario) {
		List<Diagnostico> diagnosticos = diagnosticoRepositorio.findByIdQuestionario(idQuestionario);
		List<ValorDePorcentagemDoenca> analisarDoenca = analisarDoenca(idQuestionario, diagnosticos.size());
		GraficoResultadoDto graficoResultadoDto = new GraficoResultadoDto();
		graficoResultadoDto.setGraficoDados(analisarDoenca);
		String taxaDeErro = calcularTaxaDeErro();
		graficoResultadoDto.setTaxaDeConfianca(taxaDeErro);
		return graficoResultadoDto;
	}

	private String calcularTaxaDeErro() {
		TaxaDeAcertos taxa = taxaDeAcertosRepositorio.findById(1L).get();
		return String.format("%.2f ", (double) ((taxa.getErros() * 100) / (taxa.getAcertos() + taxa.getErros()))) + "%";
	}

	private List<ValorDePorcentagemDoenca> analisarDoenca(Long idQuestionario, int totalDePerguntasRespondidas) {
		List<Diagnostico> diagnosticos = diagnosticoRepositorio.findByIdQuestionario(idQuestionario);

		Map<Long, Long> contador = new HashMap<>();
		for (Diagnostico diagnostico : diagnosticos) {
			Resposta resposta = diagnostico.getResposta();

			Criterio criterio = resposta.getCriterio();
			List<Doenca> doencas = criterio.getDoenca();
			if (criterio.getIdCriterio() != CRITERIO_DE_INDECISAO) {
				if (doencas.size() > 1) {
					Pergunta pergunta = diagnostico.getPergunta();
					Doenca doenca = pergunta.getDoenca();
					cadastrarPergunta(doenca, contador);
				} else {
					Doenca doenca = doencas.stream().findFirst().get();
					cadastrarPergunta(doenca, contador);

				}
			} else {
				totalDePerguntasRespondidas--;
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
			valorDePorcentagemDoença.setDoenca(new DoencaDto(doenca.get()));
			Double porcentagem = (double) ((contador.get(idDoenca) * 100) / (double) totalDePerguntasRespondidas);
			String format = new DecimalFormat("0.000").format(porcentagem).replace(",", ".");
			valorDePorcentagemDoença.setPorcentagem(Double.valueOf(format));
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
