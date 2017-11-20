package br.com.projeto.lotofacil.exception;

/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 */
public class GenericException extends Exception {

	public GenericException(String mensagem, Exception e) {
		super(mensagem, e);
	}

	public GenericException(String mensagem) {
		super(mensagem);
	}
}
