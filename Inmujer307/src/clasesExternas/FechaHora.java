package clasesExternas;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class FechaHora {
	Calendar datos = new GregorianCalendar();
	//La clase Calendar permite extraer datos de fecha
	//y hora del sistema
	
	//Extraemos el dia del sistema y se almacena en la variable día
	private String dia = String.valueOf(datos.get(Calendar.DATE));
	private String diaSemana = String.valueOf(datos.get(Calendar.DAY_OF_WEEK)-1);
	private String mes = String.valueOf(datos.get(Calendar.MONTH)+1);
	private String anio = String.valueOf(datos.get(Calendar.YEAR));
	
	private String hora = String.valueOf(datos.get(Calendar.HOUR_OF_DAY));
	private String minutos = String.valueOf(datos.get(Calendar.MINUTE));
	
	private String fechaCorta = "";
	private String fechaLarga = "";
	private String horaCompleta = "";
	private String diaMesAnio = "";
	
	public String obtenerFechaCorta() {
		// Obtener la fecha en el formato  dd/mm/aaaa
		String d = "";
		String m = "";
		
		if (dia.length()==1) {
			d = "0"+dia;
		} else {
			d = dia;
		}
		
		if (mes.length()== 1) {
			m = "0"+mes;
		} else {
			m = mes;
		}
		
		
		fechaCorta = d+"/"+m+"/"+anio;
		
		return fechaCorta;
	}
	public String obtenerFechaCortainversa() {
		// Obtener la fecha en el formato  dd/mm/aaaa
		String d = "";
		String m = "";
		
		if (dia.length()==1) {
			d = "0"+dia;
		} else {
			d = dia;
		}
		
		if (mes.length()== 1) {
			m = "0"+mes;
		} else {
			m = mes;
		}
		
		
		fechaCorta = anio+"/"+m+"/"+d;
		
		return fechaCorta;
	}
	
	public String obtenerFechaLarga() {
		//Obtener la fecha larga, ejemplo <viernes 04 de octubre de 2024>
		String d = ""; //Se almacena el dia de la semana (lunes-domingo)
		String date = ""; //Se almacena el día del mes (1-31)
		String m = ""; //Se almacena el nombre del mes (enero a Diciembre)
		
		if (dia.length()==1) {
			date = "0"+dia;
		} else {
			date = dia;
		}
		
		if (diaSemana.equals("1")) {
			d = "lunes";
		}else if (diaSemana.equals("2")) {
			d = "martes";
		}else if (diaSemana.equals("3")) {
			d = "miércoles";
		}else if (diaSemana.equals("4")) {
			d = "jueves";
		}else if (diaSemana.equals("5")) {
			d = "viernes";
		}else if (diaSemana.equals("6")) {
			d = "sábado";
		}else if (diaSemana.equals("7")) {
			d = "domingo";
		}
		
		if (mes.equals("1")) {
			m = "enero";
		}else if (mes.equals("2")) {
			m = "febrero";
		}else if (mes.equals("3")) {
			m = "marzo";
		}else if (mes.equals("4")) {
			m = "abril";
		}else if (mes.equals("5")) {
			m = "mayo";
		}else if (mes.equals("6")) {
			m = "junio";
		}else if (mes.equals("7")) {
			m = "julio";
		}else if (mes.equals("8")) {
			m = "agosto";
		}else if (mes.equals("9")) {
			m = "septiembre";
		}else if (mes.equals("10")) {
			m = "octubre";
		}else if (mes.equals("11")) {
			m = "noviembre";
		}else if (mes.equals("12")) {
			m = "diciembre";
		}
		
		fechaLarga = d + " " + date + " de " + m + " de " + anio;
		
		return fechaLarga;
	}
	
	public String obtenerHoraCompleta() {
		//Este metodo retorna la hora en formato: <hh:mm hrs.>
		
		String h = "";
		String m = "";
		
		if (hora.length()==1) {
			h= "0"+hora;
		}else {
			h = hora;
		}
		
		if (minutos.length() == 1) {
			m = "0"+minutos;
		} else {
			m = minutos;
		}
		
		horaCompleta = h+":"+m+" hrs.";
		
		return horaCompleta;
	}
	public String obtenerDiaMesAnio() {
		String d = "";
		String m = "";
		String a = "";
		if (dia.length()==1) {
			d = "0"+dia;
		} else {
			d = dia;
		}
		
		if (mes.equals("1")) {
			m = "Enero";	
		}else if (mes.equals("2")) {
			m = "Febrero";
		}else if (mes.equals("3")) {
			m = "Marzo";
		}else if (mes.equals("4")) {
			m = "Abril";
		}else if (mes.equals("5")) {
			m = "Mayo";
		}else if (mes.equals("6")) {
			m = "Junio";
		}else if (mes.equals("7")) {
			m = "Julio";
		}else if (mes.equals("8")) {
			m = "Agosto";
		}else if (mes.equals("9")) {
			m = "Septiembre";
		}else if (mes.equals("10")) {
			m = "Octubre";
		}else if (mes.equals("11")) {
			m = "Noviembre";
		}else if (mes.equals("12")) {
			m = "Diciembre";
		}
		
		diaMesAnio = d + " de " +m+" de "+anio;
		return diaMesAnio;
	}
}
