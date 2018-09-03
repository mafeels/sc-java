package sharecards.bean;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import sharecards.dao.FlashcardDAO;
import sharecards.dao.JDBCFlashcardDAO;
import sharecards.model.Flashcard;
import sharecards.model.Usuario;

@ManagedBean(name = "flashcardBean")
public class FlashcardBean {
	
	private String nomeFlashcard, categoriaFlashcard, frenteFlashcard, trasFlashcard, imageFlashcard, codigoFlashcard,
	 codigoUsuario, autorFlashcard;
	//FlashcardDAO fc= new JDBCFlashcardDAO();
	private ArrayList<Flashcard> dados; //= fc.obterFlashcard();
	
	public FlashcardBean(){
		
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(false);
		Usuario us = (Usuario) session.getAttribute("usuario");
		this.codigoUsuario = us.getCodigoUsuario();
		this.autorFlashcard = us.getUsername();
		FlashcardDAO decks = new JDBCFlashcardDAO();
		this.dados = decks.obterDecks(us.getCodigoUsuario());
		
	}
	
	public String obterDeckPublicos() {
		FlashcardDAO decks = new JDBCFlashcardDAO();
		this.dados = decks.obterDecksPublicos();
		return "biblioteca";
	}
	
	public void insereFlashcard() throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException{
		Flashcard flash = new Flashcard();
		flash.setCodigoUsuario(codigoUsuario);
		flash.setNomeFlashcard(nomeFlashcard);
		flash.setCategoriaFlashcard(categoriaFlashcard);
		flash.setImageFlashcard(imageFlashcard);
		flash.setFrenteFlashcard(frenteFlashcard);
		flash.setTrasFlashcard(trasFlashcard);
		flash.setAutorFlashcard(autorFlashcard);
		
		FlashcardDAO edFl = new JDBCFlashcardDAO();
		edFl.insereFlashcard(flash);
	}
	
	public int removeFlashcard() throws ClassNotFoundException, SQLException{
		FlashcardDAO edFl = new JDBCFlashcardDAO();
		int deletCount = edFl.removeFlashcard(codigoFlashcard);
		return deletCount;
		
	}
	
	public String consultaFlashcard(Flashcard fl) throws ClassNotFoundException, SQLException{
		this.codigoFlashcard = fl.getCodigoFlashcard();
		this.nomeFlashcard = fl.getNomeFlashcard();
		this.autorFlashcard = fl.getAutorFlashcard();
		this.categoriaFlashcard = fl.getCategoriaFlashcard();
		this.frenteFlashcard = fl.getFrenteFlashcard();
		this.imageFlashcard = fl.getImageFlashcard();
		this.trasFlashcard = fl.getTrasFlashcard();
		return "dashFlash";
	}
	
	public void editarFlashcard() throws ClassNotFoundException, SQLException{
		FlashcardDAO edFl = new JDBCFlashcardDAO();
		edFl.editarFlashcard(frenteFlashcard, trasFlashcard, codigoFlashcard);
	}
	
//	public Flashcard retornaFlashcard() throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException, ParseException{
//		FlashcardDAO edFl = new JDBCFlashcardDAO();
//		Flashcard fl = edFl.retornaFlashcard(codigoUsuario,codigoFlashcard);
//		return fl;
//	}
	
	public String pegarDados(){
		FlashcardDAO edFl = new JDBCFlashcardDAO();
		this.dados = edFl.obterFlashcard(codigoUsuario,codigoFlashcard);
		return "respostaFlashcard";
	}

	public String getNomeFlashcard() {
		return nomeFlashcard;
	}

	public void setNomeFlashcard(String nomeFlashcard) {
		this.nomeFlashcard = nomeFlashcard;
	}

	public String getCategoriaFlashcard() {
		return categoriaFlashcard;
	}

	public void setCategoriaFlashcard(String categoriaFlashcard) {
		this.categoriaFlashcard = categoriaFlashcard;
	}

	public String getFrenteFlashcard() {
		return frenteFlashcard;
	}

	public void setFrenteFlashcard(String frenteFlashcard) {
		this.frenteFlashcard = frenteFlashcard;
	}

	public String getTrasFlashcard() {
		return trasFlashcard;
	}

	public void setTrasFlashcard(String trasFlashcard) {
		this.trasFlashcard = trasFlashcard;
	}

	public String getImageFlashcard() {
		return imageFlashcard;
	}

	public void setImageFlashcard(String imageFlashcard) {
		this.imageFlashcard = imageFlashcard;
	}

	public String getCodigoFlashcard() {
		return codigoFlashcard;
	}

	public void setCodigoFlashcard(String codigoFlashcard) {
		this.codigoFlashcard = codigoFlashcard;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getAutorFlashcard() {
		return autorFlashcard;
	}

	public void setAutorFlashcard(String autorFlashcard) {
		this.autorFlashcard = autorFlashcard;
	}

	public void setDados(ArrayList<Flashcard> dados) {
		this.dados = dados;
	}

	public ArrayList<Flashcard> getDados() {
		return dados;
	}
	
	/*public void mostrarBiblioteca(Usuario usuario) throws SQLException{
		
	}*/
}
