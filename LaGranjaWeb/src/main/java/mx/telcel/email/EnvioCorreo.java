package mx.telcel.email;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

public class EnvioCorreo {
	public static boolean enviaCorreo(String asunto, String mensaje, String destinatarios) {
		boolean resultado = false;
		try {
			// Se compone la parte del texto
			BodyPart texto = new MimeBodyPart();
			texto.setText(mensaje);
			// Se crea una MultiParte para agrupar texto y datos adjuntos.
			MimeMultipart multiParte = new MimeMultipart();
			// Se agrega el texto del mensaje
			multiParte.addBodyPart(texto);
			System.out.println("Se enviar\u00E1 correo a los destinatarios:" + destinatarios + " Asunto:" + asunto);
			// se invoca al metodo de envio de correos
			resultado = enviaCorreos(asunto, multiParte, destinatarios);
		} catch (Exception e) {
			System.out.println("Al tratar de enviar un correo electonico: " + e.getMessage());
		}
		return resultado;
	}

	private static boolean enviaCorreos(String asunto, MimeMultipart multiPart, String destinatarios) {
		boolean resultado = false;
		EnviaEmail emailBean = new EnviaEmail("", "");
		try {
			// Se indica la direccion del remitenteS
			emailBean.setFrom("alexis.luna@mail.telcel.com"); // CORREO DE ORIGEN
			// se agrega el asunto del mensaje
			emailBean.setSubject(asunto);
			emailBean.setTo(destinatarios);
			emailBean.sendMultipartAdjunto(multiPart);
			System.out.println("Envio de correo exitoso");
			resultado = true;
		} catch (AddressException e) {
			System.out.println("Error: " + e);
		} catch (MessagingException e) {
			System.out.println("Error: " + e);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return resultado;
	}
}
