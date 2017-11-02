package interdisciplinar.mvc.vo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe que representa um usuário.
 * Aqui está definido os métodos de acesso para os atributos do usuário.
 * 
 * @author Israel Block e Heraldo Junior
 * @version 1.0.1
 * @since 16 de out de 2017
 */
public class User {

	/**
	 * armazena o valor do id do usuario, seja da aplicação ou do banco de dados 
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
	 * Armazena um Char representando o sexo do usuário. M para Masculino, F para Feminino e O para Outros.
	 */
	private char sexo;
	
	/**
	 * Método construtor vazio.
	 * Apenas instancia o usuário, possibilitando o acesso aos métodos Getters and Setters.
	 */
	public User() {
		
	}
	
	/**
	 * Método construtor que recebe parâmetros para a inicialização do objeto.
	 * Fora os parâmetros que são passados, o método também guarda a data atual, e chama o método setDataAtual.
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
	 * Método que retorna o nome de usuario
	 * @return  nomeUsuario
	 */
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	/**
	 * Método que atribui o valor à nome de usuario
	 * Recebe uma String como paramentro.
	 * @param nomeUsuario - String
	 */
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	/**
	 * Método que retorna o email do usuário
	 * @return emailUsuario
	 */
	public String getEmailUsuario() {
		return emailUsuario;
	}

	/**
	 * Método que atribui o valor de email
	 * Reebe uma String como parâmetro
	 * @param emailUsuario - String
	 */
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	/**
	 * Método que retorna a senha do usuário
	 * @return senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Método que atribui o valor de senha
	 * Recebe uma String como parâmetro
	 * @param senha - String
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * Método que retorna a Data de cadastro do usuário
	 * @return dataCadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}

	/**
	 * Método que atribui o valor de data de cadastro
	 * Recebe um Date como parâmetro
	 * @param dataCadastro - Date
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * Método que retorna o Sexo do usuário
	 * @return sexo
	 */
	public char getSexo() {
		return sexo;
	}

	/**
	 * Método que atribui o valor de sexo
	 * Recebe um char como parâmetro
	 * @param sexo - char
	 */
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	/**
	 * Método que retorna o ID do usuário
	 * @return idPessoa
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * Método que atribui um valor a ID de usuario
	 * Recebe um int como parâmetro
	 * @param idPessoa - int
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	
}
