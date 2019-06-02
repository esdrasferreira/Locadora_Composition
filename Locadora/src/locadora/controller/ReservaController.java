package locadora.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	public void createReserva(String dataRetirada, String dataEntrega, double valorPago, int idCliente, int idVeiculo)
			throws ParseException, ConexaoException {

		rv = new ReservaValidacao();

		Date data1 = rv.stringToDate(dataRetirada);
		Date data2 = rv.stringToDate(dataEntrega);

		cr = new CalculosReserva();
		long dias = cr.daysBetween(data1, data2);

		reserva = new Reserva(0, data1, data2, dias, valorPago, idCliente, idVeiculo);

		dao = new ReservaDao();

		dao.insertReserva(reserva);

		System.out.println("....inserido reserva, processo concluido");

	}/* createReserva */

	public void listaReservas() throws ConexaoException, ParseException {

		dao = new ReservaDao();

		List<Reserva> re = dao.getAllReservaBD();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // para formatar a impressão das datas

		System.out.println("Lista de todas as reservas:");
		for (Reserva res : re) {
			System.out.printf(
					"ID user: %d\t|Nome: %s %s\t | ID do veiculo: %02d\t| Modelo: %-20s\t| Diaria:R$ %-15.2f\t| ID reserva:  %02d| Alugado de %s  a %s | Total de dias: %d | Valor pago: R$ %.2f%n",
					res.getIdCliente(), res.getFirstName(), res.getLastName(), res.getIdVeiculo(), res.getModelo(),
					res.getDiaria(), res.getIdReserva(), sdf.format(res.getDataRetirada()),
					sdf.format(res.getDataEntrega()), res.getDiasLocado(), res.getValorPago());
		}

	}/* listaReservas */

}/* ReservaController */
