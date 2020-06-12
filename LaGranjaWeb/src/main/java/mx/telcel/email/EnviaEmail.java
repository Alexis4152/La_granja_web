package mx.telcel.email;

import java.util.Properties;
//ALEXIS 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

class MoreOneRcptException extends Exception {

	private static final long serialVersionUID = 1L;

	public String toString() {
		return "Debe especificar solamente una cuenta de correo por cada Invocacion del Metodo 'setTo()'.";
	}
}

class OtherDomainException extends Exception {
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "El dominio de la cuenta de envio debe ser @mail.telcel.com";
	}
}

public class EnviaEmail {
	/* Constantes */

	/** Variables */
	private Properties props = new Properties();
	private String from, content, to, subject = "";

	/*
	 * Establece el <I>'content'</I> del mensaje para el envio de correo.
	 * 
	 * @param content Recibe una cadena con el contenido del mensaje de correo.
	 */
	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	/*
	 * Establece al <I>'REMITENTE'</I> del correo.
	 * 
	 * @param from Recibe una cadena con el remitente del correo.
	 */
	public void setFrom(String from) throws OtherDomainException {
		if (from.indexOf('@') == -1) {
			throw new OtherDomainException();
		}
		this.from = from;
	}

	public String getFrom() {
		return from;
	}

	/**
	 * Establece el <I>'ASUNTO'</I> del mensaje que se va a enviar.
	 * 
	 * @param subject Recibe una cadena con el asunto del mensaje que se va a
	 *                enviar.
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	/*
	 * Establece la(s) <I>'DIRECCION(ES)'</I> de correo a las cuales se desea enviar
	 * el mensaje.
	 * 
	 * @author (MODIFICACION) JCMJ Se modifica la funcionalidad
	 * 
	 * @param to Recibe una cadena con la(s) direccion(es) del correo separadas por
	 * "," en caso de ser mas de una direccion.<BR> <I>ejemplo:</I>
	 * "direccion1@mail.telcel.com<B>,</B>direccion2@mail.telcel.com<B>,</B>...<B>,</B>direccionN@mail.telcel.com"
	 */
	public void setTo(String to) throws MoreOneRcptException {
		this.to = to;
	}

	public String getTo() {
		return to;
	}

	/*
	 * Constructor
	 * 
	 * @param host smtp.telcel.com
	 * 
	 * @param user user de correo
	 * 
	 * @param password password del usuario
	 */
	public EnviaEmail(String user, String password) {
		props = new Properties();

		/**
		 * Aqui debe cargarse desde el archivo el dato del host para enviar el correo
		 **/
		/** y paserlo a la variable host **/

		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", "smtp.telcel.com");
		//props.setProperty("mail.user", "gustavo.segundo@telcel.com");// CORREO DESTINATARIO
		props.setProperty("mail.user", "alexis.luna@mail.telcel.com");// CORREO DESTINATARIO
		props.setProperty("mail.password", "");
	}

	/**
	 * Envia un correo multipart
	 * 
	 * @throws MessagingException
	 * @throws AddressException
	 */
	public void sendMultipartAdjunto(MimeMultipart multiPart) throws MessagingException {
		Session mailSession = Session.getInstance(this.props, null);

		mailSession.setDebug(true);
		Transport transport = mailSession.getTransport();
		MimeMessage message = new MimeMessage(mailSession);
//		message.addHeader("Disposition-Notification-To","umendoza@everis.com")
		message.setSubject(this.getSubject());
		message.setFrom(new InternetAddress(this.getFrom()));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.getTo(), false));
		//message.addHeader("X-Priority", "1");// MARCA EL MENSAJE CON PRIORIDAD ALTA
	  //  message.addHeader("Disposition-Notification-To","alexis.luna@mail.telcel.com");
		// put everything together
		message.setContent(multiPart);
		transport.connect();
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}

}