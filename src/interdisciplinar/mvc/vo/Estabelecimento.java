/**
 * 
 */
package interdisciplinar.mvc.vo;

import java.util.Date;

/**
 * @author Israel Block
 * @version 1.0.1
 * @since 30 de out de 2017
 */
public class Estabelecimento {
	private int idEstabelecimento;
	private String nomeEstabelecimento;
	private int idUserEstabelecimento;
	private Date dataCadastro;
	private String endereco;
	private String telefone;
	private String dadosComplementares;
	private int tipoEstabelecimento;
	private String nomeTipoEstabelecimento;
	/**
	 * 
	 */
	public Estabelecimento() {
		
	}
	public Estabelecimento(int idEstabelecimento, String nomeEstabelecimento, int idUserEstabelecimento, Date dataCadastro, String endereco, String telefone, String dadosComplementares, int tipoEstabelecimento) {
		setIdEstabelecimento(idEstabelecimento);
		setNomeEstabelecimento(nomeEstabelecimento);
		setIdUserEstabelecimento(idUserEstabelecimento);
		setDataCadastro(dataCadastro);
		setEndereco(endereco);
		setTelefone(telefone);
		setDadosComplementares(dadosComplementares);
		setTipoEstabelecimento(tipoEstabelecimento);
	}

	/**
	 * @return the idestabelecimento
	 */
	public int getIdEstabelecimento() {
		return idEstabelecimento;
	}

	/**
	 * @param idestabelecimento the idestabelecimento to set
	 */
	public void setIdEstabelecimento(int idEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
	}

	/**
	 * @return the nomeEstabelecimento
	 */
	public String getNomeEstabelecimento() {
		return nomeEstabelecimento;
	}

	/**
	 * @param nomeEstabelecimento the nomeEstabelecimento to set
	 */
	public void setNomeEstabelecimento(String nomeEstabelecimento) {
		this.nomeEstabelecimento = nomeEstabelecimento;
	}

	/**
	 * @return the idUserEstabelecimento
	 */
	public int getIdUserEstabelecimento() {
		return idUserEstabelecimento;
	}

	/**
	 * @param idUserEstabelecimento the idUserEstabelecimento to set
	 */
	public void setIdUserEstabelecimento(int idUserEstabelecimento) {
		this.idUserEstabelecimento = idUserEstabelecimento;
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
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the dadosComplementares
	 */
	public String getDadosComplementares() {
		return dadosComplementares;
	}

	/**
	 * @param dadosComplementares the dadosComplementares to set
	 */
	public void setDadosComplementares(String dadosComplementares) {
		this.dadosComplementares = dadosComplementares;
	}

	/**
	 * @return the tipoEstabelecimento
	 */
	public int getTipoEstabelecimento() {
		return tipoEstabelecimento;
	}

	/**
	 * @param tipoEstabelecimento the tipoEstabelecimento to set
	 */
	public void setTipoEstabelecimento(int tipoEstabelecimento) {
		this.tipoEstabelecimento = tipoEstabelecimento;
	}
	/**
	 * @return the nomeTipoEstabelecimento
	 */
	public String getNomeTipoEstabelecimento() {
		return nomeTipoEstabelecimento;
	}
	/**
	 * @param nomeTipoEstabelecimento the nomeTipoEstabelecimento to set
	 */
	public void setNomeTipoEstabelecimento(String nomeTipoEstabelecimento) {
		this.nomeTipoEstabelecimento = nomeTipoEstabelecimento;
	}

}
