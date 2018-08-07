package sharecards.model;

import java.io.UnsupportedEncodingException;
//import java.math.BigInteger;
//import java.security.MessageDigest;
//import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;




public class Usuario {
	protected String codigoUsuario, username, dataNascimento, senha, email, primeiroNome, ultimoNome;
	/**
	 * Construtor vazio
	 */
	public Usuario(){
		
	}
	/**
	 * Construtor principal
	 * 
	 * @param primeiroNome
	 * @param ultimoNome
	 * @param username
	 * @param dataNascimento
	 * @param senha
	 * @param email
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws UnsupportedEncodingException
	 */
	public Usuario(String primeiroNome, String ultimoNome, String username, String dataNascimento, String senha, String email) throws NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException{
		this.username = username;
		this.dataNascimento = dataNascimento;
		this.senha = senha;
		this.email = email;
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
	}
	/**
	 * Construtor secundario sem senha
	 * 
	 * @param primeiroNome
	 * @param ultimoNome
	 * @param username
	 * @param dataNascimento
	 * @param email
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws UnsupportedEncodingException
	 */
	public Usuario(String primeiroNome, String ultimoNome, String username, String dataNascimento, String email) throws NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException{
		this.username = username;
		this.dataNascimento = dataNascimento;
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.email = email;
	}
	/**
	 * Função para pegar codigo do usuario
	 * 
	 * @return
	 */
	public String getCodigoUsuario() {
		return codigoUsuario;
	}
	/**
	 * Função para definir codigo do usuario
	 * 
	 * @param codigoUsuario
	 */
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	/**
	 * Função para pegar username
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Função para definir username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * Função para pegar data de nascimento do usuario
	 * 
	 * @return
	 */
	public String getDataNascimento() {
		return dataNascimento;
	}
	/**
	 * Função para definir data de nascimento
	 * 
	 * @param dataNascimento
	 */
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	/**
	 * Função para pegar senha
	 * 
	 * @return
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * Função para definir senha
	 * 
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	/**
	 * Função para pegar email
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Função para definir email
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Função para definir codigo de usuario
	 * 
	 */
	/*
	public void generatorCodeUS() {
		codigoUsuario = new BigInteger(130, random).toString(32);
	}*/
	/**
	 * Função para checar username
	 * 
	 * @param username
	 * @return
	 */
	/* 
	public boolean checkUsername(String username) {
		if(username == this.username) {
			return true;
		}
		return false;
	} */
	/**
	 * Função para checar senha
	 * @param senha
	 * @return
	 */
	/* public boolean checkSenha(String senha) {
		if(senha == this.senha) {
			return true;
		}
		return false;
	} */
	/**
	 * Função para pegar primeiro nome
	 * 
	 * @return
	 */
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	/**
	 * Função para definir primeiro nome
	 * 
	 * @param primeiroNome
	 */
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	/**
	 * Função para pegar ultimo nome
	 * 
	 * @return
	 */
	public String getUltimoNome() {
		return ultimoNome;
	}
	/**
	 * Função para definir ultimo nome
	 * 
	 * @param ultimoNome
	 */
	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}
	/**
	 * Função para criptografar senha
	 * 
	 * @param senha
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws UnsupportedEncodingException
	 */
	/* protected static String criptografarSenha(String senha) throws NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException{
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
		 
		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
		  hexString.append(String.format("%02X", 0xFF & b));
		}
		
		return hexString.toString();
	} */
}
