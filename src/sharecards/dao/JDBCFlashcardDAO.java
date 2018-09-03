package sharecards.dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;


import sharecards.model.*;

public class JDBCFlashcardDAO implements FlashcardDAO{
	/**
	 * Função para inserir flashcard no banco
	 * 
	 * @param f
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public void insereFlashcard(Flashcard f) throws ClassNotFoundException, SQLException {
		
		Connection conexao = new FactoryConnection().getConnection();
	      
	       // cria um preparedStatement
	       String sql = "insert into flashcard (nome_flashcard, frente_flashcard, verso_flashcard, autor_flashcard, categoria_flashcard, imagem_flashcard, codigo_usuario, data_criacao)"
	       + "values (?, ?, ?, ?, ?, ?, ?, ?)";
	    
		   PreparedStatement stmt = conexao.prepareStatement(sql);
		   
		   java.util.Date hoje = new java.util.Date();
		   SimpleDateFormat dataCriacao = new SimpleDateFormat("dd/MM/yyyy");
		   String data = dataCriacao.format(hoje);

	       // preenche os valores
	       stmt.setString(1, f.getNomeFlashcard());
	       stmt.setString(2, f.getFrenteFlashcard());
	       stmt.setString(3, f.getTrasFlashcard());
	       stmt.setString(4, f.getAutorFlashcard());
	       stmt.setString(5, f.getCategoriaFlashcard());
	       stmt.setString(6, f.getImageFlashcard());
	       stmt.setString(7, f.getCodigoUsuario());
	       stmt.setString(8, data);
	       	      
	       // executa
	       stmt.execute();
	       stmt.close();
	       conexao.close();
	}
	
	/**
	 * Função para retirar flashcard do banco
	 * 
	 * 
	 * @param codigoFlashcard
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public int removeFlashcard(String codigoFlashcard) throws ClassNotFoundException, SQLException {
		   
		Connection conexao = new FactoryConnection().getConnection();
	       
	       String sql = "DELETE FROM flashcard WHERE codigo_flashcard=?";  
	       PreparedStatement pstmt = conexao.prepareStatement(sql);  
	         
	       pstmt.setString(1, codigoFlashcard);  
	       int deleteCount = pstmt.executeUpdate(); 
	       
	       //System.out.println("N�mero de flashcards deletados: "+ deleteCount );  
	      
	       conexao.close();
	       
	       return deleteCount;
	}
	
	/**
	 * Função para editarFlashcard no banco de dados
	 * 
	 * @param frente
	 * @param verso
	 * @param codigoFlashcard
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void editarFlashcard(String frenteFlashcard, String trasFlashcard, String codigoFlashcard) throws ClassNotFoundException, SQLException{
		
		Connection conexao = new FactoryConnection().getConnection();
	       
	       String sql = "UPDATE  flashcard  SET frente_flashcard= '?', verso_flashcard='?' WHERE codigoFlashcard='?';"; 
	       
	       PreparedStatement stmt = conexao.prepareStatement(sql); 
	       
	       stmt.setString(1, frenteFlashcard);
	       stmt.setString(2, trasFlashcard);
	       stmt.setString(3, codigoFlashcard);
	       
	       stmt.execute();
	       stmt.close();
	       conexao.close();
	}
	/**
	 * Retorna objeto do tipo flashcard consultando no banco
	 * 
	 * @param u
	 * @param codigoFlashcard
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws UnsupportedEncodingException
	 * @throws ParseException
	 */
	
	/**
	 * Função para mostrar biblioteca de flashcards e usar-los
	 * 
	 * @param usuario
	 * @throws SQLException
	 */
	
	
	
	public ArrayList <Flashcard> obterFlashcard(String codigoUsuario, String codigoFlashcard){
		try {
			Connection conexao = new FactoryConnection().getConnection();
			
			String sql = "select * from flashcard where (codigo_usuario = ?) AND (codigo_flashcard = ?)";
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, codigoUsuario);
			stmt.setString(2, codigoFlashcard);
		                       
            // faz a conexao e executa
		    
            ResultSet rs= stmt.executeQuery();
            ArrayList <Flashcard> lista = new ArrayList<Flashcard>();
            while(rs.next()) {
                Flashcard fc = new Flashcard();
                fc.setCodigoUsuario(rs.getString("codigo_usuario"));
        		fc.setNomeFlashcard(rs.getString("nome_flashcard"));
        		fc.setCategoriaFlashcard(rs.getString("categoria_flashcard"));
        		fc.setImageFlashcard(rs.getString("imagem_flashcard"));
        		fc.setFrenteFlashcard(rs.getString("frente_flashcard"));
        		fc.setTrasFlashcard(rs.getString("verso_flashcard"));
        		fc.setAutorFlashcard(rs.getString("autor_flashcard"));
        		lista.add(fc);
            }
           stmt.close();
 	       conexao.close();
           return lista;
        } catch (SQLException e) {
           e.printStackTrace();
           System.out.println(e.getMessage());
           return null;
        }
	}
	
	public ArrayList <Flashcard> obterDecks(String codigoUsuario){
		try {
			Connection conexao = new FactoryConnection().getConnection();
			
			String sql = "select * from flashcard where codigo_usuario = ?";
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, codigoUsuario);
		                       
            // faz a conexao e executa
		    
            ResultSet rs= stmt.executeQuery();
            ArrayList <Flashcard> lista = new ArrayList<Flashcard>();
            while(rs.next()) {
                Flashcard fc = new Flashcard();
                fc.setCodigoFlashcard(rs.getString("codigo_flashcard"));
                fc.setCodigoUsuario(rs.getString("codigo_usuario"));
        		fc.setNomeFlashcard(rs.getString("nome_flashcard"));
        		fc.setCategoriaFlashcard(rs.getString("categoria_flashcard"));
        		fc.setImageFlashcard(rs.getString("imagem_flashcard"));
        		fc.setFrenteFlashcard(rs.getString("frente_flashcard"));
        		fc.setTrasFlashcard(rs.getString("verso_flashcard"));
        		fc.setAutorFlashcard(rs.getString("autor_flashcard"));
        		lista.add(fc);
            }
           stmt.close();
 	       conexao.close();
           return lista;
           
        } catch (SQLException e) {
           e.printStackTrace();
           System.out.println(e.getMessage());
           return null;
        }
	}
	
	public ArrayList <Flashcard> obterDecksPublicos(){
		try {
			Connection conexao = new FactoryConnection().getConnection();
			
			String sql = "select * from flashcard";
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
		                       
            // faz a conexao e executa
		    
            ResultSet rs= stmt.executeQuery();
            ArrayList <Flashcard> lista = new ArrayList<Flashcard>();
            while(rs.next()) {
                Flashcard fc = new Flashcard();
                fc.setCodigoFlashcard(rs.getString("codigo_flashcard"));
                fc.setCodigoUsuario(rs.getString("codigo_usuario"));
        		fc.setNomeFlashcard(rs.getString("nome_flashcard"));
        		fc.setCategoriaFlashcard(rs.getString("categoria_flashcard"));
        		fc.setImageFlashcard(rs.getString("imagem_flashcard"));
        		fc.setFrenteFlashcard(rs.getString("frente_flashcard"));
        		fc.setTrasFlashcard(rs.getString("verso_flashcard"));
        		fc.setAutorFlashcard(rs.getString("autor_flashcard"));
        		lista.add(fc);
            }
           stmt.close();
 	       conexao.close();
           return lista;
           
        } catch (SQLException e) {
           e.printStackTrace();
           System.out.println(e.getMessage());
           return null;
        }
	}
	
}
