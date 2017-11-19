/**
 * 
 */
package interdisciplinar.mvc.model;

import java.util.List;

import interdisciplinar.mvc.vo.Cardapio;

/**
 * @author Israel Block
 * @version 1.0.1
 * @since 12 de nov de 2017
 */
public class CardapioModel {

	CardapioDAO cardapioDAO;
	/**
	 * 
	 */
	public CardapioModel() {
		cardapioDAO = new CardapioDAO();
	}
	
	public boolean incluir(Cardapio cardapio) {
		return cardapioDAO.incluir(cardapio);
	}
	public List<Cardapio> listarCardapio(int idEstabelecimento){
		return cardapioDAO.listarCardapio(idEstabelecimento);
	}
	public Boolean atualizar(Cardapio cardapio) {
		return cardapioDAO.atualizar(cardapio);
	}
	public Boolean excluir(int idCardapio, int idEstabelecimento) {
		return cardapioDAO.excluir(idCardapio, idEstabelecimento);
	}
	public Cardapio buscar(int idCardapio, int idEstabelecimento) {
		return cardapioDAO.buscar(idCardapio, idEstabelecimento);
	}
	public Cardapio buscar(String nomeCardapio, int idEstabelecimento) {
		return cardapioDAO.buscar(nomeCardapio, idEstabelecimento);
	}

}
