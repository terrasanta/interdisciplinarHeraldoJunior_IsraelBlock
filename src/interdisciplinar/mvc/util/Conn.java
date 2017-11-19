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
	
	public Conn(){
		try {
			DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Deu ruim na conexão");
		}
	}
	
	public Connection connect() {
		try {
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			System.out.println("Conectou");
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("Não conectou "+e.getErrorCode());
			return null;
		}
		return connection;
	}

	public void disconnect() {

		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				//e.printStackTrace();
				System.out.println("Não fechou "+e.getErrorCode());
			}
		}

		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			} else {
				System.out.println(connection.getClass());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("catch do connection close "+e.getErrorCode());
		}

	}
}
