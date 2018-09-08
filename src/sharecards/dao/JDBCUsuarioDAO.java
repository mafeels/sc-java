package sharecards.dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.*;
import java.util.Scanner;

import sharecards.dao.FactoryConnection;
import sharecards.model.Usuario;

public class JDBCUsuarioDAO implements UsuarioDAO {
	/**
	 * Função para inserir usuario no banco
	 * 
	 * @param u
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public String insereUsuario(Usuario u) throws ClassNotFoundException, SQLException {
		
		System.out.println(" Abrindo conex�o ... ");
		Connection conexao = new FactoryConnection().getConnection();

		
		// cria um preparedStatement
		String sql = "insert into usuario(primeiro_nome, ultimo_nome, username, data_nascimento, senha, e_mail)	"
				+ "values (?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = conexao.prepareStatement(sql);

		//u.generatorCodeUS();

		// preenche os valores
		stmt.setString(1, u.getPrimeiroNome());
		stmt.setString(2, u.getUltimoNome());
		stmt.setString(3, u.getUsername());
		stmt.setString(4, u.getDataNascimento());
		stmt.setString(5, u.getSenha());
		stmt.setString(6, u.getEmail());

		// executa
		System.out.println(" Executando comando ... ");
		stmt.executeUpdate();
		System.out.println("Fechando conex�o ...");
		stmt.close();
		
    	String cod = null;
//		PreparedStatement pstmt = conexao.prepareStatement("select codigo_usuario FROM usuario WHERE (senha = ?) AND (e_mail = ?)");
//		pstmt.setString(1, u.getSenha());
//		pstmt.setString(2, u.getEmail());
//		ResultSet rs = pstmt.executeQuery();
//		if(rs != null && rs.next()){
//            cod = rs.getString("codigo_usuario");
//        } 
//		pstmt.close();
		conexao.close();
//		
    	return cod; 
		
	}
	/**
	 * Função para deletar usuario do banco de dados
	 * 
	 * @param codigoUsuario
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public int removeUsuario(String codigoUsuario) throws ClassNotFoundException, SQLException{
		Connection conexao = new FactoryConnection().getConnection();

		String sql = "DELETE FROM usuario WHERE codigo_usuario=?";

		PreparedStatement pstmt = conexao.prepareStatement(sql);

		pstmt.setString(1, codigoUsuario);
		int deleteCount = pstmt.executeUpdate();

		// System.out.println("N�mero de flashcards deletados: "+ deleteCount );

		conexao.close();

		return deleteCount;
	}
	/**
	 * Função para consultar usuario
	 * 
	 * @param codigoUsuario
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public ResultSet consultaUsuario(String codigoUsuario) throws ClassNotFoundException, SQLException {
		Connection conexao = new FactoryConnection().getConnection();

		Statement stmt = conexao.createStatement();

		ResultSet rs = stmt.executeQuery("select * from usuario");
		//meme
		return rs;
	}
	/**
	 * Função para fazer login com base em email e senha
	 * 
	 * @param email
	 * @param senha
	 * @return
	 * @throws SQLException
	 */

	public Usuario validaLogin(String email, String senha) throws SQLException {
		try {
			System.out.println ("Abrindo conex�o ...");
			Connection conexao = new FactoryConnection().getConnection();
			
			String sql = "select * FROM usuario WHERE e_mail = ? AND senha = ? ;";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setString(1, email);
			comando.setString(2, senha);
			
			System.out.println("Executando comando ...");
			ResultSet resultado = comando.executeQuery();
			
			Usuario user = null;
			
			while (resultado.next()) {
				user = new Usuario();
				user.setCodigoUsuario(resultado.getString("codigo_usuario"));
				user.setDataNascimento(resultado.getString("data_nascimento"));
				user.setPrimeiroNome(resultado.getString("primeiro_nome"));
				user.setUltimoNome(resultado.getString("ultimo_nome"));
				user.setUsername(resultado.getString("username"));
				user.setEmail(resultado.getString("e_mail"));
				user.setSenha(resultado.getString("senha"));	
		    }
			
			System.out.println("\n Fechando conex�o ... ");
			conexao.close();
			
			return user;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	/**
	 *  Função que retorna objeto do tipo usuario a partir de uma pesquisa no banco
	 *  
	 * @param email
	 * @param senha
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws UnsupportedEncodingException
	 */

	public Usuario retornaUsuario(String email, String senha) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException{
		Connection conexao = new FactoryConnection().getConnection();

		PreparedStatement stmt = conexao.prepareStatement("select * from usuario where (senha = '?') AND (e_mail = '?')");

		stmt.setString(1, senha);
		stmt.setString(2, email);
		
		ResultSet rs = stmt.executeQuery();
		
		Usuario u = new Usuario(rs.getNString("primeiro_nome"), rs.getNString("ultimo_nome"), rs.getNString("username"), rs.getNString("data_nascimento"), email);

		return u;
	}
	/**
	 * Função para alterar senha do usuario no banco
	 * 
	 * @param email
	 * @param senha
	 * @throws SQLException
	 */
	public void alteraSenha(String email, String senha) throws SQLException {
		Connection conexao = new FactoryConnection().getConnection();

		PreparedStatement stmt = conexao.prepareStatement("update usuario set senha = '?' where e_mail = '?'");

		stmt.setString(1, senha);
		stmt.setString(2, email);
		
		stmt.execute();
		stmt.close();
		conexao.close();
	}
	/**
	 * Função void para mostrar perfil usuario e talvez trocar senha
	 * 
	 * @param u
	 * @throws SQLException
	 */
	/*
	 * public void mostrarPerfil(Usuario u) throws SQLException {	
		Scanner in = new Scanner("System.in");
		
		System.out.println("Nome: "+ u.getPrimeiroNome() + " " + u.getUltimoNome());
		System.out.println("username: " + u.getUsername());
		System.out.println("Data de Nascimento: " + u.getDataNascimento());
		System.out.println("Email: " + u.getEmail());
		System.out.println("1 - Alterar senha");
		System.out.println("2 - Sair");
		System.out.println("Resp.: ");
		int i = in.nextInt();
		boolean valida = false;
		
		do{
			switch(i) {
				case 1:
					valida = true;
					break;
				case 2:
					
					JDBCUsuarioDAO usuarioDao = new JDBCUsuarioDAO();
					
					System.out.println("Senha Atual: ");
					String senhaAtual = in.nextLine();
					System.out.println("Senha Nova: ");
					String senhaNova = in.nextLine();
					
					boolean p = usuarioDao.validaLogin(u.getEmail(), senhaAtual);
					
					if(p){
						usuarioDao.alteraSenha(u.getEmail(), senhaNova);
						valida = true;
					}else{
						boolean valida1 = false;
						
						do{
							System.out.println("Senha errada");
							System.out.println("1 - Desistir");
							System.out.println("2 - Tentar denovo");
							int resp = in.nextInt();
							
							switch(resp) {
								case 1:
									valida = true;
									valida1 = true;
									break;
								case 2:
									valida = false;
									valida1 = true;
									break;
								default:
									System.out.println("DIGITE UMA DAS OPÇÕES");
							}
						}while(valida1);
					}
					
					break;
				default:
					System.out.println("DIGITE UMA DAS OPÇÕES");
			}
		
		}while(valida);
		
	}*/
	public String retornaCodigoUsuario(String email, String senha) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException{
		Connection conexao = new FactoryConnection().getConnection();

		PreparedStatement stmt = conexao.prepareStatement("select codigo_usuario from usuario where (senha = '?') AND (e_mail = '?')");

		stmt.setString(1, senha);
		stmt.setString(2, email);
		
		ResultSet rs = stmt.executeQuery();
		
		String cod = rs.getNString("codigo_usuario");

		return cod;
	}
	
}
