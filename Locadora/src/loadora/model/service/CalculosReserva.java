package loadora.model.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import locadora.model.entity.Reserva;

public class CalculosReserva {
	
	private ReservaValidacao rv;
	
	public long daysBetween(Reserva idReserva) {
		
		rv = new ReservaValidacao();
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Date retiradaDate = idReserva.getDataRetirada();
		Date entregaDate = idReserva.getDataRetirada();
		
		String retiradaString = rv.dateToString2(retiradaDate);
		String entregaString = rv.dateToString2(entregaDate);
		
		
		LocalDate retiradaLD = LocalDate.parse(retiradaString, formato);
		LocalDate entregaLD = LocalDate.parse(entregaString, formato);
		
		long daysbetween = ChronoUnit.DAYS.between(retiradaLD, entregaLD);
		
		
		return daysbetween;

		

	} /* calculaDias */
	
public long daysBetween(Date retirada, Date entrega) {
		
		rv = new ReservaValidacao();
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		
//		Date retiradaDate = retirada;
//		Date entregaDate = entrega;
		
		String retiradaString = rv.dateToString2(retirada);
		String entregaString = rv.dateToString2(entrega);
		
		
		LocalDate retiradaLD = LocalDate.parse(retiradaString, formato);
		LocalDate entregaLD = LocalDate.parse(entregaString, formato);
		
		long daysbetween = ChronoUnit.DAYS.between(entregaLD, retiradaLD);
		
		
		return daysbetween;

		

	} /* calculaDias */
	
	
	
	

}