package interdisciplinar.mvc.controller;

import java.util.List;

import interdisciplinar.mvc.model.CardapioModel;
import interdisciplinar.mvc.vo.Cardapio;

public class CardapioController {

	CardapioModel cardapioModel;
	
	public CardapioController() {
		cardapioModel = new CardapioModel();
	}
	public boolean incluir(Cardapio cardapio) {
		return cardapioModel.incluir(cardapio);
	}
	public List<Cardapio> listarCardapio(int idEstabelecimento){
		return cardapioModel.listarCardapio(idEstabelecimento);
	}
	public Boolean atualizar(Cardapio cardapio) {
		return cardapioModel.atualizar(cardapio);
	}
	public Boolean excluir(int idCardapio, int idEstabelecimento) {
		return cardapioModel.excluir(idCardapio, idEstabelecimento);
	}
	public Cardapio buscar(int idCardapio, int idEstabelecimento) {
		return cardapioModel.buscar(idCardapio, idEstabelecimento);
	}
	public Cardapio buscar(String nomeCardapio, int idEstabelecimento) {
		return cardapioModel.buscar(nomeCardapio, idEstabelecimento);
	}

}
