package interdisciplinar.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conn {

	/*
	 * variaveis da instancia
	 */
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String dbUser = "interdis";
	String dbPassword = "opet";
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Connection connection;
	
	public Conn() throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}
	
	public Connection connect() {
		try {
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return connection;
	}

	public void disconnect() throws SQLException {

		if (preparedStatement != null) {
			preparedStatement.close();
		}

		if (connection != null && !connection.isClosed()) {
			connection.close();
		} else {
			System.out.println("CONEXAO NAO ESTAVA FECHADA");
		}

	}
}
