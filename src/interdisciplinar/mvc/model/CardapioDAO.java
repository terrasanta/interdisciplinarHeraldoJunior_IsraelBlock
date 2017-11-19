package interdisciplinar.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interdisciplinar.mvc.util.Conn;
import interdisciplinar.mvc.vo.Cardapio;

public class CardapioDAO implements ICardapioDAO {

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
	
	public CardapioDAO() {
		conn = new Conn();
	}

	@Override
	public boolean incluir(Cardapio cardapio) {
		try {
			connection = conn.connect();
			preparedStatement = connection.prepareStatement("insert into estabelecimento"
					+ "(id_cardapio_estab, id_estab, nome_produto, descricao_produto, valor_produto, tipo_produto) "
					+ "values "
					+ "(seq_id_cardapio.nextval, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, cardapio.getIdEstabelecimento());
			preparedStatement.setString(2, cardapio.getNomeProduto());
			preparedStatement.setString(3, cardapio.getDescricaoProduto());
			preparedStatement.setDouble(4, cardapio.getValorProduto());
			preparedStatement.setInt(5, cardapio.getTipoProduto());
			
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
	public List<Cardapio> listarCardapio(int idEstabelecimento) {
		List <Cardapio> listaCardapio = new ArrayList<Cardapio>();
		
		try {
			connection = conn.connect();
			
			preparedStatement = connection.prepareStatement("select id_cardapio_estab, nome_produto, descricao_produto, "
					+ "valor_produto, tipo_produto FROM cardapio_estabelecimento where id_estab = ?");
			
			preparedStatement.setInt(1, idEstabelecimento);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Cardapio c;
				
				int id_produto = resultSet.getInt("id_cardapio_estab");
				String nome = resultSet.getString("nome_produto");
				String descricao = resultSet.getString("descricao_produto");
				Double valor = resultSet.getDouble("valor_produto");
				int tipoProduto = resultSet.getInt("tipo_produto");
				
				c = new Cardapio();
				
				c.setIdCardapio(id_produto);
				c.setNomeProduto(nome);
				c.setDescricaoProduto(descricao);
				c.setTipoProduto(tipoProduto);
				c.setValorProduto(valor);
				c.setIdEstabelecimento(idEstabelecimento);
				
				listaCardapio.add(c);
				System.out.println("gerou a lista do cardapio "+c);
			}
			
			return listaCardapio;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("caiu no catch");
			return null;
		}
	}

	@Override
	public Boolean atualizar(Cardapio cardapio) {
		return null;
	}

	@Override
	public Boolean excluir(int idCardapio, int idEstabelecimento) {
		return null;
	}

	@Override
	public Cardapio buscar(int idCardapio, int idEstabelecimento) {
		return null;
	}

	@Override
	public Cardapio buscar(String nomeCardapio, int idEstabelecimento) {
		return null;
	}

}
