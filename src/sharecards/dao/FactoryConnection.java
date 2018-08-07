package sharecards.dao;


import java.sql.Connection;
import java.sql.SQLException;

/**
 * Essa classe retorna uma conex�o com o banco de dados por meio da utliza��o do
 * mysql connector
 */
public class FactoryConnection {
	/**
	 * Esse m�todo cria e retorna a conex�o
	 * 
	 * @return retorna um objeto do tipo Connection
	 */
	public Connection getConnection() {
		Connection conexao = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = (Connection) java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/flashnotes?autoReconnect=true&useSSL=false",
					"root", "ifsp");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conexao;
	}
	
}
