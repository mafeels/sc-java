package visao.old;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.SQLException;
import java.util.*;

import sharecards.dao.JDBCFlashcardDAO;
import sharecards.dao.JDBCUsuarioDAO;
import sharecards.model.*;

import java.sql.Date;

/*
public class Principal {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException {
		Scanner in = new Scanner(System.in);
		int entrada;
		
		do{
			System.out.println("1 - Criar Conta");
			System.out.println("2 - Fazer Login");
			entrada = in.nextInt();
			
			String primeiroNome, ultimoNome, username, email, senha, dataNascimento;
			JDBCUsuarioDAO usuarioDao = new JDBCUsuarioDAO();
			JDBCFlashcardDAO flashcardDAO = new JDBCFlashcardDAO();
			
			switch(entrada){
				case 1:
					Usuario sessao1;
					/// coment
					System.out.println("Primeiro Nome: ");
					primeiroNome = in.nextLine();
					System.out.println("Ultimo Nome: ");
					ultimoNome = in.nextLine();
					System.out.println("username: ");
					username = in.nextLine();
					System.out.println("email: ");
					email = in.nextLine();
					System.out.println("senha: ");
					senha = in.nextLine();
					System.out.println("Data de nascimento: ");
					dataNascimento = in.nextLine();
					
					sessao1 = new Usuario(primeiroNome, ultimoNome, username, dataNascimento, senha, email);
					
					
					usuarioDao.insereUsuario(sessao1);
					
					break;
				case 2:
					
					boolean valida = false;
					
					do {
					System.out.println("email: ");
					email = in.nextLine();
					System.out.println("senha: ");
					senha = in.nextLine();
					
					valida = usuarioDao.validaLogin(email, senha);
					
					sessao1 = usuarioDao.retornaUsuario(email, senha);
					
					}while(valida);
					
					valida = false;
					
					do {
						System.out.println("Opções");
						System.out.println("1 - Mostrar Biblioteca de Flashcards");
						System.out.println("2 - Criar Flashcard");
						System.out.println("3 - Mostrar Perfil");
						System.out.println("4 - Sair");
						int opcao = in.nextInt();
						
						switch(opcao) {
							case 1:
								flashcardDAO.mostrarBiblioteca(sessao1);
								break;
							case 2:
								System.out.println("Titulo: ");
								String titulo = in.nextLine();
								System.out.println("Frente: ");
								String frente = in.nextLine();
								System.out.println("Verso: ");
								String verso = in.nextLine();
								System.out.println("Categoria: ");
								String categoria = in.nextLine();
								
								java.util.Date dataUtil = new java.util.Date();
								java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
								
								Flashcard flashcard = new Flashcard(titulo, categoria, frente, verso, sessao1.getCodigoUsuario(), dataSql, "imagem");
								
								flashcardDAO.insereFlashcard(flashcard);
								
								break;
							case 3:
								usuarioDao.mostrarPerfil(sessao1);
								break;
							case 4:
								valida = true;
								break;
							default:
								System.out.println("DIGITE UMA DAS OPÇÕES");
						}					
					}while(valida);
					
					break;
				default:
					System.out.println("DIGITE UMA DAS OPÇÕES");
			
			}
		}while(entrada != 2);

	}
}
*/
