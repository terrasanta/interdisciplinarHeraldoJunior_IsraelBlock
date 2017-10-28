/**
 * 
 */
package interdisciplinar.mvc.controller;

import java.util.List;

import interdisciplinar.mvc.model.UsuarioModel;
import interdisciplinar.mvc.vo.Usuario;

/**
 * @author Israel Block
 * @version 1.0.1
 * @since 15 de out de 2017
 */
public class UsuarioController {

	/**
	 * 
	 */
	private UsuarioModel usuarioModel;
	
	/**
	 * 
	 */
	public UsuarioController() {
		usuarioModel = new UsuarioModel();
	}
	public boolean incluir(Usuario usuario) {
		return usuarioModel.incluir(usuario);
	}
	public boolean atualizar(Usuario usuario) {
		return usuarioModel.atualizar(usuario);
	}
	public boolean excluir(int idUsuario) {
		return usuarioModel.excluir(idUsuario);
	}
	public List<Usuario> listarUsuarios(){
		return usuarioModel.listarUsuarios();
	}
	public Usuario pesquisar(Integer idUsuario) {
		return usuarioModel.pesquisar(idUsuario);
	}
	public List<Usuario> pesquisar(String nomeUsuario){
		return usuarioModel.pesquisar(nomeUsuario);
	}

	

}
