/**
 * 
 */
package interdisciplinar.mvc.vo;

/**
 * @author Israel Block
 * @version 1.0.1
 * @since 25 de nov de 2017
 */
public class Carrinho {

	private int idCarrinho;
	private int idUsuario;
	private int idEstabelecimento;
	private Double valorTotal;
	
	private int idItem;
	private int idProduto;
	private int qtdeproduto; 
	
	

	/**
	 * 
	 */
	public Carrinho() {
	}

	/**
	 * @return the idCarrinho
	 */
	public int getIdCarrinho() {
		return idCarrinho;
	}

	/**
	 * @param idCarrinho the idCarrinho to set
	 */
	public void setIdCarrinho(int idCarrinho) {
		this.idCarrinho = idCarrinho;
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
	 * @return the valorTotal
	 */
	public Double getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
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

	
}
