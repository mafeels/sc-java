package sharecards.bean;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import sharecards.dao.FlashcardDAO;
import sharecards.dao.JDBCFlashcardDAO;
import sharecards.model.Flashcard;

@ManagedBean(name = "flashcardBean")
public class FlashcardBean {
	
	private String nomeFlashcard, categoriaFlashcard, frenteFlashcard, trasFlashcard, imageFlashcard, codigoFlashcard,
	 codigoUsuario, autorFlashcard;
	//FlashcardDAO fc= new JDBCFlashcardDAO();
	private ArrayList<Flashcard> dados; //= fc.obterFlashcard();
	
	
	public void insereFlashcard() throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException{
		Flashcard flash = new Flashcard();
		UsuarioBean ub = new UsuarioBean();
		flash.setCodigoUsuario(ub.getCodigoUsuario());
		flash.setNomeFlashcard(nomeFlashcard);
		flash.setCategoriaFlashcard(categoriaFlashcard);
		flash.setImageFlashcard(imageFlashcard);
		flash.setFrenteFlashcard(frenteFlashcard);
		flash.setTrasFlashcard(trasFlashcard);
		flash.setAutorFlashcard(autorFlashcard);
		
		FlashcardDAO edFl = new JDBCFlashcardDAO();
		edFl.insereFlashcard(flash);
	}
	
	public void insereFlashcardSemIMG() throws ClassNotFoundException, SQLException{
		Flashcard flash = new Flashcard();
		UsuarioBean ub = new UsuarioBean();
		flash.setCodigoUsuario(ub.getCodigoUsuario());
		flash.setNomeFlashcard(nomeFlashcard);
		flash.setCategoriaFlashcard(categoriaFlashcard);
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
	
	public ResultSet consultaFlashcard() throws ClassNotFoundException, SQLException{
		FlashcardDAO edFl = new JDBCFlashcardDAO();
		ResultSet rs = edFl.consultaFlashcard(codigoFlashcard);
		return rs;
	}
	
	public void editarFlashcard() throws ClassNotFoundException, SQLException{
		FlashcardDAO edFl = new JDBCFlashcardDAO();
		edFl.editarFlashcard(frenteFlashcard, trasFlashcard, codigoFlashcard);
	}
	
	public Flashcard retornaFlashcard() throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException, ParseException{
		FlashcardDAO edFl = new JDBCFlashcardDAO();
		Flashcard fl = edFl.retornaFlashcard(codigoUsuario,codigoFlashcard);
		return fl;
	}
	
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
