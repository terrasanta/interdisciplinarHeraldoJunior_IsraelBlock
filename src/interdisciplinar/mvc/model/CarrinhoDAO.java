package interdisciplinar.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interdisciplinar.mvc.util.Conn;
import interdisciplinar.mvc.vo.Carrinho;

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
	
	public CarrinhoDAO() {
		conn = new Conn();
	}

	@Override
	public boolean incluir(Carrinho carrinho) {
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

	@Override
	public Boolean atualizar(Carrinho carrinho) {
		return null;
	}

	@Override
	public Boolean excluir(int idCarrinho) {
		return null;
	}
	
	@Override
	public List<Carrinho> listarCarrinho(int idUsuario, int idEstabelecimento){
		List <Carrinho> listaCarrinho = new ArrayList<Carrinho>();
		
		try {
			connection = conn.connect();
			
			preparedStatement = connection.prepareStatement("select idcarrinho, idusuario, idestabelecimento, valortotal");
			
			preparedStatement.setInt(1, idEstabelecimento);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
			}
			
			return listaCarrinho;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("caiu no catch");
			return null;
		}
	}

}
