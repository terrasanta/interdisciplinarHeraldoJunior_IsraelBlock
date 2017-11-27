package interdisciplinar.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import interdisciplinar.mvc.beans.UserBean;
import interdisciplinar.mvc.util.Conn;
import interdisciplinar.mvc.vo.Itens;

public class CarrinhoDAO implements ICarrinhoDAO {

	/**
	 * 
	 */
	private Conn conn;
	/**
	 * 
	 */
	private PreparedStatement preparedStatement = null;
	/**
	 * 
	 */
	private ResultSet resultSet = null;
	/**
	 * 
	 */
	private Connection connection = null;
	
	private List<Itens> listaItens;
	
	@ManagedProperty("#{userBean}")
	private UserBean userBean;
	
	public CarrinhoDAO() {
		conn = new Conn();
		listaItens = new ArrayList<Itens>();
	}

	@Override
	public Boolean incluir(Itens item) {
		listaItens.add(item);
		System.out.println("Incluiu item");
		return true;
	}

	@Override
	public Boolean atualizar(Itens item) {
		int idEstab = item.getIdEstabelecimento();
		int idProd = item.getIdProduto();
		int qtde = item.getQtdeproduto();
		
		for (Itens itens : listaItens) {
			if ((itens.getIdEstabelecimento() == idEstab) && (itens.getIdProduto() == idProd)) {
				itens.setQtdeproduto(qtde);
			}
		}
		return true;
	}

	@Override
	public Boolean excluir(Itens item) {
		int idEstab = item.getIdEstabelecimento();
		int idProd = item.getIdProduto();
		for (Itens itens : listaItens) {
			if ((itens.getIdEstabelecimento() == idEstab) && (itens.getIdProduto() == idProd)) {
				listaItens.remove(item);
				System.out.println("removeu item");
			}
		}
		return true;
	}
	
	@Override
	public List<Itens> listarCarrinho(int idUsuario){
		
		List<Itens> listaCarrinho = this.getListaItens();
		
		return listaCarrinho;
		
	}
	
	@Override
	public Boolean finalizar() {
		List<Itens> listaFinalizar = listaItens;
		Double valorTotal = new Double(0.0);
		for (Itens itens : listaFinalizar) {
			valorTotal = valorTotal + (this.retornaValorItem(itens.getIdProduto(), itens.getIdEstabelecimento())*itens.getQtdeproduto());
		}
		int userId = 1;
		try {
			connection = conn.connect();
			System.out.println("insert into carrinho (idcarrinho, idusuario, valortotal) values (seq_carrinho.nextval, "+userId+","+valorTotal+")");
			preparedStatement = connection.prepareStatement("insert into carrinho"
					+ "(idcarrinho, idusuario, valortotal) "
					+ "values "
					+ "(seq_carrinho.nextval, ?, ?)");
			preparedStatement.setInt(1, userId);
			preparedStatement.setDouble(2, valorTotal);
			
			preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement("select idcarrinho from carrinho where rownum <= 1 order by idcarrinho desc");
			ResultSet rs = preparedStatement.executeQuery();
			int id = 0;
			if(rs.next()){
				id = rs.getInt("idcarrinho");
			}
			for (Itens itens : listaFinalizar) {
				try {
					System.out.println("insert into itenspedido (iditem, idcarrinho, idestabelecimento, idproduto, qtdeproduto) values (seq_itenspedido.nextval, "+id+", "+itens.getIdEstabelecimento()+", "+itens.getIdProduto()+", "+itens.getQtdeproduto()+")");
					preparedStatement = connection.prepareStatement("insert into itenspedido"
							+ "(iditem, idcarrinho, idestabelecimento, idproduto, qtdeproduto) "
							+ "values "
							+ "(seq_itenspedido.nextval, ?, ?, ?, ?)");
					preparedStatement.setInt(1, id);
					preparedStatement.setInt(2, itens.getIdEstabelecimento());
					preparedStatement.setInt(3, itens.getIdProduto());
					preparedStatement.setInt(4, itens.getQtdeproduto());
					preparedStatement.executeUpdate();
				}catch(SQLException ex) {
					ex.printStackTrace();
					return false;
				}
			}
			
			
			if (preparedStatement != null)
				preparedStatement.close();
			listaItens = null;
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			conn.disconnect();
		}
	}

	/**
	 * @return the listaItens
	 */
	public List<Itens> getListaItens() {
		return listaItens;
	}

	/**
	 * @param listaItens the listaItens to set
	 */
	public void setListaItens(List<Itens> listaItens) {
		this.listaItens = listaItens;
	}

	public Double retornaValorItem(int idItem, int idEstabelecimento) {
		try {
			System.out.println("Enttrou na função");
			connection = conn.connect();
			String sql = "select valor_produto from cardapio_estabelecimento where id_cardapio_estab = "+idItem+" and id_estab = "+idEstabelecimento;
			System.out.println(sql);
			preparedStatement = connection.prepareStatement("select valor_produto from cardapio_estabelecimento where id_cardapio_estab = ? and id_estab = ?");
			preparedStatement.setInt(1, idItem);
			preparedStatement.setInt(2, idEstabelecimento);
			
			resultSet = preparedStatement.executeQuery();
			Double valor = null;
			while(resultSet.next()) {
				valor = resultSet.getDouble("valor_produto");
			}
			System.out.println("Depois do While");
			System.out.println(valor);
			if (preparedStatement != null)
				preparedStatement.close();
			
			return valor;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			conn.disconnect();
		}
	}
	
}
