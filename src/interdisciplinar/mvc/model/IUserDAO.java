/**
 * 
 */
package interdisciplinar.mvc.model;

import java.util.List;

import interdisciplinar.mvc.vo.User;

/**
 * @author Israel Block
 * @version 1.0.1
 * @since 15 de out de 2017
 */
public interface IUserDAO {
	
	public boolean incluir(User usuario);
	
	public List<User> listarUsuarios();
	
	public Boolean atualizar(User usuario);

	public Boolean excluir(int idUsuario);
	
	public User pesquisar(Integer codigoUsuario);

	public List<User> pesquisar(String nomeUsuario);
	
}
