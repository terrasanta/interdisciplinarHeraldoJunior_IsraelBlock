/**
 * 
 */
package interdisciplinar.mvc.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import interdisciplinar.mvc.controller.CardapioController;
import interdisciplinar.mvc.controller.CarrinhoController;
import interdisciplinar.mvc.controller.EstabelecimentoController;
import interdisciplinar.mvc.vo.Cardapio;
import interdisciplinar.mvc.vo.Estabelecimento;
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
	private EstabelecimentoController estabelecimentoController;
	private CardapioController cardapioController;
	
	private List<Itens> retornaList;
	
	@ManagedProperty("#{userBean}")
	private UserBean userBean;
	
	/**
	 * 
	 */
	public CarrinhoBean() {
		carrinhoController = new CarrinhoController();
		estabelecimentoController = new EstabelecimentoController();
		cardapioController = new CardapioController();
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
	public String retiraItem(int idEstabelecimento, int idProduto) {
		System.out.println(idEstabelecimento);
		System.out.println(idProduto);
		item = new Itens();
		item.setIdEstabelecimento(idEstabelecimento);
		item.setIdProduto(idProduto);
		List<Itens> listaAtual = carrinhoController.getListaItens();
		System.out.println("tamanho da lista = "+listaAtual.size());
		//Boolean tem = false;
		for (Itens itens : listaAtual) {
			if ((itens.getIdEstabelecimento() == idEstabelecimento) && (itens.getIdProduto() == idProduto)) {
				System.out.println("id item: "+itens.getIdEstabelecimento());
				carrinhoController.excluir(item);
				break;
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
	public String buscarNomeEstabelecimento(int idEstabelecimento) {
		Estabelecimento e = new Estabelecimento();
		e = estabelecimentoController.buscar(idEstabelecimento);
		String nomeEstabelecimento = e.getNomeEstabelecimento();
		return nomeEstabelecimento;
	}
	public String buscaNomeProduto(int idCardapio, int idEstabelecimento) {
		Cardapio c = new Cardapio();
		c = cardapioController.buscar(idCardapio, idEstabelecimento);
		String nomeProduto = c.getNomeProduto();
		return nomeProduto;
	}
	public Double buscaValorProduto(int idCardapio, int idEstabelecimento, int qtde) {
		Cardapio c = new Cardapio();
		c = cardapioController.buscar(idCardapio, idEstabelecimento);
		Double valorProduto = c.getValorProduto()*qtde;
		return valorProduto;
	}
	public String confirmaDados() {
		return "/checkout/confirmadados";
	}
	public String finalizarPedido() {
		Boolean finalizar = carrinhoController.finalizar();
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		if(finalizar==true) {
			contexto.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pedido realizado com sucesso.", null) );
		}else {
			contexto.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao processar seu pedido.", null) );
		}
		return "/checkout/finalizar";
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
	
	
}
