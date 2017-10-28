/**
 * 
 */
package interdisciplinar.mvc.model;

import java.util.List;

import interdisciplinar.mvc.vo.Usuario;

/**
 * @author Israel Block
 * @version 1.0.1
 * @since 15 de out de 2017
 */
public interface IUsuarioDAO {
	
	public boolean incluir(Usuario usuario);
	
	public List<Usuario> listarUsuarios();
	
	public Boolean atualizar(Usuario usuario);

	public Boolean excluir(int idUsuario);
	
	public Usuario pesquisar(Integer codigoUsuario);

	public List<Usuario> pesquisar(String nomeUsuario);
	
}
