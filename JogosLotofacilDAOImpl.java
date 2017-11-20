/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 */
package br.com.projeto.lotofacil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.projeto.lotofacil.beans.JogosLotofacil;
import br.com.projeto.lotofacil.exception.GenericException;
import br.com.projeto.lotofacil.util.ConnectionManager;

public class JogosLotofacilDAOImpl implements IJogosLotofacilDAO {

	private final static String SALVAR_CONCURSO = "INSERT INTO concursos (concurso,bola1,bola2,bola3,bola4,bola5,bola6,bola7,bola8,bola9,bola10,bola11,bola12,bola13,bola14,bola15, data) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final static String CREATE_TABLE = "CREATE TABLE  IF NOT EXISTS  concursos (concurso varchar(10) NOT NULL AUTO_INCREMENT   PRIMARY KEY, bola1 VARCHAR(20),bola2 VARCHAR(20),bola3 VARCHAR(20),bola4 VARCHAR(20),bola5 VARCHAR(20),bola6 VARCHAR(20),bola7 VARCHAR(20),bola8 VARCHAR(20),bola9 VARCHAR(20),bola10 VARCHAR(20),bola11 VARCHAR(20),bola12 VARCHAR(20),bola13 VARCHAR(20),bola14 VARCHAR(20),bola15 VARCHAR(20), data VARCHAR(20)";
	private final static String DELETE_CONCURSO = "DELETE FROM concursos WHERE concurso = '";
	private final static String GET_ALL_CONCURSOS = "SELECT * FROM concursos";
	private final static String GET_JOGOS_BY_CONCURSO = "SELECT * FROM concursos WHERE concurso = ?";

	public void createTable() throws GenericException {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ConnectionManager.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(CREATE_TABLE);
		} catch (SQLException e) {
			throw new GenericException(
					"Erro ao criar a tabela de concursos Lotofácil : " + CREATE_TABLE, e);
		} finally {
			ConnectionManager.closeAll(conn, stmt);
		}
	}

	/*
	 * @see
	 * br.com.globalcode.aj3.dao.ClientesDAO#excluir(br.com.globalcode.beans
	 * .Cliente)
	 */
	public void excluir(String concurso) throws GenericException {
		Connection conn = null;
		Statement stmt = null;
		try {
			// Abertura da conexao
			conn = ConnectionManager.getConnection();
			// Criacao do Statement
			stmt = conn.createStatement();
			// Execucao da query
			int numeroLinhas = stmt.executeUpdate(DELETE_CONCURSO + concurso + "'");
			// Impressao do numero de linhas alteradas
			System.out.println("Numero de concursos excluidos: " + numeroLinhas);
		} catch (SQLException e) {
			throw new GenericException("Erro ao excluir concurso: "
					+ DELETE_CONCURSO, e);
		} finally {
			// Fechamento da Connection e Statement
			ConnectionManager.closeAll(conn, stmt);
		}
	}

	/*
	 * @see
	 * br.com.globalcode.aj3.dao.ClientesDAO#salvar(br.com.globalcode.beans.
	 * Cliente)
	 */
	public void salvar(JogosLotofacil jogoLotofacil) throws GenericException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// Abertura da conexao
			conn = ConnectionManager.getConnection();
			// Criacao da PreparedStatement
			stmt = conn.prepareStatement(SALVAR_CONCURSO);
			// Atribuicao de uma String para a 1a. interrogacao (concurso)
			stmt.setString(1, jogoLotofacil.getConcurso());
			// Atribuicao de uma String da 2a. à 16 interrogacao (bolas)
			
			stmt.setString(2, jogoLotofacil.getNumeros().get(0));
			stmt.setString(3, jogoLotofacil.getNumeros().get(1));
			stmt.setString(4, jogoLotofacil.getNumeros().get(2));
			stmt.setString(5, jogoLotofacil.getNumeros().get(3));
			stmt.setString(6, jogoLotofacil.getNumeros().get(4));
			stmt.setString(7, jogoLotofacil.getNumeros().get(5));
			stmt.setString(8, jogoLotofacil.getNumeros().get(6));
			stmt.setString(9, jogoLotofacil.getNumeros().get(7));
			stmt.setString(10, jogoLotofacil.getNumeros().get(8));
			stmt.setString(11, jogoLotofacil.getNumeros().get(9));
			stmt.setString(12, jogoLotofacil.getNumeros().get(10));
			stmt.setString(13, jogoLotofacil.getNumeros().get(11));
			stmt.setString(14, jogoLotofacil.getNumeros().get(12));
			stmt.setString(15, jogoLotofacil.getNumeros().get(13));
			stmt.setString(16, jogoLotofacil.getNumeros().get(14));
			
			// Atribuicao de uma String para a 17 interrogacao (data)
			stmt.setString(17, jogoLotofacil.getData());
			
			
			// Executar a operacao de gravar os dados na base
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericException(
					"Nao foi possivel salvar o concurso na base de dados.", e);
		} finally {
			// Fechamento da Connection e Statement
			ConnectionManager.closeAll(conn, stmt);
		}
	}

	/*
	 * @see br.com.globalcode.aj3.dao.ClientesDAO#getAllClientes()
	 */
	public List getAllConcursos() throws GenericException {
		// Criacao da lista para armazenar os clientes
		ArrayList concursos = new ArrayList();
		ArrayList numeros = new ArrayList();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// Abertura da conexao
			conn = ConnectionManager.getConnection();
			// Criacao do statement
			stmt = conn.createStatement();
			// Execucao da consulta
			rs = stmt.executeQuery(GET_ALL_CONCURSOS);
			// Leitura do ResultSet
			while (rs.next()) {
				// leitura dos dados retornados
				String conc = rs.getString("concurso");
				String bola1 = rs.getString("bola1");
				String bola2 = rs.getString("bola2");
				String bola3 = rs.getString("bola3");
				String bola4 = rs.getString("bola4");
				String bola5 = rs.getString("bola5");
				String bola6 = rs.getString("bola6");
				String bola7 = rs.getString("bola7");
				String bola8 = rs.getString("bola8");
				String bola9 = rs.getString("bola9");
				String bola10 = rs.getString("bola10");
				String bola11 = rs.getString("bola11");
				String bola12 = rs.getString("bola12");
				String bola13 = rs.getString("bola13");
				String bola14 = rs.getString("bola14");
				String bola15 = rs.getString("bola15");
				String data = rs.getString("data");
				
				
				//adiçao dos numeros na arraylist numeros
				
				numeros.add(bola1);
				numeros.add(bola2);
				numeros.add(bola3);
				numeros.add(bola4);
				numeros.add(bola5);
				numeros.add(bola6);
				numeros.add(bola7);
				numeros.add(bola8);
				numeros.add(bola9);
				numeros.add(bola10);
				numeros.add(bola11);
				numeros.add(bola12);
				numeros.add(bola13);
				numeros.add(bola14);
				numeros.add(bola15);
				
						
				// criacao do jogoLotofacil
				JogosLotofacil jogos = new JogosLotofacil(conc, numeros, data);
				
				//Cliente c = new Cliente(nome, telefone, cpf, id);
				// adicao do cliente na lista
				concursos.add(jogos);
			}
			return concursos;
		} catch (SQLException e) {
			throw new GenericException(
					"Nao foi possivel recuperar os concursos da base de dados.",
					e);
		} finally {
			// Fechamento da Connection, Statement e ResultSet
			ConnectionManager.closeAll(conn, stmt, rs);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.globalcode.aj3.dao.ClientesDAO#getClienteByID(int)
	 */
	public JogosLotofacil getJogosLofacilByConcurso(String concurso) throws GenericException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		JogosLotofacil jogoLotofacil = null;
		try {
			// Abertura da conexao
			conn = ConnectionManager.getConnection();
			// Criacao do PreparedStatement
			stmt = conn.prepareStatement(GET_JOGOS_BY_CONCURSO);
			// Atribuicao de uma String para a 1a. interrogacao (concurso)
			stmt.setString(1, concurso);
			// Execucao do PreparedStatement
			rs = stmt.executeQuery();
			// Leitura do ResultSet com geracao de um objeto JogosLotofacil
			while (rs.next()) {
				
				
				
				
				String bola1 = rs.getString("bola1"); 
				String bola2 = rs.getString("bola2"); 
				String bola3 = rs.getString("bola3");
				String bola4 = rs.getString("bola4");
				String bola5 = rs.getString("bola5");
				String bola6 = rs.getString("bola6");
				String bola7 = rs.getString("bola7");
				String bola8 = rs.getString("bola8");
				String bola9 = rs.getString("bola9");
				String bola10 = rs.getString("bola10");
				String bola11 = rs.getString("bola11");
				String bola12 = rs.getString("bola12");
				String bola13 = rs.getString("bola13");
				String bola14 = rs.getString("bola14");
				String bola15 = rs.getString("bola15");
				
				ArrayList<String> numeros = new ArrayList<String>(Arrays.asList(bola1,bola2,bola3,bola4, bola5, bola6, bola7, bola8, bola9, bola10, bola11, bola12,bola13, bola14, bola15));
				
				jogoLotofacil = new JogosLotofacil(rs.getString("concurso"),numeros,rs.getString("data"));
			}
		} catch (SQLException e) {
			throw new GenericException(
					"Nao foi possivel encontrar o concurso na base de dados.", e);
		} finally {
			// Fechamento da Connection, Statement e ResultSet
			ConnectionManager.closeAll(conn, stmt, rs);
		}
		// Retorna os valores para o metodo
		return jogoLotofacil;
	}

	@Override
	public List getAllJogosLotofacil() throws GenericException {
		
		return getAllConcursos();
	}
}
