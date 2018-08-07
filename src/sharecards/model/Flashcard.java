package sharecards.model;

import java.sql.Date;


public class Flashcard {

	protected String nomeFlashcard, categoriaFlashcard, frenteFlashcard, trasFlashcard, imageFlashcard, codigoFlashcard,
		 codigoUsuario, autorFlashcard;
	
	//coment
	Date dataCriacao;
	/**
	 * Função construtora principal
	 * 
	 * @param nomeFlashcard
	 * @param categoriaFlashcard
	 * @param frenteFlashcard
	 * @param trasFlashcard

	 * @param autorFlashcard
	 * @param dataCriacao
	 * @param imageFlashcard

	 */
	public Flashcard(){}
	
	public Flashcard(String nomeFlashcard, String categoriaFlashcard, String frenteFlashcard, String trasFlashcard,
			String autorFlashcard, Date dataCriacao, String imageFlashcard) {
		this.nomeFlashcard = nomeFlashcard;
		this.categoriaFlashcard = categoriaFlashcard;
		this.frenteFlashcard = frenteFlashcard;
		this.trasFlashcard = trasFlashcard;
		this.autorFlashcard = autorFlashcard;
		this.dataCriacao = dataCriacao;
		this.imageFlashcard = imageFlashcard;
	}
	/**
	 * Função construtora secundaria
	 * 
	 * @param nomeFlashcard
	 * @param categoriaFlashcard
	 * @param frenteFlashcard
	 * @param trasFlashcard

	 * @param autorFlashcard
	 * @param date
	 */
	public Flashcard(String nomeFlashcard, String categoriaFlashcard, String frenteFlashcard, String trasFlashcard,
			String autorFlashcard, Date date) {
		this.nomeFlashcard = nomeFlashcard;
		this.categoriaFlashcard = categoriaFlashcard;
		this.frenteFlashcard = frenteFlashcard;
		this.trasFlashcard = trasFlashcard;
		this.autorFlashcard = autorFlashcard;
		this.dataCriacao = date;

	}
	/**
	 *  Função para pegar nome do flashcard
	 *  
	 * @return
	 */

	public String getNomeFlashcard() {
		return nomeFlashcard;
	}
	/**
	 * Função para definir nome do flashcard
	 * 
	 * @param nomeFlashcard
	 */

	public void setNomeFlashcard(String nomeFlashcard) {
		this.nomeFlashcard = nomeFlashcard;
	}
	/**
	 * Função para pegar categoria do flashcard
	 * 
	 * @return
	 */

	public String getCategoriaFlashcard() {
		return categoriaFlashcard;
	}
	
	/**
	 * Função para definir categoria do flashcard
	 * 
	 * @param categoriaFlashcard
	 */
	public void setCategoriaFlashcard(String categoriaFlashcard) {
		this.categoriaFlashcard = categoriaFlashcard;
	}
	/**
	 * Função para pegar frente do flashcard
	 * 
	 * @return
	 */
	public String getFrenteFlashcard() {
		return frenteFlashcard;
	}
	/**
	 * Função para definir frente do flashcard
	 * 
	 * @param frenteFlashcard
	 */
	public void setFrenteFlashcard(String frenteFlashcard) {
		this.frenteFlashcard = frenteFlashcard;
	}
	/**
	 * Função para pegar verso do flashcard
	 * 
	 * @return
	 */

	public String getTrasFlashcard() {
		return trasFlashcard;
	}
	/**
	 * Função para definir verso do flashcard
	 * 
	 * @param trasFlashcard
	 */

	public void setTrasFlashcard(String trasFlashcard) {
		this.trasFlashcard = trasFlashcard;
	}
	/**
	 * Função para pegar caminho da imagem do flashcard
	 * 
	 * @return
	 */
	public String getImageFlashcard() {
		return imageFlashcard;
	}
	/**
	 * Função para definir caminho da imagem do flashcard
	 * 
	 * @param imageFlashcard
	 */

	public void setImageFlashcard(String imageFlashcard) {
		this.imageFlashcard = imageFlashcard;
	}
	/**
	 * Função para pegar preço do flashcard
	 * 
	 * @return
	 */

	public String getCodigoFlashcard() {
		return codigoFlashcard;
	}
	/**
	 * função para definir codigo do flashcard
	 * 
	 * @param codigoFlashcard
	 */

	public void setCodigoFlashcard(String codigoFlashcard) {
		this.codigoFlashcard = codigoFlashcard;
	}
	/**
	 * função para pegar codigo do usuario
	 * 
	 * @return
	 */
	public String getCodigoUsuario() {
		return codigoUsuario;
	}
	/**
	 * função para definir codigo de usuario
	 * 
	 * @param codigoUsuario
	 */
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	/**
	 * Função para editar nome do flashcard
	 * 
	 * @param novoNomeFlashcard
	 */
	
	public void editNome(String novoNomeFlashcard){
		this.nomeFlashcard = novoNomeFlashcard;
	}
	/**
	 * função para pegar autor do flashcard
	 * 
	 * @return
	 */
	public String getAutorFlashcard() {
		return autorFlashcard;
	}
	/**
	 * Função para definir autor do flashcard
	 * 
	 * @param autorFlashcard
	 */
	public void setAutorFlashcard(String autorFlashcard) {
		this.autorFlashcard = autorFlashcard;
	}
	/**
	 * Função que retorna data de criação
	 * 
	 * @return
	 */
	public Date getDataCriacao() {
		return dataCriacao;
	}
	/**
	 * Função para definir data de criação
	 */
	public void setDataCriacao(java.util.Date date) {
		this.dataCriacao = (Date) date;
	}

}