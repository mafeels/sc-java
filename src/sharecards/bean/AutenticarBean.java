package sharecards.bean;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import sharecards.dao.JDBCUsuarioDAO;
import sharecards.dao.UsuarioDAO;
import sharecards.model.Usuario;

@ManagedBean(name="autenticarBean")
public class AutenticarBean {
	
	private String email;
	private String senha;
	
	public String autenticar() throws SQLException{
	
		UsuarioDAO ud = new JDBCUsuarioDAO();
		
		Usuario usuario = ud.validaLogin(email, senha);
		
		FacesContext fc = FacesContext.getCurrentInstance();
		
		
		if (usuario != null) {
			ExternalContext ec = fc.getExternalContext();
			HttpSession session = (HttpSession)ec.getSession(false);
			session.setAttribute("usuario", usuario);
			System.out.println("meme");
			return "dash";
		
		} else {
			FacesMessage mensagem = new FacesMessage("Dados Inválidos");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			return "login";
		}
		
	}
	
	public String registrarSaida(){
		
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(false);
		session.removeAttribute("usuario");
		
		return "login";
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
