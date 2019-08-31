package com.SistemaDiangnostico.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDiangnostico.dto.PerguntaDto;
import com.SistemaDiangnostico.dto.RespostaDto;
import com.SistemaDiangnostico.model.Criterio;
import com.SistemaDiangnostico.model.Doenca;
import com.SistemaDiangnostico.model.Pergunta;
import com.SistemaDiangnostico.model.Resposta;
import com.SistemaDiangnostico.repositorio.CriterioRepositorio;
import com.SistemaDiangnostico.repositorio.DoencaRepositorio;
import com.SistemaDiangnostico.repositorio.PerguntaRepositorio;

@Service
public class PerguntaService {

	@Autowired
	private PerguntaRepositorio perguntaRepositorio;
	@Autowired
	private CriterioRepositorio criterioRepositorio;
	@Autowired
	private DoencaRepositorio doencaRepositorio;

	public Pergunta buscarPerguntaPorId(Long idPergunta) {
		return perguntaRepositorio.findById(idPergunta).get();
	}

	public List<PerguntaDto> buscarTodasPergunta() {
		List<Pergunta> findAll = perguntaRepositorio.findAll();
		List<PerguntaDto> perguntaDtos = new ArrayList<PerguntaDto>();

		for (Pergunta pergunta : findAll) {
			PerguntaDto perguntaDto = new PerguntaDto();
			perguntaDto.setIdPergunta(pergunta.getIdPergunta());
			perguntaDto.setTexto(pergunta.getTexo());
			List<RespostaDto> respostasDtoList = new ArrayList<>();
			for (Resposta resp : pergunta.getRespostas()) {
				respostasDtoList.add(new RespostaDto(resp));
			}
			perguntaDto.setRespostas(respostasDtoList);
			perguntaDtos.add(perguntaDto);
		}
		return perguntaDtos;
	}

	public void deletarPergunta(Long idPergunta) {
		perguntaRepositorio.deleteById(idPergunta);
	}

	public Pergunta editarPergunta(Long idPergunta, Pergunta pergunta) {
		pergunta.setIdPergunta(idPergunta);
		return perguntaRepositorio.save(pergunta);
	}

	public Pergunta criarPergunta(Pergunta pergunta) {
		return perguntaRepositorio.save(pergunta);
	}

	public List<PerguntaDto> buscaCriterio(Long idDoenca) {
		List<PerguntaDto> perguntasDto = new ArrayList<PerguntaDto>();
		Optional<Doenca> doenOptional = doencaRepositorio.findById(idDoenca);

		List<Criterio> criterio = doenOptional.get().getCriterio();
		for (Criterio criterios : criterio) {
			List<Pergunta> perguntas = perguntaRepositorio.findByCriterio(criterios);

			for (Pergunta perg : perguntas) {
				perguntasDto.add(new PerguntaDto(perg));
			}
		}

		return perguntasDto;
	}

}
