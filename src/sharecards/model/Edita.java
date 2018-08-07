package sharecards.model;


public class Edita {
	protected String dataEdita, codigoUsuario, codigoFlashcard;
	/**
	 * Construtor
	 * 
	 * @param codigoUsuario
	 * @param codigoFlashcard
	 */
	public Edita(String codigoUsuario, String codigoFlashcard) {
		this.codigoUsuario = codigoUsuario;
		this.codigoFlashcard = codigoFlashcard;
		this.dataEdita = java.time.Instant.now().toString();
	}
	/**
	 * Função para pegar data da edição
	 * 
	 * @return
	 */
	public String getDataEdita() {
		return dataEdita;
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
	 * Função para definir codigo do usuarip
	 * 
	 * @param codigoUsuario
	 */
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	/**
	 * Função para pegar codigo do flashcard dentro de objeto edita
	 * 
	 * @return
	 */
	public String getCodigoFlashcard() {
		return codigoFlashcard;
	}
	/**
	 * Função para definir codigo do flashcard dentro de objeto edita
	 * 
	 * @param codigoFlashcard
	 */
	public void setCodigoFlashcard(String codigoFlashcard) {
		this.codigoFlashcard = codigoFlashcard;
	}
	
}
