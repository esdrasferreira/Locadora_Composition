package loadora.model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservaValidacao {

	

	public String dateToMySql(Date data) {
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
		
		String dataString = sdf2.format(data);  //converte de DATE para String e o formato de dd/MM/yyyy para yyyy/MM/dd para o Mysql
		
		System.out.println("date to string changed sucessfully");
		
		return dataString;

	}/*dateToString*/
	
	public String dateToString2(Date data) {
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		
		String dataString = sdf2.format(data);  
		
		System.out.println("date to string changed sucessfully"+ dataString);
		
		return dataString;

	}/*dateToString*/
	
	public Date stringToDate(String data) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataDate = sdf.parse(data);//converte de STRING para DATE e formato de  yyyy/MM/dd para dd/MM/yyyy para utilização no JAVA
		
		System.out.println(dataDate);
		return dataDate;
		
		
	}/*stringToDate*/
	
	


	
	
	
	
	
	
	
	
	
	

}/*ReservaValidacao*/
