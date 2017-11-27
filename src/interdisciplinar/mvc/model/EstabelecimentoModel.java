package interdisciplinar.mvc.model;

import java.util.List;

import interdisciplinar.mvc.vo.Estabelecimento;

public class EstabelecimentoModel {
	
	private EstabelecimentoDAO estabelecimentoDAO;

	public EstabelecimentoModel() {
		estabelecimentoDAO = new EstabelecimentoDAO();
	}
	
	public boolean incluir(Estabelecimento estabelecimento) {
		return estabelecimentoDAO.incluir(estabelecimento);
	}

	public List<Estabelecimento> listarEstabelecimento() {
		return estabelecimentoDAO.listarEstabelecimento();
	}

	public Boolean atualizar(Estabelecimento estabelecimento) {
		return estabelecimentoDAO.atualizar(estabelecimento);
	}

	public Boolean excluir(int idEstabelecimento) {
		return estabelecimentoDAO.excluir(idEstabelecimento);
	}

	public Estabelecimento buscar(int idEstabelecimento) {
		return estabelecimentoDAO.buscar(idEstabelecimento);
	}

	public List<Estabelecimento> pesquisar(String nomeEstabelecimento) {
		return estabelecimentoDAO.pesquisar(nomeEstabelecimento);
	}

	public String nomeTipo(int tipo) {
		return estabelecimentoDAO.nomeTipo(tipo);
	}

}
