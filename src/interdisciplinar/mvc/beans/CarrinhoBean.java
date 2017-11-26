/**
 * 
 */
package interdisciplinar.mvc.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import interdisciplinar.mvc.controller.CarrinhoController;
import interdisciplinar.mvc.vo.Itens;
import interdisciplinar.mvc.vo.User;

@ManagedBean(name="carrinhoBean")
@SessionScoped
/**
 * @author Israel Block
 * @version 1.0.1
 * @since 25 de nov de 2017
 */
public class CarrinhoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -264489059587620319L;
	
	private User user;
	
	private Itens item;
	
	private CarrinhoController carrinhoController;
	
	private List<Itens> retornaList;
	
	@ManagedProperty("#{userBean}")
	private UserBean userBean;

	/**
	 * 
	 */
	public CarrinhoBean() {
		carrinhoController = new CarrinhoController();
	}
	
	/**
	 * @return the userBean
	 */
	public UserBean getUserBean() {
		return userBean;
	}

	/**
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	/**
	 * @return the retornaList
	 */
	public List<Itens> getRetornaList() {
		return retornaList;
	}

	/**
	 * @param retornaList the retornaList to set
	 */
	public void setRetornaList(List<Itens> retornaList) {
		this.retornaList = retornaList;
	}

	public String incluiItem(int idEstabelecimento, int idProduto) {
		item = new Itens();
		List<Itens> listaAtual = carrinhoController.getListaItens();
		int qtde = 1;
		item.setIdEstabelecimento(idEstabelecimento);
		item.setIdProduto(idProduto);
		Boolean tem = false;
		if(listaAtual.isEmpty()) {
			item.setQtdeproduto(qtde);
			carrinhoController.incluir(item);
		}else {
			for (Itens itens : listaAtual) {
				if ((itens.getIdEstabelecimento() == idEstabelecimento) && (itens.getIdProduto() == idProduto)) {
					qtde = itens.getQtdeproduto()+1;
					tem = true;
				}
			}
			if(tem) {
				item.setQtdeproduto(qtde);
				carrinhoController.atualizar(item);
			}else {
				item.setQtdeproduto(qtde);
				carrinhoController.incluir(item);
			}
			
		}
		
		setRetornaList(carrinhoController.getListaItens());
		return "/estabelecimentos/detalhesEstabelecimento";
	}
	public Double retornaTotal() {
		List<Itens> listaAtual = carrinhoController.getListaItens();
		Double valorTotal = new Double(0.0);
		for (Itens itens : listaAtual) {
			valorTotal = valorTotal + (carrinhoController.retornaValorItem(itens.getIdProduto(), itens.getIdEstabelecimento())*itens.getQtdeproduto());
		}
		return valorTotal;
	}
	public void listaCarrinho() {
		int idUsuario = this.getUser().getIdUsuario();
		setRetornaList(carrinhoController.listarCarrinho(idUsuario));
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the item
	 */
	public Itens getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Itens item) {
		this.item = item;
	}
}
