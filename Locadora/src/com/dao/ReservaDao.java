package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conexao.ConexaoException;
import com.conexao.FabricaConexao;
import com.pojo.Reserva;

public class ReservaDao {
	
	private Connection conexao;

	public ReservaDao() throws ConexaoException {

		this.conexao = FabricaConexao.getConexao();

	}
	
	public void insertReserva(Reserva r) throws ConexaoException {

		PreparedStatement ps = null;
		Connection conexao = null;

		try {
			conexao = this.conexao;
			ps = conexao.prepareStatement(
					"INSERT INTO `locadora`.`reserva` (`idreserva`, `dataRetirada`, `dataEntregua`, `diasLocado`, `valorPago`, `cliente_idcliente`, `veiculo_idveiculo`) VALUES (?,?,?,?,?,?,?)");
			

			ps.setInt(1, r.getIdReserva());
			ps.setString(2, r.getDataRetirada());
			ps.setString(3, r.getDataEntrega());
			ps.setLong(4, r.getDiasLocado());
			ps.setDouble(5, r.getValorPago());
			ps.setInt(6, r.getIdCliente());
			ps.setInt(7, r.getIdVeiculo());
			ps.executeUpdate();

		} catch (SQLException sqle) {
			throw new ConexaoException();
		} finally {
			FabricaConexao.fecharPreparedStatement(ps);

		}

	}// end insertReserva
	
	
	public void getAllReservaBD() throws ConexaoException {

		Connection conexao = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		Reserva reserva = null;

		try {
			conexao = this.conexao;
			st = conexao.prepareStatement(
					"select cliente.idcliente, cliente.fname, cliente.lname, veiculo.idveiculo, veiculo.modelo, veiculo.diaria, reserva.idreserva, reserva.dataRetirada, reserva.dataEntregua, reserva.diasLocado,\r\n" + 
					"reserva.valorPago\r\n" + 
					"from reserva, cliente, veiculo\r\n" + 
					"where cliente.idcliente = reserva.cliente_idcliente\r\n" + 
					"and reserva.veiculo_idveiculo = veiculo.idveiculo;");

			rs = st.executeQuery();

			List<Reserva> re = new ArrayList<Reserva>();

			while (rs.next()) {

				reserva = new Reserva(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getDouble(6),rs.getInt(7),rs.getString(8),rs.getString(9), rs.getLong(10),rs.getDouble(11));

				re.add(reserva);
			}
			System.out.println("Lista de todas as reservas:");
			for (Reserva res : re) {
				System.out.printf(
						"ID user: %d\t|Nome: %s %s\t | ID do veiculo: %02d\t| Modelo: %-20s\t| Diaria:R$ %-15.2f\t| ID reserva:  %02d| Alugado de %s  a %s | Total de dias: %d | Valor pago: R$ %.2f%n",
						res.getIdCliente(), res.getFirstName(), res.getLastName(), res.getIdVeiculo(),
						res.getModelo(), res.getDiaria(),res.getIdReserva() , res.getDataRetirada(), res.getDataEntrega(),res.getDiasLocado(),res.getValorPago());
			}
			

		} catch (SQLException sqle) {
			throw new ConexaoException("Erro ao visualizar os dados" + sqle);
		} finally {
			System.out.println();
			FabricaConexao.fecharStmtRs(st, rs);
		}

	}// End getAllReservas

	public void getReserva(int ID) throws ConexaoException {

		Connection conexao = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		Reserva reserva = null;

		try {
			conexao = this.conexao;
			st = conexao.prepareStatement(
					"select cliente.idcliente, cliente.fname, cliente.lname, veiculo.idveiculo, veiculo.modelo, veiculo.diaria, reserva.idreserva, reserva.dataRetirada, reserva.dataEntregua, reserva.diasLocado,\r\n" + 
					"reserva.valorPago\r\n" + 
					"from reserva, cliente, veiculo\r\n" + 
					"where cliente.idcliente = reserva.cliente_idcliente\r\n" + 
					"and reserva.veiculo_idveiculo = veiculo.idveiculo and reserva.idreserva = '"+ID+"';");

			rs = st.executeQuery();

			List<Reserva> re = new ArrayList<Reserva>();

			while (rs.next()) {

				reserva = new Reserva(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getDouble(6),rs.getInt(7),rs.getString(8),rs.getString(9), rs.getLong(10),rs.getDouble(11));

				re.add(reserva);
			}
			System.out.println("Reservas da ID:" +ID+"");
			for (Reserva res : re) {
				System.out.printf(
						"ID user: %d\t|Nome: %s %s\t | ID do veiculo: %02d\t| Modelo: %-20s\t| Diaria:R$ %-15.2f\t| ID reserva:  %02d| Alugado de %s  a %s | Total de dias: %d | Valor pago: R$ %.2f%n",
						res.getIdCliente(), res.getFirstName(), res.getLastName(), res.getIdVeiculo(),
						res.getModelo(), res.getDiaria(),res.getIdReserva() , res.getDataRetirada(), res.getDataEntrega(),res.getDiasLocado(),res.getValorPago());
			}
			System.out.println();

		} catch (SQLException sqle) {
			throw new ConexaoException("Erro ao visualizar os dados" + sqle);
		} finally {
			System.out.println();
			FabricaConexao.fecharStmtRs(st, rs);
		}

	}// End getAllReservas

	public void UpdateReserva(Reserva r) throws ConexaoException {

		PreparedStatement ps = null;
		Connection conexao = null;
//UPDATE `locadora`.`reserva` SET `dataEntregua` = '05/13/2018' WHERE (`idreserva` = '1') and (`cliente_idcliente` = '2') and (`veiculo_idveiculo` = '1');
		try {
			conexao = this.conexao;
			ps = conexao.prepareStatement(
					"UPDATE `locadora`.`reserva` SET `dataRetirada` = ?, `dataEntregua` = ?, `diasLocado` = ?, `valorPago` = ? WHERE (`idreserva` = ?) and (`cliente_idcliente` = ?) and (`veiculo_idveiculo` = ?);");
			

			ps.setString(1, r.getDataRetirada());
			ps.setString(2, r.getDataEntrega());
			ps.setLong(3, r.getDiasLocado());
			ps.setDouble(4, r.getValorPago());
			ps.setInt(5, r.getIdReserva());
			ps.setInt(6, r.getIdCliente());
			ps.setInt(7, r.getIdVeiculo());
			ps.executeUpdate();

		} catch (SQLException sqle) {
			throw new ConexaoException();
		} finally {
			FabricaConexao.fecharPreparedStatement(ps);

		}

	}// end insertReserva
	
	
	
	
	
	


}/*End ReservaDao */
