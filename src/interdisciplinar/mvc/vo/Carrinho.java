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
}
