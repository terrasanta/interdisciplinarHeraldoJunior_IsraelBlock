/**
 * 
 */
package interdisciplinar.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interdisciplinar.mvc.util.Conn;
import interdisciplinar.mvc.vo.Estabelecimento;

/**
 * @author Israel Block
 * @version 1.0.1
 * @since 28 de out de 2017
 */
public class EstabelecimentoDAO implements IEstabelecimentoDAO {
	private Conn conn;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private Connection connection = null;

	public EstabelecimentoDAO() {
		conn = new Conn();
	}

	@Override
	public boolean incluir(Estabelecimento estabelecimento) {
		try {
			connection = conn.connect();
			preparedStatement = connection.prepareStatement("insert into estabelecimento"
					+ "(id_estabelecimento, nome_estabelecimento, id_usuario, data_cadastro, endereco, telefone, dados_complementares, tipo_estabelecimento) "
					+ "values " + "(seq_id_estabelecimento.nextval, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, estabelecimento.getNomeEstabelecimento());
			preparedStatement.setInt(2, estabelecimento.getIdUserEstabelecimento());
			preparedStatement.setDate(3, new java.sql.Date(estabelecimento.getDataCadastro().getTime()));
			preparedStatement.setString(4, estabelecimento.getEndereco());
			preparedStatement.setString(5, estabelecimento.getTelefone());
			preparedStatement.setString(6, estabelecimento.getDadosComplementares());
			preparedStatement.setInt(7, estabelecimento.getTipoEstabelecimento());

			preparedStatement.executeUpdate();

			if (preparedStatement != null)
				preparedStatement.close();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			conn.disconnect();
		}
	}

	@Override
	public List<Estabelecimento> listarEstabelecimento() {
		System.out.println("Antes de gerar a lista");
		List<Estabelecimento> listaEstabelecimento = new ArrayList<Estabelecimento>();

		try {
			System.out.println("Connecta dentro do listarEstabelecimento");
			connection = conn.connect();
			System.out.println("Antes do preparedStatement");
			preparedStatement = connection
					.prepareStatement("select id_estabelecimento, nome_estabelecimento, id_usuario, "
							+ "data_cadastro, endereco, telefone, dados_complementares, tipo_estabelecimento FROM estabelecimento");
			System.out.println("antes do executeQuery");
			resultSet = preparedStatement.executeQuery();
			System.out.println("Antes do if");
			if (resultSet.next()==true) {
				System.out.println("Entrou no if");
				do {
					System.out.println("Entrou no DO");
					Estabelecimento e;

					System.out.println("Criou estabelecimento E");
					
					int id = resultSet.getInt("id_estabelecimento");
					String nome = resultSet.getString("nome_estabelecimento");
					int idUsuario = resultSet.getInt("id_usuario");
					Date dataCadastro = resultSet.getDate("data_cadastro");
					String endereco = resultSet.getString("endereco");
					String telefone = resultSet.getString("telefone");
					String dadosComplementares = resultSet.getString("dados_complementares");
					int tipoEstabelecimento = resultSet.getInt("tipo_estabelecimento");

					System.out.println("Gerou os campos a pártir do resultSet.get");
					e = new Estabelecimento();
					System.out.println("Instanciou estabelecimento");

					e.setIdEstabelecimento(id);
					e.setNomeEstabelecimento(nome);
					e.setIdUserEstabelecimento(idUsuario);
					e.setDataCadastro(dataCadastro);
					e.setEndereco(endereco);
					e.setTelefone(telefone);
					e.setDadosComplementares(dadosComplementares);
					e.setTipoEstabelecimento(tipoEstabelecimento);
					
					e.setNomeTipoEstabelecimento(this.nomeTipo(tipoEstabelecimento));
					
					System.out.println("Atribuiu valores aos campos do objeto");

					listaEstabelecimento.add(e);
					System.out.println("incluiu o objeto e na lista de Estabelecimentos");
				} while (resultSet.next()==true);
			}else {
				System.out.println("Sem nenhum next");
			}
			return listaEstabelecimento;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		} finally {
			conn.disconnect();
		}
	}

	@Override
	public Boolean atualizar(Estabelecimento estabelecimento) {
		try {
			connection = conn.connect();
			preparedStatement = connection.prepareStatement("update estabelecimento"
					+ "set nome_estabelecimento = ?, id_usuario = ?, data_cadastro = ?, endereco = ?, telefone = ?, "
					+ "dados_complementares = ?, tipo_estabelecimento = ? where id_estabelecimento = ?");
			preparedStatement.setString(7, estabelecimento.getNomeEstabelecimento());
			preparedStatement.setInt(1, estabelecimento.getIdUserEstabelecimento());
			preparedStatement.setDate(2, new java.sql.Date(estabelecimento.getDataCadastro().getTime()));
			preparedStatement.setString(3, estabelecimento.getEndereco());
			preparedStatement.setString(4, estabelecimento.getTelefone());
			preparedStatement.setString(5, estabelecimento.getDadosComplementares());
			preparedStatement.setInt(6, estabelecimento.getTipoEstabelecimento());

			int numRegAtualizados = preparedStatement.executeUpdate();
			System.out.println(numRegAtualizados + " registros atualizados.");
			if (preparedStatement != null)
				preparedStatement.close();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			conn.disconnect();
		}
	}

	@Override
	public Boolean excluir(int idEstabelecimento) {
		try {
			connection = conn.connect();
			preparedStatement = connection.prepareStatement("delete from estabelecimento where id_estabelecimento = ?");
			preparedStatement.setInt(1, idEstabelecimento);

			int numRegDeletados = preparedStatement.executeUpdate();

			System.out.println(numRegDeletados + " registros deletados.");

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			conn.disconnect();
		}
	}

	@Override
	public Estabelecimento buscar(int idEstabelecimento) {
		Estabelecimento e = null;
		try {
			connection = conn.connect();

			preparedStatement = connection.prepareStatement("select nome_estabelecimento, id_usuario, "
					+ "data_cadastro, endereco, telefone, dados_complementares, tipo_estabelecimento FROM estabelecimento where id_estabelecimento = ?");
			preparedStatement.setInt(1, idEstabelecimento);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int id = idEstabelecimento;
				String nome = resultSet.getString("nome_estabelecimento");
				int idUsuario = resultSet.getInt("id_usuario");
				Date dataCadastro = resultSet.getDate("data_cadastro");
				String endereco = resultSet.getString("endereco");
				String telefone = resultSet.getString("telefone");
				String dadosComplementares = resultSet.getString("dados_complementares");
				int tipoEstabelecimento = resultSet.getInt("tipo_estabelecimento");

				e = new Estabelecimento();

				e.setIdEstabelecimento(id);
				e.setNomeEstabelecimento(nome);
				e.setIdUserEstabelecimento(idUsuario);
				e.setDataCadastro(dataCadastro);
				e.setEndereco(endereco);
				e.setTelefone(telefone);
				e.setDadosComplementares(dadosComplementares);
				e.setTipoEstabelecimento(tipoEstabelecimento);

				System.out.println("gerou a lista " + e);
			}

			return e;

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("caiu no catch");
			return null;
		} 
	}

	@Override
	public List<Estabelecimento> pesquisar(String nomeEstabelecimento) {
		return null;
	}

	@Override
	public List<Estabelecimento> pesquisar(int tipoestabelecimento) {
		return null;
	}

	@Override
	public String nomeTipo(int tipo) {
		//connection = conn.connect();
		try {
			String nomeTipo = null;
			preparedStatement = connection
					.prepareStatement("select nome_tipo_estab from tipo_estabelecimento where id_tipo_estab = ?");
			preparedStatement.setInt(1, tipo);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				nomeTipo = resultSet.getString("nome_tipo_estab");
			}

			return nomeTipo;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
	}

}
