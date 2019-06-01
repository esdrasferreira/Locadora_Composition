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
import locadora.model.entity.Veiculo;

public class VeiculoDao {

	private Connection conexao;

	public VeiculoDao() throws ConexaoException {

		this.conexao = FabricaConexao.getConexao();

	}

	public void addVeiculo(Veiculo veiculo) throws ConexaoException {

		PreparedStatement ps = null;
		Connection conexao = null;

		try {
//INSERT INTO `locadora`.`veiculo` (`fabricante`, `modelo`, `ano`, `diaria`) VALUES ('VW', 'Fusca', '1980', '200');
			conexao = this.conexao;
			ps = conexao.prepareStatement(
					"INSERT INTO `locadora`.`veiculo` (`idveiculo`,`fabricante`, `modelo`, `ano`, `diaria`) values (?, ?, ?, ?, ?)");
			ps.setInt(1, veiculo.getIdVeiculo());
			ps.setString(2, veiculo.getFabricante());
			ps.setString(3, veiculo.getModelo());
			ps.setString(4, veiculo.getAno());
			ps.setDouble(5, veiculo.getDiaria());
			ps.executeUpdate();

		} catch (SQLException sqle) {
			throw new ConexaoException();
		} finally {
			FabricaConexao.fecharPreparedStatement(ps);
		}

	}/* fim addCliente */
	
	public List<Veiculo> getVeiculoFromBD() throws ConexaoException {

		Connection conexao = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		Veiculo p = null;

		try {
			conexao = this.conexao;
			st = conexao.prepareStatement("SELECT * FROM veiculo");
			rs = st.executeQuery();

			List<Veiculo> carro = new ArrayList<Veiculo>();

			while (rs.next()) {

				p = new Veiculo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));

				carro.add(p);
			}
			System.out.println("Lista de todos os veículos:");
			for (Veiculo auto : carro) {
				System.out.printf("ID: %d\t|Fabricante: %-15s\t | Modelo: %s\t | Ano: %s | Diária: %s%n", auto.getIdVeiculo(), auto.getFabricante(), auto.getModelo(), auto.getAno(), auto.getDiaria());
			} 
			System.out.println();
			return carro;
			
		} catch (SQLException sqle) {
			throw new ConexaoException("Erro ao visualizar os dados" + sqle);
		} finally {
			
			FabricaConexao.fecharStmtRs(st, rs);
		}
		
	}/* fim getVeiculoFromBD*/
	
	public void delVeiculo(int ID) throws ConexaoException {

		/*primeiro é necessário rodar *getClienteFromBD* para obter os ID's dos clientes do BD */
		Connection conexao = null;
		Statement st = null;
		
	

		try {
			conexao = this.conexao;
			st = conexao.createStatement();

			st.executeUpdate("DELETE FROM `locadora`.`veiculo` WHERE (`idveiculo` = '" + ID + "')");

		} catch (SQLException sqle) {
			throw new ConexaoException();
		} finally {
			FabricaConexao.fecharStatement(st);
			;
		}
		
	}// fim delVeiculo
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}/*fim VeiculoDao*/
