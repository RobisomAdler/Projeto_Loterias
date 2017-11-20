package br.com.projeto.lotofacil.dao;

import java.util.List;

import br.com.projeto.lotofacil.beans.JogosLotofacil;
import br.com.projeto.lotofacil.exception.GenericException;

public interface IJogosLotofacil {
	public abstract void salvar(JogosLotofacil jogoLotofacil) throws GenericException;


	public abstract void excluir(String concurso) throws GenericException;

	
	public abstract List getAllJogosLotofacil() throws GenericException;
	
	public abstract List getAllConcursos() throws GenericException;
	
	public abstract JogosLotofacil getJogosLofacilByConcurso(String concurso);

	
}
