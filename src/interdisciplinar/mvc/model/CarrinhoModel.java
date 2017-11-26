package interdisciplinar.mvc.model;

import java.util.List;

import interdisciplinar.mvc.vo.Carrinho;
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
	
	public Boolean excluir(int idCarrinho) {
		return carrinhoDAO.excluir(idCarrinho);
	}
	
	public List<Itens> listarCarrinho(int idUsuario){
		return carrinhoDAO.listarCarrinho(idUsuario);
	}
	
	public Boolean finalizar(Carrinho carrinho) {
		return carrinhoDAO.finalizar(carrinho);
	}
	public List<Itens> getListaItens() {
		return carrinhoDAO.getListaItens();
	}
	public Double retornaValorItem(int idItem, int idEstabelecimento) {
		return carrinhoDAO.retornaValorItem(idItem, idEstabelecimento);
	}
}
