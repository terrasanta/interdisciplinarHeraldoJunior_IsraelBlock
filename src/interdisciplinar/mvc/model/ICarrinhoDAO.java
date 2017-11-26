/**
 * 
 */
package interdisciplinar.mvc.model;

import java.util.List;

import interdisciplinar.mvc.vo.Carrinho;

/**
 * @author Israel Block
 * @version 1.0.1
 * @since 25 de nov de 2017
 */
public interface ICarrinhoDAO {
	public boolean incluir(Carrinho carrinho);
	
	public Boolean atualizar(Carrinho cardapio);
	
	public Boolean excluir(int idCarrinho);
	
	public List<Carrinho> listarCarrinho(int idUsuario, int idEstabelecimento);
	
}
