package interdisciplinar.mvc.controller;

import java.util.List;

import interdisciplinar.mvc.model.CarrinhoModel;
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
	
	public Boolean excluir(Itens item) {
		return carrinhoModel.excluir(item);
	}
	
	public List<Itens> listarCarrinho(int idUsuario){
		return carrinhoModel.listarCarrinho(idUsuario);
	}
	
	public Boolean finalizar() {
		return carrinhoModel.finalizar();
	}
	public List<Itens> getListaItens() {
		return carrinhoModel.getListaItens();
	}
	public Double retornaValorItem(int idItem, int idEstabelecimento) {
		return carrinhoModel.retornaValorItem(idItem, idEstabelecimento);
	}
}
