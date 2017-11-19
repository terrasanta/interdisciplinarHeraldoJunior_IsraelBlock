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
public interface ICardapioDAO {
	
	public boolean incluir(Cardapio cardapio);
	
	public List<Cardapio> listarCardapio(int idEstabelecimento);
	
	public Boolean atualizar(Cardapio cardapio);
	
	public Boolean excluir(int idCardapio, int idEstabelecimento);
	
	public Cardapio buscar(int idCardapio, int idEstabelecimento);
	
	public Cardapio buscar(String nomeCardapio, int idEstabelecimento);

}
