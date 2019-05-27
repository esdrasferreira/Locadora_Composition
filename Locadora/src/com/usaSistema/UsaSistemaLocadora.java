package com.usaSistema;

import com.conexao.ConexaoException;
import com.dao.ClienteDao;
import com.dao.ReservaDao;
import com.dao.VeiculoDao;
import com.pojo.Cliente;
import com.pojo.Reserva;
import com.pojo.Veiculo;

public class UsaSistemaLocadora {

	public static void main(String[] args) throws ConexaoException {

		Cliente cliente;
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.getAllClienteBD();

		

		/*************************************************************************************************/

		
		VeiculoDao veiculoDao = new VeiculoDao();
		veiculoDao.getVeiculoFromBD();

		/*************************************************************************************************/

		Reserva reserva = new Reserva();;
		ReservaDao rDao = new ReservaDao();
		
		rDao.getReserva(4);
		reserva.setDataEntrega("05/10/2019");
		reserva.setValorPago(100.00);
		rDao.UpdateReserva(reserva);
		rDao.getAllReservaBD();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}/* FIM */
