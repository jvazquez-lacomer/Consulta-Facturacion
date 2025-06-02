package com.lacomer.factura.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderUtils {

	@Value("${mail.smtp.host}")
    private String smtpHost;

    @Value("${mail.from}")
    private String emailorigen;
    
    private static final Logger logger = LoggerFactory.getLogger(EmailSenderUtils.class);
	
	public void enviarCorreo(String email, String passwordTmp) {

		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", smtpHost);
		Session session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailorigen));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("Acceso temporal a la plataforma - Factura Auditoría");

			String htmlContent = "<html><body style='background:#f4f6fb;padding:30px;'>"
					+ "<div style='max-width:500px;margin:auto;background:#fff;border-radius:10px;box-shadow:0 2px 8px #d1d9e6;padding:30px;font-family:Arial,sans-serif;text-align:center;'>"
					+ "<h2 style='color:#2a7ae2;margin-bottom:24px;'>Bienvenido a la plataforma de Factura Auditoría</h2>"
					+ "<p style='font-size:16px;color:#333;margin:0 0 18px 0;'>Se ha generado una <b>contraseña temporal</b> para tu acceso:</p>"
					+ "<div style='margin:24px 0;'>"
					+ "  <span style='display:inline-block;background:#e3f0fc;color:#2a7ae2;font-size:22px;font-weight:bold;padding:12px 32px;border-radius:6px;letter-spacing:2px;'>"
					+ passwordTmp + "</span>" + "</div>"
					+ "<p style='font-size:16px;color:#333;margin:0 0 18px 0;'>Por favor, inicia sesión por primera vez con esta contraseña.<br>Después de ingresar, el sistema te solicitará cambiarla por una contraseña personalizada.</p>"
					+ "<p style='font-size:15px;color:#888;margin:0 0 24px 0;'>Si tienes alguna duda o inconveniente, contacta al área de soporte.</p>"
					+ "<hr style='border:none;border-top:1px solid #eaeaea;margin:32px 0;'>"
					+ "<p style='font-size:15px;color:#2a7ae2;'>Saludos,<br>Equipo de Sistemas La Comer</p>" + "</div>"
					+ "</body></html>";

			message.setContent(htmlContent, "text/html; charset=utf-8");

			Transport.send(message);
		} catch (MessagingException mex) {
			logger.error("Error al enviar el correo", mex);
		}
	}
}