package sharecards.dao;


import java.sql.Connection;
import java.sql.DriverManager;
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
		String stringDeConexao = "jdbc:mysql://localhost:3306/flashnotes?autoReconnect=true&useSSL=false";
		String usuario = "root";
		String senha = "ifsp";
		
		Connection conexao = null ;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver"); 
			conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conexao ;
	}
}
