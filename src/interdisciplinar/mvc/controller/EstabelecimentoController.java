package interdisciplinar.mvc.controller;

import java.util.List;

import interdisciplinar.mvc.model.EstabelecimentoModel;
import interdisciplinar.mvc.vo.Estabelecimento;

public class EstabelecimentoController {
	
	private EstabelecimentoModel estabelecimentoModel;

	/**
	 * 
	 */
	public EstabelecimentoController() {
		estabelecimentoModel = new EstabelecimentoModel();
	}

	public boolean incluir(Estabelecimento estabelecimento) {
		return estabelecimentoModel.incluir(estabelecimento);
	}

	public List<Estabelecimento> listarEstabelecimento() {
		return estabelecimentoModel.listarEstabelecimento();
	}

	public Boolean atualizar(Estabelecimento estabelecimento) {
		return estabelecimentoModel.atualizar(estabelecimento);
	}

	public Boolean excluir(int idEstabelecimento) {
		return estabelecimentoModel.excluir(idEstabelecimento);
	}

	public Estabelecimento buscar(int idEstabelecimento) {
		return estabelecimentoModel.buscar(idEstabelecimento);
	}

	public List<Estabelecimento> pesquisar(String nomeEstabelecimento) {
		return estabelecimentoModel.pesquisar(nomeEstabelecimento);
	}

	public String nomeTipo(int tipo) {
		return estabelecimentoModel.nomeTipo(tipo);
	}
}
