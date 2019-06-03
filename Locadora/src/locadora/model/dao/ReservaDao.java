package locadora.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import locadora.conexao.factory.jdbc.ConexaoException;
import locadora.conexao.factory.jdbc.FabricaConexao;
import locadora.model.entity.Reserva;
import locadora.model.service.ReservaValidacao;

public class ReservaDao {

	private Connection conexao;

	public ReservaDao() throws ConexaoException {

		this.conexao = FabricaConexao.getConexao();

	}

	public void insertReserva(Reserva r) throws ConexaoException {

		PreparedStatement ps = null;
		Connection conexao = null;

		ReservaValidacao rv = new ReservaValidacao();

		String retirada = rv.dateToMySql(r.getDataRetirada()); // change from DATE to String before send to Mysql
		String entrega = rv.dateToMySql(r.getDataEntrega());// change from DATE to String before send to Mysql

		try {
			conexao = this.conexao;
			ps = conexao.prepareStatement(
					"INSERT INTO `locadora`.`reserva` (`idreserva`, `dataRetirada`, `dataEntregua`, `diasLocado`, `valorPago`, `cliente_idcliente`, `veiculo_idveiculo`) VALUES (?,?,?,?,?,?,?)");

			ps.setInt(1, r.getIdReserva());
			ps.setString(2, retirada);
			ps.setString(3, entrega);
			ps.setLong(4, r.getDiasLocado());
			ps.setDouble(5, r.getValorPago());
			ps.setInt(6, r.getCliente().getIdCliente());
			ps.setInt(7, r.getVeiculo().getIdVeiculo());
			ps.executeUpdate();

			System.out.println("Reserva adicionada com sucesso");

		} catch (SQLException sqle) {
			throw new ConexaoException();
		} finally {
			FabricaConexao.fecharPreparedStatement(ps);
			this.fecharConexao();
		}

	}// end insertReserva

	public List<Reserva> getAllReservaBD() throws ConexaoException, ParseException {

		Connection conexao = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		Reserva reserva = null;

		try {
			conexao = this.conexao;
			st = conexao.prepareStatement(
					"select cliente.idcliente, cliente.fname, cliente.lname, veiculo.idveiculo, veiculo.modelo, veiculo.diaria, reserva.idreserva, reserva.dataRetirada, reserva.dataEntregua, reserva.diasLocado,\r\n"
							+ "reserva.valorPago\r\n" + "from reserva, cliente, veiculo\r\n"
							+ "where cliente.idcliente = reserva.cliente_idcliente\r\n"
							+ "and reserva.veiculo_idveiculo = veiculo.idveiculo;");

			rs = st.executeQuery();
			
			ReservaValidacao rv = new ReservaValidacao();
			
			

			List<Reserva> re = new ArrayList<Reserva>();

			while (rs.next()) {
				
				String dtRetirada= rs.getString(8);
				String dtEntrega = rs.getString(9);
				
				Date retirada = rv.stringToDate(dtRetirada);
				Date entrega = rv.stringToDate(dtEntrega);

				reserva = new Reserva(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getDouble(6), rs.getInt(7), retirada, entrega, rs.getLong(10), rs.getDouble(11));

				re.add(reserva);

			}

			return re;

		} catch (SQLException sqle) {
			throw new ConexaoException("Erro ao visualizar os dados" + sqle);
		} finally {
			System.out.println();
			FabricaConexao.fecharStmtRs(st, rs);
			this.fecharConexao();
		}

	}// End getAllReservas

	public List<Reserva> getReserva(int ID) throws ConexaoException {

		Connection conexao = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		Reserva reserva = null;

		try {
			conexao = this.conexao;
			st = conexao.prepareStatement(
					"select cliente.idcliente, cliente.fname, cliente.lname, veiculo.idveiculo, veiculo.modelo, veiculo.diaria, reserva.idreserva, reserva.dataRetirada, reserva.dataEntregua, reserva.diasLocado,\r\n"
							+ "reserva.valorPago\r\n" + "from reserva, cliente, veiculo\r\n"
							+ "where cliente.idcliente = reserva.cliente_idcliente\r\n"
							+ "and reserva.veiculo_idveiculo = veiculo.idveiculo and reserva.idreserva = '" + ID
							+ "';");

			rs = st.executeQuery();

			List<Reserva> re = new ArrayList<Reserva>();

			while (rs.next()) {

				reserva = new Reserva(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getDouble(6), rs.getInt(7), rs.getDate(8), rs.getDate(9), rs.getLong(10), rs.getDouble(11));

				re.add(reserva);
			}
			return re;

		} catch (SQLException sqle) {
			throw new ConexaoException("Erro ao visualizar os dados" + sqle);
		} finally {
			System.out.println();
			FabricaConexao.fecharStmtRs(st, rs);
			this.fecharConexao();
		}

	}// End getAllReservas

//	public void UpdateReserva(Reserva r) throws ConexaoException {
//
//		PreparedStatement ps = null;
//		Connection conexao = null;
////UPDATE `locadora`.`reserva` SET `dataEntregua` = '05/13/2018' WHERE (`idreserva` = '1') and (`cliente_idcliente` = '2') and (`veiculo_idveiculo` = '1');
//		
//		Date data1 = r.getDataRetirada();
//		Date data2 = r.getDataEntrega();
//		long dias = r.getDiasLocado();
//		Double pgto = r.getValorPago();
//		int idres = r.getIdReserva();
//		int idcliente = r.getIdCliente();
//		int idveiculo = r.getIdVeiculo();
//		
//		
//		
//		try {
//			conexao = this.conexao;
//			ps = conexao.prepareStatement(
//					"UPDATE `locadora`.`reserva` SET `dataRetirada` = '"+data1+"', `dataEntregua` = '"+data2+"', `diasLocado` = '"+dias+"', `valorPago` = '"+pgto+"' WHERE (`idreserva` = '"+idres+"') and (`cliente_idcliente` = '"+idcliente+"') and (`veiculo_idveiculo` = '"+idveiculo+"');");
//			
//
////			ps.setString(1, r.getDataRetirada());
////			ps.setString(2, r.getDataEntrega());
////			ps.setLong(3, r.getDiasLocado());
////			ps.setDouble(4, r.getValorPago());
////			ps.setInt(5, r.getIdReserva());
////			ps.setInt(6, r.getIdCliente());
////			ps.setInt(7, r.getIdVeiculo());
//			ps.executeUpdate();
//
//		} catch (SQLException sqle) {
//			throw new ConexaoException();
//		} finally {
//			FabricaConexao.fecharPreparedStatement(ps);
//
//		}
//
//	}// end UpdateReserva

//	public void imprimeReservas() {
//		
//	}

	public void fecharConexao() throws ConexaoException {
		FabricaConexao.fecharConexao(conexao);
	}/* fecharConexao */

}/* End ReservaDao */
