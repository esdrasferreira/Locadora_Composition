package locadora.controller;

import java.text.ParseException;
import java.util.Date;

import loadora.model.service.CalculosReserva;
import loadora.model.service.ReservaValidacao;
import locadora.conexao.factory.jdbc.ConexaoException;
import locadora.model.dao.ReservaDao;
import locadora.model.entity.Reserva;

public class ReservaController {

	
	private ReservaDao dao;
	private Reserva reserva;
	private ReservaValidacao rv;
	private CalculosReserva cr;

	public ReservaController() throws ConexaoException {
		this.dao = new ReservaDao();
	}
	
	public void createReserva(String dataRetirada, String dataEntrega, double valorPago, int idCliente, int idVeiculo ) throws ParseException, ConexaoException {
		
				
		rv = new ReservaValidacao();
		
		
		Date data1 = rv.stringToDate(dataRetirada);
		Date data2 = rv.stringToDate(dataEntrega);
		
		cr = new CalculosReserva();
		long dias = cr.daysBetween(data1, data2);
		
		reserva = new Reserva(0, data1, data2, dias, valorPago, idCliente, idVeiculo);
		
		dao = new ReservaDao();
		
		dao.insertReserva(reserva);
		
		
		
           System.out.println("....inserido reserva, processo concluido");

		
	}
	
	
	
	
	
	
}
