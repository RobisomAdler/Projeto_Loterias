package br.com.projeto.lotofacil.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.projeto.lotofacil.beans.JogosLotofacil;

public class LinhaLotofacil {

	private int pos1;
	private int pos2;
	private int pos3;
	private int pos4;
	private int pos5;
	private int posicao;
	

	
	public LinhaLotofacil() {}
	
	public LinhaLotofacil(int pos1, int pos2, int pos3, int pos4, int pos5) {
		this.setPos1(pos1);
		this.setPos2(pos2);
		this.setPos3(pos3);
		this.setPos4(pos4);
		this.setPos5(pos5);
		}

	public LinhaLotofacil(int pos1, int pos2, int pos3, int pos4, int pos5, int linha) {
		this.setPos1(pos1);
		this.setPos2(pos2);
		this.setPos3(pos3);
		this.setPos4(pos4);
		this.setPos5(pos5);
		this.adicionaValorLinha(linha);
		}
	
	//construtor que adiciona posicao
	public LinhaLotofacil(int pos1, int pos2, int pos3, int pos4, int pos5, int linha, int posicao) {
		this.setPos1(pos1);
		this.setPos2(pos2);
		this.setPos3(pos3);
		this.setPos4(pos4);
		this.setPos5(pos5);
		this.adicionaValorLinha(linha);
		this.adicionaValorPosicao(posicao);
		}

	
	
	private void adicionaValorPosicao(int posicao) {
		this.posicao = posicao; 
		
		
	}

	public String toString() {
		return imprimeLinha();
	}

	public String imprimeLinha() {

		StringBuilder sb = new StringBuilder();
		sb.append("==============================================\n");
		sb.append(":Posição1 : " + getPos1() + "\n");
		sb.append(":Posição2 : " + getPos2() + "\n");
		sb.append(":Posição3 : " + getPos3() + "\n");
		sb.append(":Posição4 : " + getPos4() + "\n");
		sb.append(":Posição5 : " + getPos5() + "\n");
		sb.append(":Quantidade de números na linha:" + retornaQtdNum() + "\n");

		sb.append("==============================================\n");
		return sb.toString();

	}

	public int retornaQtdNum() {
		int QtdNum = 0;

		if (this.getPos1() != 0) {
			QtdNum++;
		}

		if (this.getPos2() != 0) {
			QtdNum++;
		}

		if (this.getPos3() != 0) {
			QtdNum++;
		}

		if (this.getPos4() != 0) {
			QtdNum++;
		}

		if (this.getPos5() != 0) {
			QtdNum++;
		}

		return QtdNum;
	}

	public void adicionaValorLinha(int linha) {
		/*
		 * if (linha == this.linha2 || linha == this.linha3 || linha == this.linha3 ||
		 * linha == this.linha4 || linha == this.linha5) { ; }else
		 * System.out.println("Valor inválido");
		 */

		switch (linha) {
		
		case 1:
			break;
		
		
		case 2:
			//System.out.println("Adiciona valor 5 a cada linha");
			this.modificaLinha(5);
			break;

		case 3:
			//System.out.println("Adiciona valor 10 a cada linha");
			this.modificaLinha(10);

			break;
		case 4:
			//System.out.println("Adiciona valor 15 a cada linha");
			this.modificaLinha(15);

			break;
		case 5:
			//System.out.println("Adiciona valor 20 a cada linha");
			this.modificaLinha(20);
			break;
		}

	}

	/**
	 * @return the pos1
	 */
	public int getPos1() {
		return pos1;
	}

	/**
	 * @param pos1 the pos1 to set
	 */
	public void setPos1(int pos1) {
		this.pos1 = pos1;
	}
	
	/**
	 * @return the pos2
	 */
	public int getPos2() {
		return pos2;
	}

	/**
	 * @param pos2 the pos2 to set
	 */
	public void setPos2(int pos2) {
		this.pos2 = pos2;
	}

	/**
	 * @return the pos3
	 */
	public int getPos3() {
		return pos3;
	}

	/**
	 * @param pos3 the pos3 to set
	 */
	public void setPos3(int pos3) {
		this.pos3 = pos3;
	}

	/**
	 * @return the pos4
	 */
	public int getPos4() {
		return pos4;
	}

	/**
	 * @param pos4 the pos4 to set
	 */
	public void setPos4(int pos4) {
		this.pos4 = pos4;
	}

	/**
	 * @return the pos5
	 */
	public int getPos5() {
		return pos5;
	}

	/**
	 * @param pos5 the pos5 to set
	 */
	public void setPos5(int pos5) {
		this.pos5 = pos5;
	}
	
	public void modificaLinha(int valorLinha) {
	if (this.pos1 != 0) {
		this.pos1 += valorLinha;
		}
		if (this.pos2 != 0) {
			this.pos2 += valorLinha;
			}
			if (this.pos3 != 0) {
				this.pos3 += valorLinha;
				}
				if (this.pos4 != 0) {
					this.pos4 += valorLinha;
					}
					if (this.pos5 != 0) {
						this.pos5 += valorLinha;
						}
		}
	
	
	public List<LinhaLotofacil> geraLinhas(int linha) {
		
	
    	//Cria ArrayList para inserir as combinações     	
    	
  
        List<LinhaLotofacil> linhas = new ArrayList<>();
    	
    	             
        linhas.add(new LinhaLotofacil(0,0,0,0,0, linha, 0));
    	linhas.add(new LinhaLotofacil(5,0,0,0,0, linha,1));
    	linhas.add(new LinhaLotofacil(0,4,0,0,0, linha, 2));
    	linhas.add(new LinhaLotofacil(5,4,0,0,0, linha, 3));
    	linhas.add(new LinhaLotofacil(0,0,3,0,0, linha, 4));
    	linhas.add(new LinhaLotofacil(5,0,3,0,0, linha, 5));
    	linhas.add(new LinhaLotofacil(0,4,3,0,0, linha, 6));
    	linhas.add(new LinhaLotofacil(5,4,3,0,0, linha, 7));
    	linhas.add(new LinhaLotofacil(0,0,0,2,0, linha, 8));
    	linhas.add(new LinhaLotofacil(5,0,0,2,0, linha, 9));
    	linhas.add(new LinhaLotofacil(0,4,0,2,0, linha, 10));
    	linhas.add(new LinhaLotofacil(5,4,0,2,0, linha, 11));
    	linhas.add(new LinhaLotofacil(0,0,3,2,0, linha, 12));
    	linhas.add(new LinhaLotofacil(5,0,3,2,0, linha, 13));
    	linhas.add(new LinhaLotofacil(0,4,3,2,0, linha, 14));
    	linhas.add(new LinhaLotofacil(5,4,3,2,0, linha, 15));
    	linhas.add(new LinhaLotofacil(0,0,0,0,1, linha, 16));
    	linhas.add(new LinhaLotofacil(5,0,0,0,1, linha, 17));
    	linhas.add(new LinhaLotofacil(0,4,0,0,1, linha, 18));
    	linhas.add(new LinhaLotofacil(5,4,0,0,1, linha, 19));
    	linhas.add(new LinhaLotofacil(0,0,3,0,1, linha, 20));
    	linhas.add(new LinhaLotofacil(5,0,3,0,1, linha, 21));
    	linhas.add(new LinhaLotofacil(0,4,3,0,1, linha, 22));
    	linhas.add(new LinhaLotofacil(5,4,3,0,1, linha, 23));
    	linhas.add(new LinhaLotofacil(0,0,0,2,1, linha, 24));
    	linhas.add(new LinhaLotofacil(5,0,0,2,1, linha, 25));
    	linhas.add(new LinhaLotofacil(0,4,0,2,1, linha, 26));
    	linhas.add(new LinhaLotofacil(5,4,0,2,1, linha, 27));
    	linhas.add(new LinhaLotofacil(0,0,3,2,1, linha, 28));
    	linhas.add(new LinhaLotofacil(5,0,3,2,1, linha, 29));
    	linhas.add(new LinhaLotofacil(0,4,3,2,1, linha, 30));
    	linhas.add(new LinhaLotofacil(5,4,3,2,1, linha, 31));
		
		
		return linhas;
    	
		
	}
	
	
		
	
	
}
