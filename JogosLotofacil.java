/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 */
package br.com.projeto.lotofacil.beans;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto.lotofacil.dao.IJogosLotofacil;
import br.com.projeto.lotofacil.exception.GenericException;

public class JogosLotofacil implements IJogosLotofacil{

	private String concurso;
	private ArrayList<String> numeros;
	private String data;
	private String numero;
	private JogosLotofacil jogoLotofacil;
	

	public JogosLotofacil(String concurso, ArrayList<String> numeros, String data) {
		this.setConcurso(concurso);
		this.setNumeros(numeros);
		this.setData(data);
	}


	

	/**
	 * @return the concurso
	 */
	public String getConcurso() {
		return concurso;
	}


	/**
	 * @param concurso the concurso to set
	 */
	public void setConcurso(String concurso) {
		this.concurso = concurso;
	}


	/**
	 * @return the numeros
	 */
	public ArrayList<String> getNumeros() {
		return numeros;
	}
	
	public String getUmNumero() {
		
		return numero;
	}


	/**
	 * @param numeros the numeros to set
	 */
	public void setNumeros(ArrayList<String> numeros) {
		
		this.numeros = numeros;
	}


	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}


	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}


	@Override
	public void salvar(JogosLotofacil jogoLotofacil) throws GenericException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void excluir(String concurso) throws GenericException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List getAllJogosLotofacil() throws GenericException {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List getAllConcursos() throws GenericException {
		// TODO Auto-generated method stub
		return (List) jogoLotofacil;
	}




	@Override
	public JogosLotofacil getJogosLofacilByConcurso(String concurso) {
		// TODO Auto-generated method stub
		return jogoLotofacil;
	}

		
	public String toString() {
		return imprime();
		
			
	}
	
	public String imprime() {
		StringBuilder sb = new StringBuilder();
    	sb.append("==============================================\n");  
    	sb.append(":Concurso : "+getConcurso() + "\n");  
    	
    	for(int i = 0;i < numeros.size(); i++) {
    		sb.append(" :Número : "+numeros.get(i));
    		}
    	sb.append("\n:Data  : "+getData() + "\n");  
    	sb.append("==============================================\n");  
    
    	return sb.toString();
	}


	/*public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}*/

}

