package locadora.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import locadora.conexao.factory.jdbc.ConexaoException;
import locadora.conexao.factory.jdbc.FabricaConexao;
import locadora.model.entity.Cliente;


public class ClienteDao {

	private Connection conexao;

	public ClienteDao() throws ConexaoException {

		this.conexao = FabricaConexao.getConexao();

	}

	public void addCliente(Cliente cliente) throws ConexaoException {

		PreparedStatement ps = null;
		Connection conexao = null;

		try {

			conexao = this.conexao;
			ps = conexao.prepareStatement("INSERT INTO cliente (idcliente, fname, lname, cpf, birthday ) values (?, ?, ?, ?, ?)");
			ps.setInt(1, cliente.getIdCliente());
			ps.setString(2, cliente.getFirstName());
			ps.setString(3, cliente.getLastName());
			ps.setString(4, cliente.getCpf());
			ps.setString(5, cliente.getBirthDay());
			
			
			ps.executeUpdate();

		} catch (SQLException sqle) {
			throw new ConexaoException();
		} finally {
			FabricaConexao.fecharPreparedStatement(ps);
			this.fecharConexao();
		}

	}/* end addCliente */

	
	
	
	public void delCliente(int ID) throws ConexaoException {

		/*primeiro é necessário rodar *getClienteFromBD* para obter os ID's dos clientes do BD */
		Connection conexao = null;
		Statement st = null;
		
	

		try {
			conexao = this.conexao;
			st = conexao.createStatement();

			st.executeUpdate("DELETE FROM `locadora`.`cliente` WHERE (`idcliente` = '" + ID + "')");

		} catch (SQLException sqle) {
			throw new ConexaoException();
		} finally {
			FabricaConexao.fecharStatement(st);
			this.fecharConexao();
		}

	}// end deletaUsuario
	
	public List<Cliente> getAllClienteBD() throws ConexaoException {

		Connection conexao = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		Cliente p = null;

		try {
			conexao = this.conexao;
			st = conexao.prepareStatement("SELECT * FROM cliente");
			rs = st.executeQuery();

			List<Cliente> pessoas = new ArrayList<Cliente>();

			while (rs.next()) {

				p = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

				pessoas.add(p);
			}
			System.out.println("Lista de todos os clientes:");
			for (Cliente clien : pessoas) {
				System.out.printf("ID: %d\t|Nome: %s %s\t CPF: %s Data de nascimento: %s%n", clien.getIdCliente(), clien.getFirstName(), clien.getLastName(), clien.getCpf(), clien.getBirthDay());
			} 
			System.out.println();
			return pessoas;
			
		} catch (SQLException sqle) {
			throw new ConexaoException("Erro ao visualizar os dados" + sqle);
		} finally {
			
			FabricaConexao.fecharStmtRs(st, rs);
			this.fecharConexao();
		}
		
	}/* end getClienteFromBD*/
	
	/*listaTodoCliente: chama o metodo "getClienteFromBD" portanto já add os clientes obtidos do Banco de Dados */
public void listaAllCliente()throws ConexaoException{
		
		
	List<Cliente> pessoas = this.getAllClienteBD();
	
	
			System.out.println("Lista de todos os clientes:");
			for (Cliente clien : pessoas) {
				System.out.printf("ID: %d\t|Nome: %s %s\t CPF: %s Data de nascimento: %s%n", clien.getIdCliente(), clien.getFirstName(), clien.getLastName(), clien.getCpf(), clien.getBirthDay());
			} 

	}// end listaTodoCliente
	

public void fecharConexao() throws ConexaoException {
	FabricaConexao.fecharConexao(conexao);

}// end fecharConexao
	
	
	
	
	

}/*FIM ClienteDao*/
