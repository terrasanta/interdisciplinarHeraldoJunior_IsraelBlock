package interdisciplinar.mvc.model;

import java.util.List;

import interdisciplinar.mvc.vo.Itens;

public class CarrinhoModel {

	CarrinhoDAO carrinhoDAO;
	public CarrinhoModel() {
		carrinhoDAO = new CarrinhoDAO();
	}

	public Boolean incluir(Itens item) {
		return carrinhoDAO.incluir(item);
	}
	
	public Boolean atualizar(Itens item) {
		return carrinhoDAO.atualizar(item);
	}
	
	public Boolean excluir(Itens item) {
		return carrinhoDAO.excluir(item);
	}
	
	public List<Itens> listarCarrinho(int idUsuario){
		return carrinhoDAO.listarCarrinho(idUsuario);
	}
	
	public Boolean finalizar() {
		return carrinhoDAO.finalizar();
	}
	public List<Itens> getListaItens() {
		return carrinhoDAO.getListaItens();
	}
	public Double retornaValorItem(int idItem, int idEstabelecimento) {
		return carrinhoDAO.retornaValorItem(idItem, idEstabelecimento);
	}
}
