/**
 * 
 */
package interdisciplinar.mvc.model;

import java.util.List;

import interdisciplinar.mvc.vo.Carrinho;
import interdisciplinar.mvc.vo.Itens;

/**
 * @author Israel Block
 * @version 1.0.1
 * @since 25 de nov de 2017
 */
public interface ICarrinhoDAO {
	public Boolean incluir(Itens item);
	
	public Boolean atualizar(Itens item);
	
	public Boolean excluir(int idCarrinho);
	
	public List<Itens> listarCarrinho(int idUsuario);
	
	public Boolean finalizar(Carrinho carrinho);
	
}
