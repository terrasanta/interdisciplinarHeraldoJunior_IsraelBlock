/**
 * 
 */
package interdisciplinar.mvc.controller;

import java.util.List;

import interdisciplinar.mvc.model.UserModel;
import interdisciplinar.mvc.vo.User;

/**
 * @author Israel Block
 * @version 1.0.1
 * @since 15 de out de 2017
 */
public class UserController {

	/**
	 * 
	 */
	private UserModel usuarioModel;
	
	/**
	 * 
	 */
	public UserController() {
		usuarioModel = new UserModel();
	}
	public boolean incluir(User usuario) {
		return usuarioModel.incluir(usuario);
	}
	public boolean atualizar(User usuario) {
		return usuarioModel.atualizar(usuario);
	}
	public boolean excluir(int idUsuario) {
		return usuarioModel.excluir(idUsuario);
	}
	public List<User> listarUsuarios(){
		return usuarioModel.listarUsuarios();
	}
	public User pesquisar(Integer idUsuario) {
		return usuarioModel.pesquisar(idUsuario);
	}
	public List<User> pesquisar(String nomeUsuario){
		return usuarioModel.pesquisar(nomeUsuario);
	}

	

}
