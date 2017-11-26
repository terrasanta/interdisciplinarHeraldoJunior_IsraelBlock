package interdisciplinar.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interdisciplinar.mvc.util.Conn;
import interdisciplinar.mvc.vo.Carrinho;
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
	public Boolean excluir(int idCarrinho) {
		return null;
	}
	
	@Override
	public List<Itens> listarCarrinho(int idUsuario){
		
		List<Itens> listaCarrinho = this.getListaItens();
		
		return listaCarrinho;
		
	}
	
	@Override
	public Boolean finalizar(Carrinho carrinho) {
		try {
			connection = conn.connect();
			preparedStatement = connection.prepareStatement("insert into carrinho"
					+ "(idcarrinho, idusuario, idestabelecimento, valortotal) "
					+ "values "
					+ "(seq_carrinho.nextval, ?, ?, ?)");
			preparedStatement.setInt(1, carrinho.getIdCarrinho());
			preparedStatement.setInt(2, carrinho.getIdUsuario());
			preparedStatement.setInt(3, carrinho.getIdEstabelecimento());
			preparedStatement.setDouble(4, carrinho.getValorTotal());
			
			preparedStatement.executeUpdate();
			
			if (preparedStatement != null)
				preparedStatement.close();
			
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
