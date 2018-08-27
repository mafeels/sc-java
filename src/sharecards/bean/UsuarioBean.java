package sharecards.bean;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import sharecards.dao.JDBCUsuarioDAO;
import sharecards.dao.UsuarioDAO;
import sharecards.model.Usuario;

@ManagedBean(name="usuarioBean")
public class UsuarioBean {

	private String codigoUsuario, username, dataNascimento, senha, email, primeiroNome, ultimoNome;
	
	public String insereUsuario() throws ClassNotFoundException, SQLException{
		Usuario us = new Usuario();
		us.setUsername(username);
		us.setEmail(email);
		us.setDataNascimento(dataNascimento);
		us.setSenha(senha);
		us.setPrimeiroNome(primeiroNome);
		us.setUltimoNome(ultimoNome);
		
		UsuarioDAO edUs = new JDBCUsuarioDAO();
		this.codigoUsuario = edUs.insereUsuario(us);
		
		return "dash";
	} 
	
	public int removeUsuario() throws ClassNotFoundException, SQLException{
		UsuarioDAO edUs = new JDBCUsuarioDAO();
		int deletCount = edUs.removeUsuario(codigoUsuario);
        return deletCount;
	}

	public ResultSet consultaUsuario() throws ClassNotFoundException, SQLException{
		UsuarioDAO edUs = new JDBCUsuarioDAO();
		ResultSet rs = edUs.consultaUsuario(codigoUsuario);
		return rs;
	}

	public Usuario retornaUsuario() throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException{
		UsuarioDAO edUs = new JDBCUsuarioDAO();
		Usuario rUser = edUs.retornaUsuario(email, senha);
		return rUser;
	}
	
	public void alteraSenha() throws SQLException{
		UsuarioDAO edUs = new JDBCUsuarioDAO();
		edUs.alteraSenha(email, senha);
	}

	public String retornaCodigoUsuario() throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException{
		UsuarioDAO edUs = new JDBCUsuarioDAO();
		return edUs.retornaCodigoUsuario(email, senha);
	} 
	
	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	// Método para ser analisado posteriormente
	/*public void mostrarPerfil() throws SQLException{
		UsuarioDAO edUs = new JDBCUsuarioDAO();
		edUs.mostrarPerfil();
	}*/
}
