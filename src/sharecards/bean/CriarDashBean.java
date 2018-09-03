package sharecards.bean;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.CachedResultSetMetaData;

import sharecards.dao.JDBCUsuarioDAO;
import sharecards.dao.UsuarioDAO;
import sharecards.model.Usuario;

@ManagedBean(name="criarDashBean")
public class CriarDashBean {
	
	private String codigoUsuario, username, dataNascimento, senha, email, primeiroNome, ultimoNome;
	private String nomeFlashcard, categoriaFlashcard, frenteFlashcard, trasFlashcard, imageFlashcard, codigoFlashcard, autorFlashcard;
	
	public CriarDashBean (){
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(false);
		Usuario us = (Usuario) session.getAttribute("usuario");
		this.username = us.getUsername();
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
	
}