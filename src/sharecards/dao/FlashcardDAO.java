package sharecards.dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import sharecards.model.Flashcard;
import sharecards.model.Usuario;

public interface FlashcardDAO {

	public void insereFlashcard(Flashcard f) throws ClassNotFoundException, SQLException;
	
	public int removeFlashcard(String codigoFlashcard) throws ClassNotFoundException, SQLException;
	
	public void editarFlashcard(String frente, String verso, String codigoFlashcard) throws ClassNotFoundException, SQLException;
	
	public ArrayList <Flashcard> obterFlashcard(String codigoUsuario, String codigoFlashcard);
	
	public ArrayList <Flashcard> obterDecks(String codigoUsuario);
	
	public ArrayList <Flashcard> obterDecksPublicos();
	
}
