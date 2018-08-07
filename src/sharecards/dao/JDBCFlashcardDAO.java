package sharecards.dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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
	       String sql = "insert into flashcard (nome_flashcard, frente_flashcard, verso_flashcard, autor_flashcard, categoria_flashcard, data_criacao, imagem_flashcard)"
	       + "values (?, ?, ?, ?, ?, ?, ?)";
	    
		   PreparedStatement stmt = conexao.prepareStatement(sql);

	       // preenche os valores
	       stmt.setString(1, f.getNomeFlashcard());
	       stmt.setString(2, f.getFrenteFlashcard());
	       stmt.setString(3, f.getTrasFlashcard());
	       stmt.setString(4, f.getAutorFlashcard());
	       stmt.setString(5, f.getCategoriaFlashcard());
	       stmt.setString(6, f.getDataCriacao().toString());
	       stmt.setString(7, f.getImageFlashcard());	       
	       	      
	       // executa
	       stmt.execute();
	       stmt.close();
	       conexao.close();
	}
	
	public void insereFlashcardSemIMG(Flashcard f) throws ClassNotFoundException, SQLException {
		
		Connection conexao = new FactoryConnection().getConnection();
	      
	       // cria um preparedStatement
	       String sql = "insert into flashcard (nome_flashcard, frente_flashcard, verso_flashcard, autor_flashcard, categoria_flashcard, data_criacao)"
	       + "values (?,?,?,?,?,?)";
	    
		   PreparedStatement stmt = conexao.prepareStatement(sql);

	       // preenche os valores
	       stmt.setString(1, f.getNomeFlashcard());
	       stmt.setString(2, f.getFrenteFlashcard());
	       stmt.setString(3, f.getTrasFlashcard());
	       stmt.setString(4, f.getAutorFlashcard());
	       stmt.setString(5, f.getCategoriaFlashcard());
	       stmt.setString(6, f.getDataCriacao().toString());	       
	       	      
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
	 * Função para consultar flashcard em banco com base no codigo
	 * 
	 * @param codigoFlashcard
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ResultSet consultaFlashcard(String codigoFlashcard) throws ClassNotFoundException, SQLException {
		Connection conexao = new FactoryConnection().getConnection();
		
	       String sql = "select * from flashcard";
	       
	       Statement stmt = conexao.createStatement();
	                       
	       ResultSet rs = stmt.executeQuery(sql);
	        
	       return rs;
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
	public Flashcard retornaFlashcard(String codigoUsuario, String codigoFlashcard) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException, ParseException{
		Connection conexao = new FactoryConnection().getConnection();

		PreparedStatement stmt = conexao.prepareStatement("select * from flashcard where (codigo_usuario = '?') AND (codigo_flashcard = '?')");

		stmt.setString(1, codigoUsuario);
		stmt.setString(2, codigoFlashcard);
		
		ResultSet rs = stmt.executeQuery();
		
		DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		Date date = (Date)formatter.parse(rs.getNString("data_criacao"));
		
		Flashcard flashcard = new Flashcard(rs.getNString("nome_flashcard"), rs.getNString("categoria_flashcard"), rs.getNString("frente_flashcard"), rs.getNString("verso_flashcard"), rs.getNString("codigo_usuario"), date);
		
		return flashcard;
	}
	/**
	 * Função para mostrar biblioteca de flashcards e usar-los
	 * 
	 * @param usuario
	 * @throws SQLException
	 */
	
	public void mostrarBiblioteca(Usuario usuario) throws SQLException{
		Connection conexao = new FactoryConnection().getConnection();
		
		String sql = "select * from flashcard where codigo_usuario = '?'";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setString(1, usuario.getCodigoUsuario());
		
		ResultSet rs = stmt.executeQuery();
		
		int i = 0;
		String[] codigos = new String[100];
		
		while(rs.next()) {
			i++;
			String nome = rs.getString("nome_flashcard");
			System.out.println(i +" - "+nome);
			codigos[i] = rs.getString("codigo_flashcard");
		}
		
		i++;
		
		System.out.println(i +" - Sair");
		
		System.out.println("Escolha um Flashcard: ");
		Scanner in = new Scanner("System.in");
		int opcao = in.nextInt();
		
		rs.first();
		
		if(opcao != i){
			int j = 0;
			while(rs.next() && j<= opcao) {
				j++;	
			}
			System.out.println("Frente: ");
			System.out.println(rs.getNString("frente_flashcard"));
			System.out.println("Mostrar verso: ");
			in.nextLine();
			System.out.println("Verso: ");
			System.out.println(rs.getNString("verso_flashcard"));
		}
		
	}
	
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
	
}
