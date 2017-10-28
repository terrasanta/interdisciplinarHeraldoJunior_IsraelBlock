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
public class UsuarioModel {

	private UsuarioDAO usuarioDAO;
	/**
	 * 
	 */
	public UsuarioModel() {
		try {
			usuarioDAO = new UsuarioDAO();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public boolean incluir(Usuario usuario) {
		return usuarioDAO.incluir(usuario);
	}
	public boolean atualizar(Usuario usuario) {
		return usuarioDAO.atualizar(usuario);
	}
	public boolean excluir(int idUsuario) {
		return usuarioDAO.excluir(idUsuario);
	}
	public List<Usuario> listarUsuarios(){
		return usuarioDAO.listarUsuarios();
	}
	public Usuario pesquisar(Integer idUsuario) {
		return usuarioDAO.pesquisar(idUsuario);
	}
	public List<Usuario> pesquisar(String nomeUsuario){
		return usuarioDAO.pesquisar(nomeUsuario);
	}

}
