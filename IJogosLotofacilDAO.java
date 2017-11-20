/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * Esta e uma interface que especifica metodos para obten�ao e armazenamento de clientes,
 * nao importando onde estes objetos serao persistidos, ex: arquivo, collections, 
 * banco de dados, etc...
 * 
 */
package br.com.projeto.lotofacil.dao;

import java.util.List;

import br.com.projeto.lotofacil.beans.JogosLotofacil;
import br.com.projeto.lotofacil.exception.GenericException;

public interface IJogosLotofacilDAO {

	
	public abstract void salvar(JogosLotofacil jogoLotofacil) throws GenericException;


	public abstract void excluir(String concurso) throws GenericException;

	
	public abstract List getAllJogosLotofacil() throws GenericException;
	
	public abstract JogosLotofacil getJogosLofacilByConcurso(String concurso) throws GenericException;

}	