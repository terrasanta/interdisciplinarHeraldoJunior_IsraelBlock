/**
 * 
 */
package interdisciplinar.mvc.vo;

/**
 * @author Israel Block
 * @version 1.0.1
 * @since 26 de nov de 2017
 */
public class Itens {
	
	private int idItem;
	private int idProduto;
	private int idEstabelecimento;
	private int qtdeproduto; 

	/**
	 * 
	 */
	public Itens() {

	}

	/**
	 * @return the idItem
	 */
	public int getIdItem() {
		return idItem;
	}

	/**
	 * @param idItem the idItem to set
	 */
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	/**
	 * @return the idProduto
	 */
	public int getIdProduto() {
		return idProduto;
	}

	/**
	 * @param idProduto the idProduto to set
	 */
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	/**
	 * @return the qtdeproduto
	 */
	public int getQtdeproduto() {
		return qtdeproduto;
	}

	/**
	 * @param qtdeproduto the qtdeproduto to set
	 */
	public void setQtdeproduto(int qtdeproduto) {
		this.qtdeproduto = qtdeproduto;
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

	
	
}
