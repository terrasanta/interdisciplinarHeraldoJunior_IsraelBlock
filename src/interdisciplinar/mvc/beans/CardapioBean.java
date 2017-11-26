package interdisciplinar.mvc.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import interdisciplinar.mvc.controller.CardapioController;
import interdisciplinar.mvc.vo.Cardapio;

@ManagedBean(name="cardapioBean")
@SessionScoped

/**
 * @author Israel Block
 * @version 1.0.1
 * @since 12 de nov de 2017
 */
public class CardapioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4686539065924605104L;
	
	private int idCardapio;
	private int idEstabelecimento;
	private String nomeProduto;
	private String descricaoProduto;
	private double valorProduto;
	private int tipoProduto;
	private String nomeTipoProduto;
	private CardapioController cardapioController;
	private List<Cardapio> listaCardapio;
	private Cardapio cardapio;
	/**
	 * 
	 */
	public CardapioBean() {
		cardapio = new Cardapio();
		cardapioController = new CardapioController();
		listaCardapio = new ArrayList<Cardapio>();
	}
	public List<Cardapio> carregaCardapio(int idEstabelecimento){
		return listaCardapio = cardapioController.listarCardapio(idEstabelecimento);
	}

	/**
	 * @return the idCardapio
	 */
	public int getIdCardapio() {
		return idCardapio;
	}

	/**
	 * @param idCardapio the idCardapio to set
	 */
	public void setIdCardapio(int idCardapio) {
		this.idCardapio = idCardapio;
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
	 * @return the nomeProduto
	 */
	public String getNomeProduto() {
		return nomeProduto;
	}

	/**
	 * @param nomeProduto the nomeProduto to set
	 */
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	/**
	 * @return the descricaoProduto
	 */
	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	/**
	 * @param descricaoProduto the descricaoProduto to set
	 */
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	/**
	 * @return the valorProduto
	 */
	public double getValorProduto() {
		return valorProduto;
	}

	/**
	 * @param valorProduto the valorProduto to set
	 */
	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}

	/**
	 * @return the tipoProduto
	 */
	public int getTipoProduto() {
		return tipoProduto;
	}

	/**
	 * @param tipoProduto the tipoProduto to set
	 */
	public void setTipoProduto(int tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	/**
	 * @return the nomeTipoProduto
	 */
	public String getNomeTipoProduto() {
		return nomeTipoProduto;
	}

	/**
	 * @param nomeTipoProduto the nomeTipoProduto to set
	 */
	public void setNomeTipoProduto(String nomeTipoProduto) {
		this.nomeTipoProduto = nomeTipoProduto;
	}

	/**
	 * @return the cardapioController
	 */
	public CardapioController getCardapioController() {
		return cardapioController;
	}

	/**
	 * @param cardapioController the cardapioController to set
	 */
	public void setCardapioController(CardapioController cardapioController) {
		this.cardapioController = cardapioController;
	}

	/**
	 * @return the listaCardapio
	 */
	public List<Cardapio> getListaCardapio() {
		return listaCardapio;
	}

	/**
	 * @param listaCardapio the listaCardapio to set
	 */
	public void setListaCardapio(List<Cardapio> listaCardapio) {
		this.listaCardapio = listaCardapio;
	}

	/**
	 * @return the cardapio
	 */
	public Cardapio getCardapio() {
		return cardapio;
	}

	/**
	 * @param cardapio the cardapio to set
	 */
	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
