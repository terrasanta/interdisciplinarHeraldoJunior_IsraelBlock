/**
 * 
 */
package interdisciplinar.mvc.vo;

/**
 * @author Israel Block
 * @version 1.0.1
 * @since 11 de nov de 2017
 */
public class Cardapio {

	private int idCardapio;
	private int idProduto;
	private int idEstabelecimento;
	private String nomeProduto;
	private String descricaoProduto;
	private double valorProduto;
	private int tipoProduto;
	/**
	 * 
	 */
	public Cardapio() {
		
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
	
	

}
