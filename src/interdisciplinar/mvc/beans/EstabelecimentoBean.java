package interdisciplinar.mvc.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import interdisciplinar.mvc.controller.EstabelecimentoController;
import interdisciplinar.mvc.vo.Cardapio;
import interdisciplinar.mvc.vo.Estabelecimento;

@ManagedBean(name = "estabelecimentoBean")
@SessionScoped

public class EstabelecimentoBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6234649360685548187L;

	@ManagedProperty("#{cardapioBean}")
	private CardapioBean cardapioBean;

	private int idEstabelecimento;
	private String nomeEstabelecimento;
	private String tipoEstabelecimento;
	private Date dataCadastro;
	private EstabelecimentoController estabelecimentoController;
	private List<Estabelecimento> listaEstabelecimento;
	private List<Cardapio> listaCardapio;
	private Estabelecimento estabelecimento;

	public EstabelecimentoBean() {
		estabelecimentoController = new EstabelecimentoController();
		setEstabelecimento(new Estabelecimento());
		setIdEstabelecimento(0);
		setNomeEstabelecimento("");
		setTipoEstabelecimento("");
		setDataCadastro(null);
		listaEstabelecimento = estabelecimentoController.listarEstabelecimento();
	}

	public String carregaEstabelecimento(int idEstabelecimento) {
		Estabelecimento estabelecimento = new Estabelecimento();
		if (idEstabelecimento == 0) {
			return "/index";
		} else {
			estabelecimento = estabelecimentoController.buscar(idEstabelecimento);
			setIdEstabelecimento(idEstabelecimento);
			setNomeEstabelecimento(estabelecimento.getNomeEstabelecimento());
			setDataCadastro(estabelecimento.getDataCadastro());
			setTipoEstabelecimento(estabelecimentoController.nomeTipo(estabelecimento.getTipoEstabelecimento()));
			listaCardapio = cardapioBean.carregaCardapio(idEstabelecimento);
			for (Cardapio cardapio : listaCardapio) {
				cardapioBean.setIdCardapio(cardapio.getIdCardapio());
				cardapioBean.setNomeProduto(cardapio.getNomeProduto());
				cardapioBean.setValorProduto(cardapio.getValorProduto());
			}
		}
		return "/estabelecimentos/detalhesEstabelecimento";
	}
	public String pesquisar() {
		FacesContext contexto = FacesContext.getCurrentInstance();
		setEstabelecimentoController(new EstabelecimentoController());
		listaEstabelecimento = new ArrayList<Estabelecimento>();

		if (this.nomeEstabelecimento == null) {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome não pode ser nulo.", null));
			return "/index.html";
		} else {
			listaEstabelecimento = estabelecimentoController.pesquisar(nomeEstabelecimento);
			return "/pesquisa/resultado";
		}
	}

	/**
	 * @return the idEstabelecimento
	 */
	public int getIdEstabelecimento() {
		return idEstabelecimento;
	}

	/**
	 * @param idEstabelecimento
	 *            the idEstabelecimento to set
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
	 * @param nomeEstabelecimento
	 *            the nomeEstabelecimento to set
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
	 * @param tipoEstabelecimento
	 *            the tipoEstabelecimento to set
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
	 * @param dataCadastro
	 *            the dataCadastro to set
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
	 * @param estabelecimentoController
	 *            the estabelecimentoController to set
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
	 * @param listaEstabelecimento
	 *            the listaEstabelecimento to set
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

	/**
	 * @return the estabelecimento
	 */
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	/**
	 * @param estabelecimento
	 *            the estabelecimento to set
	 */
	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	/**
	 * @return the listaCardapio
	 */
	public List<Cardapio> getListaCardapio() {
		return listaCardapio;
	}

	/**
	 * @param listaCardapio
	 *            the listaCardapio to set
	 */
	public void setListaCardapio(List<Cardapio> listaCardapio) {
		this.listaCardapio = listaCardapio;
	}

	/**
	 * @return the cardapioBean
	 */
	public CardapioBean getCardapioBean() {
		return cardapioBean;
	}

	/**
	 * @param cardapioBean
	 *            the cardapioBean to set
	 */
	public void setCardapioBean(CardapioBean cardapioBean) {
		this.cardapioBean = cardapioBean;
	}

}
