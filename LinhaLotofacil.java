package br.com.projeto.lotofacil.util;

import java.util.List;

public class LinhaLotofacil {
	
	private String pos1;
	private String pos2;
	private String pos3;
	private String pos4;
	private String pos5;
	
	public LinhaLotofacil(String pos1, String pos2, String pos3, String pos4, String pos5) {
		this.setPos1(pos1);
		this.setPos2(pos2);
		this.setPos3(pos3);
		this.setPos4(pos4);
		this.setPos5(pos5);
	}

	/**
	 * @return the pos1
	 */
	public String getPos1() {
		return pos1;
	}

	/**
	 * @param pos1 the pos1 to set
	 */
	public void setPos1(String pos1) {
		this.pos1 = pos1;
	}

	/**
	 * @return the pos2
	 */
	public String getPos2() {
		return pos2;
	}

	/**
	 * @param pos2 the pos2 to set
	 */
	public void setPos2(String pos2) {
		this.pos2 = pos2;
	}

	/**
	 * @return the pos3
	 */
	public String getPos3() {
		return pos3;
	}

	/**
	 * @param pos3 the pos3 to set
	 */
	public void setPos3(String pos3) {
		this.pos3 = pos3;
	}

	/**
	 * @return the pos4
	 */
	public String getPos4() {
		return pos4;
	}

	/**
	 * @param pos4 the pos4 to set
	 */
	public void setPos4(String pos4) {
		this.pos4 = pos4;
	}

	/**
	 * @return the pos5
	 */
	public String getPos5() {
		return pos5;
	}

	/**
	 * @param pos5 the pos5 to set
	 */
	public void setPos5(String pos5) {
		this.pos5 = pos5;
	}
	
	
	public String toString() {
		return imprimeLinha();
	}
	
	
	public String imprimeLinha() {
		
		StringBuilder sb = new StringBuilder();
        sb.append("==============================================\n");  
        sb.append(":Posição1 : "+getPos1() + "\n");  
        sb.append(":Posição2 : "+getPos2() + "\n");  
        sb.append(":Posição3 : "+getPos3() + "\n");  
        sb.append(":Posição4 : "+getPos4() + "\n");  
        sb.append(":Posição5 : "+getPos5() + "\n");
        sb.append("==============================================\n");  
        return sb.toString();
			
	}
		
		
	

}
