package loadora.model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import locadora.conexao.factory.jdbc.ConexaoException;
import locadora.model.dao.ReservaDao;
import locadora.model.entity.Reserva;

public class ReservaValidacao {

	private ReservaDao rdao;
	private Reserva reserva;
	private CalculosReserva cr;

	public String dateToMySql(Date data) {

		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");

		String dataString = sdf2.format(data); // converte de DATE para String e o formato de dd/MM/yyyy para yyyy/MM/dd
												// para o Mysql

		System.out.println("date to string changed sucessfully");

		return dataString;

	}/* dateToString */

	public String dateToString2(Date data) {

		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

		String dataString = sdf2.format(data);

		System.out.println("date to string changed sucessfully" + dataString);

		return dataString;

	}/* dateToString */

	public Date stringToDate(String data) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // formato JAVA
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");// formato Mysql  detalhe para os traços 

		Date data3 = sdf2.parse(data); // recebe String do Mysql e transforma em DATE
		String dtdd = sdf.format(data3); // transforma DATE format Mysql yyyy para String dd/MM/yyyy

		Date data4 = sdf.parse(dtdd); // transforma String já no formato correto para DATE

		System.out.println(data4);
		return data4;

	}/* stringToDate */

	public boolean reservaDuplic(Date retirada, Date entrega, int idVeiculo) throws ConexaoException, ParseException {
		rdao = new ReservaDao();
		cr = new CalculosReserva();
		
		List<Reserva> re = rdao.getAllReservaBD();
		
		
		for (int i = 0; i<re.size(); i++) {
			LocalDate data1 = this.convertToLocalDate(re.get(i).getDataRetirada());
			LocalDate data2 = this.convertToLocalDate(re.get(i).getDataRetirada());
			CalculosReserva.getDatesBetweenJava9(data1, data2);
			
		}
		
		
		
		return true;
	}

	public LocalDate convertToLocalDate(Date dateToConvert) {
	    return LocalDate.ofInstant(
	      dateToConvert.toInstant(), ZoneId.systemDefault());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}/* ReservaValidacao */
