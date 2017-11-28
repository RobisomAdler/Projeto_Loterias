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
import java.util.Random;

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
            System.out.println("Digite o concurso a excluir:");
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
        	
        	/*System.out.println("Listando números de 0 a 31 em binario");
         	for (int conjuntoLotofacil = 0; conjuntoLotofacil < 32; conjuntoLotofacil++) {
         		System.out.println(Integer.toBinaryString(conjuntoLotofacil)+" corresponde ao número : "+ conjuntoLotofacil);
        	   	}*/
        	System.out.println("Esta opção gera cinco conjuntos de números conforme a faixa de valores");
        	
        	int total = 0;	
        	
        	for (int i = 1; i<6;i++) {
	      		int numero = 0;  
	      		int min = 0, max = 32;
	      		numero = (new Random().nextInt(max - min));
	    	
		  	
	      		List<LinhaLotofacil> teste = new LinhaLotofacil().geraLinhas(i);
	      		
	      		LinhaLotofacil contador = teste.get(numero);
	      		
	      		System.out.println("Imprime combinação -->  " +numero+ " <--"  +contador );
		  	
	      		total = total + contador.retornaQtdNum();
        	
	      		System.out.println("Total de números gerados --> "+total+" <-----");
        	
		  	
        	/*if(i == 5 && total < 16) {
		  		i = 1;
		  	}
        	else
        		if(total >15) {
        			i = 6;
        		}*/
        	
        	
        	
        	
        	}
        	
        
        	
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
