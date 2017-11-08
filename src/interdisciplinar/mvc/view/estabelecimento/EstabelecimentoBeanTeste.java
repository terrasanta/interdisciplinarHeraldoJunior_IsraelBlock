package interdisciplinar.mvc.view.estabelecimento;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import interdisciplinar.mvc.controller.EstabelecimentoController;
import interdisciplinar.mvc.vo.Estabelecimento;

/**
 * Session Bean implementation class EstabelecimentoBeanTeste
 */
@Stateless(mappedName = "estabelecimentoBeanTeste")
@TransactionManagement(TransactionManagementType.BEAN)
@LocalBean
public class EstabelecimentoBeanTeste implements Serializable  {

private int idEstabelecimento;
	
	private String nomeEstabelecimento;
	
	private String tipoEstabelecimento;
	
	private Date dataCadastro;
	
	private EstabelecimentoController estabelecimentoController;
	
	private List<Estabelecimento> listaEstabelecimento;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6234649360685548187L;

	public EstabelecimentoBeanTeste() {
		listaEstabelecimento = estabelecimentoController.listarEstabelecimento();
		
		setIdEstabelecimento(0);
		setNomeEstabelecimento("");
		setTipoEstabelecimento("");
		setDataCadastro(null);
	}
	/**
	 * @return the idEstabelecimento
	 */
	public int getIdEstabelecimento() {
		return idEstabelecimento;
	}

	public String pesquisar() {
		//Funcionario funcionario = null;
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		estabelecimentoController = new EstabelecimentoController();
		
		if(nomeEstabelecimento.equals("")) {
			listaEstabelecimento = estabelecimentoController.listarEstabelecimento();
			if(listaEstabelecimento == null) {
				setNomeEstabelecimento("");
				contexto.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Problemas ao retornar lista", null) );
				return "/admin_estabelecimento/index";
			}
			
		} else {
			listaEstabelecimento = estabelecimentoController.pesquisar(nomeEstabelecimento);
			if(listaEstabelecimento == null) {
				setNomeEstabelecimento("");
				contexto.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Problemas ao retornar lista", null) );
				return "/admin_estabelecimento/index";
			}
		}
		return "/admin_estabelecimento/index";
		
	}
	/**
	 * @param idEstabelecimento the idEstabelecimento to set
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
	 * @return the tipoEstabelecimento
	 */
	public String getTipoEstabelecimento() {
		return tipoEstabelecimento;
	}

	/**
	 * @param tipoEstabelecimento the tipoEstabelecimento to set
	 */
	public void setTipoEstabelecimento(String tipoEstabelecimento) {
		this.tipoEstabelecimento = tipoEstabelecimento;
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
	 * @return the estabelecimentoController
	 */
	public EstabelecimentoController getEstabelecimentoController() {
		return estabelecimentoController;
	}

	/**
	 * @param estabelecimentoController the estabelecimentoController to set
	 */
	public void setEstabelecimentoController(EstabelecimentoController estabelecimentoController) {
		this.estabelecimentoController = estabelecimentoController;
	}

	/**
	 * @return the listaEstabelecimento
	 */
	public List<Estabelecimento> getListaEstabelecimento() {
		return listaEstabelecimento;
	}

	/**
	 * @param listaEstabelecimento the listaEstabelecimento to set
	 */
	public void setListaEstabelecimento(List<Estabelecimento> listaEstabelecimento) {
		this.listaEstabelecimento = listaEstabelecimento;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	


}
