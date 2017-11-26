package interdisciplinar.mvc.controller;

import java.util.List;

import interdisciplinar.mvc.model.CarrinhoModel;
import interdisciplinar.mvc.vo.Carrinho;
import interdisciplinar.mvc.vo.Itens;

public class CarrinhoController {

	CarrinhoModel carrinhoModel;
	
	public CarrinhoController() {
		carrinhoModel = new CarrinhoModel();
	}
	public Boolean incluir(Itens item) {
		return carrinhoModel.incluir(item);
	}
	
	public Boolean atualizar(Itens item) {
		return carrinhoModel.atualizar(item);
	}
	
	public Boolean excluir(int idCarrinho) {
		return carrinhoModel.excluir(idCarrinho);
	}
	
	public List<Itens> listarCarrinho(int idUsuario){
		return carrinhoModel.listarCarrinho(idUsuario);
	}
	
	public Boolean finalizar(Carrinho carrinho) {
		return carrinhoModel.finalizar(carrinho);
	}
	public List<Itens> getListaItens() {
		return carrinhoModel.getListaItens();
	}
	public Double retornaValorItem(int idItem, int idEstabelecimento) {
		return carrinhoModel.retornaValorItem(idItem, idEstabelecimento);
	}
}
