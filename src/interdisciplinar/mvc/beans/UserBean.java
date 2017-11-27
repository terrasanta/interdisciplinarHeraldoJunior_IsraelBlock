/**
 * 
 */
package interdisciplinar.mvc.beans;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import interdisciplinar.mvc.controller.UserController;
import interdisciplinar.mvc.vo.User;

@ManagedBean(name = "userBean")
@SessionScoped

/**
 * @author Israel Block
 * @version 1.0.1
 * @since 19 de nov de 2017
 */
public class UserBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 113696497773798798L;
	
	private User user;
	
	private int idUsuario;
	private String nomeUsuario;
	private String emailUsuario;
	private String senha;
	private Date dataCadastro;
	private char sexo;
	
	private UserController userController;
	/**
	 * 
	 */
	public UserBean() {
		userController = new UserController();
		user = new User();
	}
	public String retornaNomeUsuario() {
		user = userController.pesquisar(1);
		String nomeUsuario = user.getNomeUsuario();
		return nomeUsuario;
	}
	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * @return the nomeUsuario
	 */
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	/**
	 * @param nomeUsuario the nomeUsuario to set
	 */
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	/**
	 * @return the emailUsuario
	 */
	public String getEmailUsuario() {
		return emailUsuario;
	}
	/**
	 * @param emailUsuario the emailUsuario to set
	 */
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	/**
	 * @return the dataCadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}
	/**
	 * @param dataCadastro the dataCadastro to set
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	/**
	 * @return the sexo
	 */
	public char getSexo() {
		return sexo;
	}
	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	/**
	 * @return the userController
	 */
	public UserController getUserController() {
		return userController;
	}
	/**
	 * @param userController the userController to set
	 */
	public void setUserController(UserController userController) {
		this.userController = userController;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public User retornaUser(int idUser) {
		return userController.pesquisar(idUser);
	}

}
