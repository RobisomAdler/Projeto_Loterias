/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * Esta classe oferece alguns metodos para intera�ao com usuario via prompt, como ainda nao estudamos IO
 * nao sera nosso objetivo entrar em detalhes do codigo implementado para leitura de dados do teclado.
 * 
 * De qualquer forma, e importante entender a responsabilidade de cada metodo. Por isto, analise o codigo abaixo.
 * 
 */
package br.com.projeto.lotofacil.teste;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.projeto.lotofacil.beans.JogosLotofacil;
import br.com.projeto.lotofacil.dao.IJogosLotofacilDAO;
import br.com.projeto.lotofacil.dao.JogosLotofacilDAOImpl;
import br.com.projeto.lotofacil.exception.GenericException;
import br.com.projeto.lotofacil.util.LinhaLotofacil;
import br.com.projeto.lotofacil.util.Teclado;
import br.com.projeto.lotofacil.util.linhaLotofacil;

public class TesteJogosLotofacilDAO {

    public static IJogosLotofacilDAO dao = new JogosLotofacilDAOImpl();

    /**
     * Este metodo e reponsavel pela montagem do menu de op�oes do usuario: INSERIR | REMOVER | LISTAR | FINALIZAR
     */
    public static void montaMenu() {
        System.out.println("------------------------------");
        System.out.println("INSERIR NOVO CONCURSO      : 1");
        System.out.println("REMOVER CONCURSOS          : 2");
        System.out.println("LISTAR CONCURSOS           : 3");
        System.out.println("BUSCAR CONCURSO POR NUMERO : 4");
        System.out.println("GERAR NÚMEROS LOTOFÁCIL    : 5");
        System.out.println("FINALIZAR                  : 0");
        System.out.println("------------------------------");
        System.out.print("ESCOLHA A OPERACAO: ");
    }

    /**
     * Este metodo e responsavel por retornar a op�ao de menu do usuario
     */
    public static int leOperacao() throws IOException, NumberFormatException {
        // Utiliza o metodo estatico da classe Teclado para ler a op�ao digitada
        // pelo usuario
        String op = Teclado.le();
        // Transforma a op�ao, que e uma String em int
        int operacao = Integer.parseInt(op);
        return operacao;
    }

    /**
     * Este metodo e reponsavel por ler um cliente digitado pelo usuario, fazendo todas as "perguntas / intera�oes"
     * necessarias para obten�ao dos dados digitados.
     */
    public static JogosLotofacil leJogos() {
        // Leitura dos dados do Concurso Lotofácil do teclado
        JogosLotofacil jogoLotofacil = null;
        
        
        try {
            System.out.print("Número do concurso: ");
            String concurso = Teclado.le();
            
            System.out.print("Bola1: ");
            String bola1 = Teclado.le(); 
            
            
            System.out.print("Bola2: ");
            String bola2 = Teclado.le();
            
            System.out.print("Bola3: ");
            String bola3 = Teclado.le();
            
            System.out.print("Bola4: ");
            String bola4 = Teclado.le();
            
            System.out.print("Bola5: ");
            String bola5 = Teclado.le();
            
            System.out.print("Bola6: ");
            String bola6 = Teclado.le();
            
            System.out.print("Bola7: ");
            String bola7 = Teclado.le();
            
            System.out.print("Bola8: ");
            String bola8 = Teclado.le();
            
            System.out.print("Bola9: ");
            String bola9 = Teclado.le();
            
            System.out.print("Bola10: ");
            String bola10 = Teclado.le();
            
            System.out.print("Bola11: ");
            String bola11 = Teclado.le();
            
            System.out.print("Bola12: ");
            String bola12 = Teclado.le();
            
            System.out.print("Bola13: ");
            String bola13 = Teclado.le();
            
            System.out.print("Bola14: ");
            String bola14 = Teclado.le();
            
            System.out.print("Bola15: ");
            String bola15 = Teclado.le();
            
            System.out.print("Data concurso : ");
            String data = Teclado.le();
            
            
            ArrayList<String> numeros = new ArrayList<String>(Arrays.asList(bola1,bola2,bola3,bola4, bola5, bola6, bola7, bola8, bola9, bola10, bola11, bola12,bola13, bola14, bola15));
            jogoLotofacil = new JogosLotofacil(concurso, numeros, data);
       
        } catch (Exception e) {
            e.printStackTrace();
        }
        // retorna o jogoLotofacil lido
        return jogoLotofacil;
    }

    /**
     * Este metodo e reponsavel por ler o ID de um concurso digitado pelo usuario, fazendo todas as "perguntas /
     * intera�oes" necessarias para obten�ao dos dados
     */
    public static String leConcursoLotofacil() {
        // Leitura do numero do concurso a ser removido
        String concurso = "";
        try {
            // O concurso deve obrigatoriamente ser uma String, por isto criamos um
            // while
            // enquanto o usuario nao digitar um inteiro
            while (concurso.equals("")) {
                System.out.print(" : ");
                String numeroConcurso = Teclado.le();
                // Se o id e valido, interrompemos o while
                if (numeroConcurso != null && numeroConcurso.length() > 0) {
                    concurso = numeroConcurso;
                } // end if
            } // end while
        } catch (Exception e) {
            e.printStackTrace();
        }
        // retorna o Cliente lido
        return concurso;
    }

    public static void listarConcursos(List<?> jogoLotofacil) {
        if (jogoLotofacil != null) {
            for (int i = 0; i < jogoLotofacil.size(); i++) {
                System.out.println(((JogosLotofacil) jogoLotofacil.get(i)));
            }
        }
    }

    /**
     * Este metodo executa uma tarefa de acordo com a opera�ao passada como parametro.
     */
    public static void executarTarefa(int operacao) throws GenericException {
    	String concursoID = null;
    	JogosLotofacil jogoLotofacil = null;
    	
        switch (operacao) {
        case 1:
            System.out.println("Inserindo concurso");
            jogoLotofacil = leJogos();
            dao.salvar(jogoLotofacil);
            break;
        case 2:
            concursoID = leConcursoLotofacil();
            dao.excluir(concursoID);
            break;
        case 3:
            System.out.println("Listando concursos");
            List<?> jogosLotofacil = dao.getAllJogosLotofacil();
            listarConcursos(jogosLotofacil);
            break;
        case 4:
        	System.out.println("Buscando concurso por número");
        	concursoID = leConcursoLotofacil();
        	jogoLotofacil = dao.getJogosLofacilByConcurso(concursoID);
        	if (jogoLotofacil != null)
        		System.out.println((JogosLotofacil)jogoLotofacil);
        	else
        		System.out.println("Concurso nao encontrado!");
        	break;
        case 5:
        	System.out.println("Listando números de 0 a 31 em binario");
        	
        	for (int conjuntoLotofacil = 0; conjuntoLotofacil < 32; conjuntoLotofacil++) {
        		System.out.println(Integer.toBinaryString(conjuntoLotofacil)+" corresponde ao número : "+ conjuntoLotofacil);
        	   	}
        	
        	String pos1 = null,pos2= null,pos3= null,pos4 = null,pos5 = null;
        	
        	//combinação 31
        	
        	pos1="5";
        	pos2="4";
        	pos3="3";
        	pos4="2";
        	pos5="1";
        	
        	LinhaLotofacil linha_31 = null; 
        	linha_31 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);
        	
        	//combinação 30
        	
        	pos1="null";
        	pos2 ="4";
        	pos3="3";
        	pos4="2";
        	pos5="1";
        	
        	LinhaLotofacil linha_30 = null; 
        	linha_30 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);
        	
        	//combinação 29
        	
        	pos1="5";
        	pos2 ="null";
        	pos3="3";
        	pos4="2";
        	pos5="1";
        	
        	LinhaLotofacil linha_29 = null; 
        	linha_29 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 28
        	
        	pos1="null";
        	pos2 ="null";
        	pos3="3";
        	pos4="2";
        	pos5="1";
        	
        	LinhaLotofacil linha_28 = null; 
        	linha_28 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);
        	
        		
        	//combinação 27
        	
        	pos1="5";
        	pos2="4";
        	pos3="null";
        	pos4="2";
        	pos5="1";
        	
        	LinhaLotofacil linha_27 = null; 
        	linha_27 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 26
        	
        	pos1="null";
        	pos2="4";
        	pos3="null";
        	pos4="2";
        	pos5="1";
        	
        	LinhaLotofacil linha_26 = null; 
        	linha_26 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 25
        	
        	pos1="5";
        	pos2="null";
        	pos3="null";
        	pos4="2";
        	pos5="1";
        	
        	LinhaLotofacil linha_25 = null; 
        	linha_25 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 24
        	
        	pos1="null";
        	pos2="null";
        	pos3="null";
        	pos4="2";
        	pos5="1";
        	
        	LinhaLotofacil linha_24 = null; 
        	linha_24 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 23
        	
        	pos1="5";
        	pos2="4";
        	pos3="3";
        	pos4="null";
        	pos5="1";
        	
        	LinhaLotofacil linha_23 = null; 
        	linha_23 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 22
        	
        	pos1="null";
        	pos2="4";
        	pos3="3";
        	pos4="null";
        	pos5="1";
        	
        	LinhaLotofacil linha_22 = null; 
        	linha_22 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 21
        	
        	pos1="5";
        	pos2="null";
        	pos3="3";
        	pos4="null";
        	pos5="1";
        	
        	LinhaLotofacil linha_21 = null; 
        	linha_21 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 20
        	
        	pos1="null";
        	pos2="null";
        	pos3="3";
        	pos4="null";
        	pos5="1";
        	
        	LinhaLotofacil linha_20 = null; 
        	linha_20 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 19
        	
        	pos1="5";
        	pos2 ="4";
        	pos3="null";
        	pos4="null";
        	pos5="1";
        	
        	LinhaLotofacil linha_19 = null; 
        	linha_19 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);
        	
        	//combinação 18        	
        	
        	pos1="null";
        	pos2 ="4";
        	pos3="null";
        	pos4="null";
        	pos5="1";
        	
        	LinhaLotofacil linha_18 = null; 
        	linha_18 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);
        	
        	//combinação 17
        	
        	pos1="5";
        	pos2 ="null";
        	pos3="null";
        	pos4="null";
        	pos5="1";
        	
        	LinhaLotofacil linha_17 = null; 
        	linha_17 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 16
        	
        	pos1="null";
        	pos2 ="null";
        	pos3="null";
        	pos4="null";
        	pos5="1";
        	
        	LinhaLotofacil linha_16 = null; 
        	linha_16 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);
        	
        	
        	
        	//combinação 15
        	
        	pos1="5";
        	pos2="4";
        	pos3="3";
        	pos4="2";
        	pos5="null";
        	
        	LinhaLotofacil linha_15 = null; 
        	linha_15 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 14
        	
        	pos1="null";
        	pos2="4";
        	pos3="3";
        	pos4="2";
        	pos5="null";
        	
        	LinhaLotofacil linha_14 = null; 
        	linha_14 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 13
        	
        	pos1="5";
        	pos2="null";
        	pos3="3";
        	pos4="2";
        	pos5="null";
        	
        	LinhaLotofacil linha_13 = null; 
        	linha_13 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 12
        	
        	pos1="null";
        	pos2="null";
        	pos3="3";
        	pos4="2";
        	pos5="null";
        	
        	LinhaLotofacil linha_12 = null; 
        	linha_12 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 11
        	
        	pos1="5";
        	pos2="4";
        	pos3="null";
        	pos4="2";
        	pos5="null";
        	
        	LinhaLotofacil linha_11 = null; 
        	linha_11 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 10
        	
        	pos1="null";
        	pos2="4";
        	pos3="null";
        	pos4="2";
        	pos5="null";
        	
        	LinhaLotofacil linha_10 = null; 
        	linha_10 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 09
        	
        	pos1="5";
        	pos2="null";
        	pos3="null";
        	pos4="2";
        	pos5="null";
        	
        	LinhaLotofacil linha_9 = null; 
        	linha_9 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 8
        	
        	pos1="null";
        	pos2="null";
        	pos3="null";
        	pos4="2";
        	pos5="null";
        	
        	LinhaLotofacil linha_8 = null;
        	linha_8 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);
        	
        	//combinação 7
        	
        	pos1="5";
        	pos2="4";
        	pos3="3";
        	pos4="null";
        	pos5="null";
        	
        	LinhaLotofacil linha_7 = null; 
        	linha_7 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 6
        	
        	pos1="5";
        	pos2="4";
        	pos3="null";
        	pos4="null";
        	pos5="null";
        	
        	LinhaLotofacil linha_6 = null; 
        	linha_6 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 5
        	
        	pos1="5";
        	pos2="null";
        	pos3="3";
        	pos4="null";
        	pos5="null";
        	
        	LinhaLotofacil linha_5 = null; 
        	linha_5 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 4
        	
        	pos1="null";
        	pos2="null";
        	pos3="3";
        	pos4="null";
        	pos5="null";
        	
        	LinhaLotofacil linha_4 = null; 
        	linha_4 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 3
        	
        	pos1="5";
        	pos2="4";
        	pos3="null";
        	pos4="null";
        	pos5="null";
        	
        	LinhaLotofacil linha_3 = null; 
        	linha_3 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 2
        	
        	pos1="null";
        	pos2="4";
        	pos3="null";
        	pos4="null";
        	pos5="null";
        	
        	LinhaLotofacil linha_2 = null; 
        	linha_2 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);		
        	
        	//combinação 1
        	
        	pos1="5";
        	pos2="null";
        	pos3="null";
        	pos4="null";
        	pos5="null";
        	
        	LinhaLotofacil linha_1 = null;
        	linha_1 = new LinhaLotofacil(pos1,pos2,pos3,pos4,pos5);
        	
        	//combinação 0
        	
        	pos1="null";
        	pos2="null";
        	pos3="null";
        	pos4="null";
        	pos5="null";
        	
        	LinhaLotofacil linha_0 = new LinhaLotofacil(null,null,null,null,null);
        	
        	//Cria ArrayList para inserir as combinações     	
        	
        	List<LinhaLotofacil> linha = new ArrayList<>();
        	
        	linha.add(linha_0);
        	linha.add(linha_1);
        	linha.add(linha_2);
        	linha.add(linha_3);
        	linha.add(linha_4);
        	linha.add(linha_5);
        	linha.add(linha_6);
        	linha.add(linha_7);
        	linha.add(linha_8);
        	linha.add(linha_9);
        	linha.add(linha_10);
        	linha.add(linha_11);
        	linha.add(linha_12);
        	linha.add(linha_13);
        	linha.add(linha_14);
        	linha.add(linha_15);
        	linha.add(linha_16);
        	linha.add(linha_17);
        	linha.add(linha_18);
        	linha.add(linha_19);
        	linha.add(linha_20);
        	linha.add(linha_21);
        	linha.add(linha_22);
        	linha.add(linha_23);
        	linha.add(linha_24);
        	linha.add(linha_25);
        	linha.add(linha_26);
        	linha.add(linha_27);
        	linha.add(linha_28);
        	linha.add(linha_29);
        	linha.add(linha_30);
        	linha.add(linha_31);
        	
        	
        	
        	
        	
        	
        	imprimeLinhas(linha);
        	
        }
    }

    public static void main(String[] args) throws GenericException {
        int TERMINAR = 0;
        int operacao = 1;
        do {
            try {
                montaMenu();
                operacao = leOperacao();
                if (operacao == TERMINAR) {
                    break;
                } else {
                    executarTarefa(operacao);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Operacao invalida");
            }
        } while (operacao != TERMINAR);
    }
    
    private static void imprimeLinhas(List linha) {
		
		for(int i = 0;i < linha.size(); i++) {
			System.out.println("Combinação : ("+ i +")==>" +linha.get(i));
		}
    }
}
