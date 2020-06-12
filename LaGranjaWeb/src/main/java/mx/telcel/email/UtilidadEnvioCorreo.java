package mx.telcel.email;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.contact.model.PARAMETROS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.telcel.util.*;	

@SuppressWarnings("unused")
public class UtilidadEnvioCorreo{

	private UtilidadEnvioCorreo(){
	}

	public static boolean enviarCorreo(String asunto,String contenido, String destinatarios){
System.out.println("Prepara envio de correo, asunto: "+asunto+" contenido: "+contenido+" destinatarios "+destinatarios);
		return EnvioCorreo.enviaCorreo(asunto, contenido, destinatarios);
	}
   public static void fecha_hora(){ 
			Date date = new Date();
			//Caso 1: obtener la hora y salida por pantalla con formato:
			DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
			System.out.println("Hora: "+hourFormat.format(date));
			//Caso 2: obtener la fecha y salida por pantalla con formato:
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Fecha: "+dateFormat.format(date));
	        Constantes.FECHA_HORA_SERVIDOR = "Fecha: "+dateFormat.format(date)+" Hora "+hourFormat.format(date);	
	}
}
