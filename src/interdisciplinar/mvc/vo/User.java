package interdisciplinar.mvc.vo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe que representa um usu�rio.
 * Aqui est� definido os m�todos de acesso para os atributos do usu�rio.
 * 
 * @author Israel Block e Heraldo Junior
 * @version 1.0.1
 * @since 16 de out de 2017
 */
public class User {

	/**
	 * armazena o valor do id do usuario, seja da aplica��o ou do banco de dados 
	 */
	private int idUsuario;
	/**
	 * armazena o nome do usuario
	 */
	private String nomeUsuario;
	/**
	 * armazena o email do usuario
	 */
	private String emailUsuario;
	/**
	 * armazena a senha do usuario
	 */
	private String senha;
	/**
	 * armazena a data de cadastro do usuario
	 */
	private Date dataCadastro;
	/**
	 * Armazena um Char representando o sexo do usu�rio. M para Masculino, F para Feminino e O para Outros.
	 */
	private char sexo;
	
	/**
	 * M�todo construtor vazio.
	 * Apenas instancia o usu�rio, possibilitando o acesso aos m�todos Getters and Setters.
	 */
	public User() {
		
	}
	
	/**
	 * M�todo construtor que recebe par�metros para a inicializa��o do objeto.
	 * Fora os par�metros que s�o passados, o m�todo tamb�m guarda a data atual, e chama o m�todo setDataAtual.
	 * @param nomeUsuario - String
	 * @param emailUsuario - String
	 * @param senha - String
	 * @param sexo - Char
	 */
	public User(String nomeUsuario, String emailUsuario, String senha, char sexo) {
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		Date dataAtual = new Date();
		
		setNomeUsuario(nomeUsuario);
		setEmailUsuario(emailUsuario);
		setSenha(senha);
		setDataCadastro(dataAtual);
		setSexo(sexo);
	}

	/**
	 * M�todo que retorna o nome de usuario
	 * @return  nomeUsuario
	 */
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	/**
	 * M�todo que atribui o valor � nome de usuario
	 * Recebe uma String como paramentro.
	 * @param nomeUsuario - String
	 */
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	/**
	 * M�todo que retorna o email do usu�rio
	 * @return emailUsuario
	 */
	public String getEmailUsuario() {
		return emailUsuario;
	}

	/**
	 * M�todo que atribui o valor de email
	 * Reebe uma String como par�metro
	 * @param emailUsuario - String
	 */
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	/**
	 * M�todo que retorna a senha do usu�rio
	 * @return senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * M�todo que atribui o valor de senha
	 * Recebe uma String como par�metro
	 * @param senha - String
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * M�todo que retorna a Data de cadastro do usu�rio
	 * @return dataCadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}

	/**
	 * M�todo que atribui o valor de data de cadastro
	 * Recebe um Date como par�metro
	 * @param dataCadastro - Date
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * M�todo que retorna o Sexo do usu�rio
	 * @return sexo
	 */
	public char getSexo() {
		return sexo;
	}

	/**
	 * M�todo que atribui o valor de sexo
	 * Recebe um char como par�metro
	 * @param sexo - char
	 */
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	/**
	 * M�todo que retorna o ID do usu�rio
	 * @return idPessoa
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * M�todo que atribui um valor a ID de usuario
	 * Recebe um int como par�metro
	 * @param idPessoa - int
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	
}
