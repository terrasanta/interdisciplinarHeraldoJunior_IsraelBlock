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
import interdisciplinar.mvc.vo.UserAdmin;
import interdisciplinar.mvc.vo.UserEstabelecimento;
import interdisciplinar.mvc.vo.UserPublic;
import interdisciplinar.mvc.vo.User;

/**
 * @author Israel Block
 * @version 1.0.1
 * @since 15 de out de 2017
 */
public class UserDAO implements IUserDAO {
	
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

	public UserDAO() throws ClassNotFoundException {
		conn = new Conn();
	}
	
		/* (non-Javadoc)
	 * @see interdisciplinar.mvc.model.IUsuarioDAO#incluir(interdisciplinar.mvc.vo.Usuario)
	 */
	@Override
	public boolean incluir(User usuario) {

		try {
			connection = conn.connect();
			preparedStatement = connection.prepareStatement("insert into usuario"
					+ "(id_usuario, nome_usuario, email_usuario, senha, data_cadastro, sexo, tipo) "
					+ "values "
					+ "(seq_id_usuario.nextval, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, usuario.getNomeUsuario());
			preparedStatement.setString(2, usuario.getEmailUsuario());
			preparedStatement.setString(3, usuario.getSenha());
			preparedStatement.setDate(4, new java.sql.Date(usuario.getDataCadastro().getTime()) );
			preparedStatement.setString(5, String.valueOf(usuario.getSexo()));
			int tipo;
			if(usuario instanceof UserAdmin) {
				tipo = 1;
			}else if(usuario instanceof UserEstabelecimento) {
				tipo = 2;
			}else {
				tipo = 3;
			}
			preparedStatement.setInt(6, tipo);
			preparedStatement.executeUpdate();
			
			if (preparedStatement != null)
				preparedStatement.close();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				conn.disconnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see interdisciplinar.mvc.model.IUsuarioDAO#atualizar(interdisciplinar.mvc.vo.Usuario)
	 */
	@Override
	public Boolean atualizar(User usuario) {
		try {
			connection = conn.connect();
			preparedStatement = connection.prepareStatement("update usuario set nome_usuario=?, email_usuario = ?, senha=?, sexo=? where id_usuario = ?");
			
			preparedStatement.setString(1, usuario.getNomeUsuario());
			preparedStatement.setString(2, usuario.getEmailUsuario());
			preparedStatement.setString(3, usuario.getSenha());
			preparedStatement.setString(4, String.valueOf(usuario.getSexo()));
			preparedStatement.setInt(5, usuario.getIdUsuario());
			
			int numRegAtualizados = preparedStatement.executeUpdate();
			System.out.println(numRegAtualizados + " registros atualizados.");
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				conn.disconnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/* (non-Javadoc)
	 * @see interdisciplinar.mvc.model.IUsuarioDAO#excluir(interdisciplinar.mvc.vo.Usuario)
	 */
	@Override
	public Boolean excluir(int idUsuario) {
		try {
			connection = conn.connect();
			preparedStatement = connection.prepareStatement("delete from usuario where id_usuario = ?");
			preparedStatement.setInt(1, idUsuario);
			
			int numRegDeletados = preparedStatement.executeUpdate();
			
			System.out.println(numRegDeletados + " registros deletados.");
			
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				conn.disconnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see interdisciplinar.mvc.model.IUsuarioDAO#listarUsuarios()
	 */
	@Override
	public List<User> listarUsuarios() {
		
		List <User> listaUsuario = new ArrayList<User>();
		
		try {
			connection = conn.connect();
			
			preparedStatement = connection.prepareStatement("select id_usuario, nome_usuario, email_usuario, senha, data_cadastro, tipo, sexo from usuario");
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				User u;
				
				int id = resultSet.getInt("id_usuario");
				String nome = resultSet.getString("nome_usuario");
				String email = resultSet.getString("email_usuario");
				String senha = resultSet.getString("senha");
				Date data = new java.util.Date(resultSet.getDate("data_cadastro").getTime());
				String s = resultSet.getString("sexo");
				char sexo = s.charAt(0);
				int tipo = resultSet.getInt("tipo");
				
				if(tipo == 1) {
					u = new UserAdmin();
					u.setIdUsuario(id);
					u.setNomeUsuario(nome);
					u.setEmailUsuario(email);
					u.setSenha(senha);
					u.setDataCadastro(data);
					u.setSexo(sexo);
				}else if(tipo == 2) {
					u = new UserEstabelecimento();
					u.setIdUsuario(id);
					u.setNomeUsuario(nome);
					u.setEmailUsuario(email);
					u.setSenha(senha);
					u.setDataCadastro(data);
					u.setSexo(sexo);
				}else {
					u = new UserPublic();
					u.setIdUsuario(id);
					u.setNomeUsuario(nome);
					u.setEmailUsuario(email);
					u.setSenha(senha);
					u.setDataCadastro(data);
					u.setSexo(sexo);
				}
				
				listaUsuario.add(u);
			}
			
			return listaUsuario;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				conn.disconnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	/* (non-Javadoc)
	 * @see interdisciplinar.mvc.model.IUsuarioDAO#pesquisar(java.lang.Integer)
	 */
	@Override
	public User pesquisar(Integer idUsuario) {
		
		List<User> listaUsuario = new ArrayList<User>();
		
		connection = conn.connect();
		try {
			preparedStatement = connection.prepareStatement("select nome_usuario, email_usuario, senha, data_cadastro, tipo, sexo from usuario where id_usuario = ?");
			preparedStatement.setInt(1, idUsuario);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				User u;
				
				String nome = resultSet.getString("nome_usuario");
				String email = resultSet.getString("email_usuario");
				String senha = resultSet.getString("senha");
				Date data = new java.util.Date(resultSet.getDate("data_cadastro").getTime());
				String s = resultSet.getString("sexo");
				char sexo = s.charAt(0);
				int tipo = resultSet.getInt("tipo");
				
				if(tipo == 1) {
					u = new UserAdmin();
					u.setIdUsuario(idUsuario);
					u.setNomeUsuario(nome);
					u.setEmailUsuario(email);
					u.setSenha(senha);
					u.setDataCadastro(data);
					u.setSexo(sexo);
				}else if(tipo == 2) {
					u = new UserEstabelecimento();
					u.setIdUsuario(idUsuario);
					u.setNomeUsuario(nome);
					u.setEmailUsuario(email);
					u.setSenha(senha);
					u.setDataCadastro(data);
					u.setSexo(sexo);
				}else {
					u = new UserPublic();
					u.setIdUsuario(idUsuario);
					u.setNomeUsuario(nome);
					u.setEmailUsuario(email);
					u.setSenha(senha);
					u.setDataCadastro(data);
					u.setSexo(sexo);
				}
				
				listaUsuario.add(u);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				conn.disconnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(listaUsuario != null & listaUsuario.size() > 0) {
			return listaUsuario.get(0);
		}else {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see interdisciplinar.mvc.model.IUsuarioDAO#pesquisar(java.lang.String)
	 */
	@Override
	public List<User> pesquisar(String nomeUsuario) {
		
		List<User> listaUsuario = new ArrayList<User>();
		
		connection = conn.connect();
		try {
			preparedStatement = connection.prepareStatement("select id_usuario, nome_usuario, email_usuario, "
					+ "senha, data_cadastro, tipo, sexo from usuario where lower(nome_usuario) like lower( ? ) || '%'");
			preparedStatement.setString(1, nomeUsuario);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				User u;
				
				int idUsuario = resultSet.getInt("id_usuario");
				String nome = resultSet.getString("nome_usuario");
				String email = resultSet.getString("email_usuario");
				String senha = resultSet.getString("senha");
				Date data = new java.util.Date(resultSet.getDate("data_cadastro").getTime());
				String s = resultSet.getString("sexo");
				char sexo = s.charAt(0);
				int tipo = resultSet.getInt("tipo");
				
				if(tipo == 1) {
					u = new UserAdmin();
					u.setIdUsuario(idUsuario);
					u.setNomeUsuario(nome);
					u.setEmailUsuario(email);
					u.setSenha(senha);
					u.setDataCadastro(data);
					u.setSexo(sexo);
				}else if(tipo == 2) {
					u = new UserEstabelecimento();
					u.setIdUsuario(idUsuario);
					u.setNomeUsuario(nome);
					u.setEmailUsuario(email);
					u.setSenha(senha);
					u.setDataCadastro(data);
					u.setSexo(sexo);
				}else {
					u = new UserPublic();
					u.setIdUsuario(idUsuario);
					u.setNomeUsuario(nome);
					u.setEmailUsuario(email);
					u.setSenha(senha);
					u.setDataCadastro(data);
					u.setSexo(sexo);
				}
				listaUsuario.add(u);
			}
			return listaUsuario;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				conn.disconnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	

}
