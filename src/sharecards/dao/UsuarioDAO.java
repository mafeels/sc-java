package sharecards.dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.ResultSet;
import java.sql.SQLException;

import sharecards.model.Usuario;

public interface UsuarioDAO {

		public String insereUsuario(Usuario u) throws ClassNotFoundException, SQLException;
		
		public int removeUsuario(String codigoUsuario) throws ClassNotFoundException, SQLException;
		
		public ResultSet consultaUsuario(String codigoUsuario) throws ClassNotFoundException, SQLException;
		
		public Usuario validaLogin(String email, String senha) throws SQLException;
		
		public Usuario retornaUsuario(String email, String senha) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException;
		
		public void alteraSenha(String email, String senha) throws SQLException;
		
		//public void mostrarPerfil(Usuario u) throws SQLException;
		
		public String retornaCodigoUsuario(String email, String senha) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException;
}
