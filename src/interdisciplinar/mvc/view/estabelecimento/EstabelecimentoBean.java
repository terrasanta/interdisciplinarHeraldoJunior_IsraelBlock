package interdisciplinar.mvc.view.estabelecimento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import interdisciplinar.mvc.controller.EstabelecimentoController;
import interdisciplinar.mvc.vo.Estabelecimento;

@ManagedBean(name="estabelecimentoBean")
@SessionScoped

public class EstabelecimentoBean implements Serializable {
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

	public EstabelecimentoBean() {
		setIdEstabelecimento(0);
		setNomeEstabelecimento("");
		setTipoEstabelecimento("");
		setDataCadastro(null);
		listaEstabelecimento = new ArrayList<Estabelecimento>();
	}
	/*@PostConstruct*/
	public void init() {
		System.out.println("Chamou a função carregaLista");
		setListaEstabelecimento(estabelecimentoController.listarEstabelecimento());
	}
	/**
	 * @return the idEstabelecimento
	 */
	public int getIdEstabelecimento() {
		return idEstabelecimento;
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
