/**
 * 
 */
package interdisciplinar.mvc.model;

import java.util.List;

import interdisciplinar.mvc.vo.Estabelecimento;

/**
 * @author Israel Block
 * @version 1.0.1
 * @since 28 de out de 2017
 */
public interface IEstabelecimentoDAO {
	
	public boolean incluir(Estabelecimento estabelecimento);
	
	public List<Estabelecimento> listarEstabelecimento();
	
	public Boolean atualizar(Estabelecimento estabelecimento);

	public Boolean excluir(int idEstabelecimento);
	
	public Estabelecimento buscar(int idEstabelecimento);

	public List<Estabelecimento> pesquisar(String nomeEstabelecimento);
	
	public List<Estabelecimento> pesquisar(int tipoestabelecimento);
	
	public String nomeTipo(int tipo);
	
}
