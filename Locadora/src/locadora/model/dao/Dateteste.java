package locadora.model.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dateteste {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		
		
		Date teste = format.parse("2018-5-31");
		
		
		System.out.println(teste);
		
		
		
		
		

	}

}
