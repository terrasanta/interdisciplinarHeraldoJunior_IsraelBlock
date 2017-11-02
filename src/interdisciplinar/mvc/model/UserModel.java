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
public class UserModel {

	private UserDAO usuarioDAO;
	/**
	 * 
	 */
	public UserModel() {
		try {
			usuarioDAO = new UserDAO();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public boolean incluir(User usuario) {
		return usuarioDAO.incluir(usuario);
	}
	public boolean atualizar(User usuario) {
		return usuarioDAO.atualizar(usuario);
	}
	public boolean excluir(int idUsuario) {
		return usuarioDAO.excluir(idUsuario);
	}
	public List<User> listarUsuarios(){
		return usuarioDAO.listarUsuarios();
	}
	public User pesquisar(Integer idUsuario) {
		return usuarioDAO.pesquisar(idUsuario);
	}
	public List<User> pesquisar(String nomeUsuario){
		return usuarioDAO.pesquisar(nomeUsuario);
	}

}
