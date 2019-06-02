package locadora.usaSistema;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import loadora.model.service.CalculosReserva;
import loadora.model.service.ReservaValidacao;
import locadora.conexao.factory.jdbc.ConexaoException;
import locadora.controller.ReservaController;
import locadora.model.dao.ClienteDao;
import locadora.model.dao.ReservaDao;
import locadora.model.dao.VeiculoDao;
import locadora.model.entity.Cliente;
import locadora.model.entity.Reserva;
import locadora.model.entity.Veiculo;

public class TestaMVCDAO {

	public static void main(String[] args) throws ConexaoException, ParseException {

//		Cliente cliente;
//		ClienteDao clienteDao = new ClienteDao();
//		clienteDao.getAllClienteBD();

		

/*************************************************************************************************/

		
		VeiculoDao veiculoDao = new VeiculoDao();
		veiculoDao.getVeiculoFromBD();

/*************************************************************************************************/

		
		
//		List<Reserva> re = rDao.getReserva(4);
		
		ReservaController rsc = new ReservaController();
		
//		rsc.createReserva("12/12/2018", "17/12/2018", 150, 2, 1);
		rsc.listaReservas();
	

		
		
		CalculosReserva cv = new CalculosReserva();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}/* FIM */
