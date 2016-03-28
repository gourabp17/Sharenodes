package com.cportal.model.mailservice;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

public class MailGun {

	public void sendMail(String emailid) {
		String to = emailid;
		String from = "no-reply@sharenodes.com";
		String host = "localhost";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.port", "25");
		Session session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from, "Reset Password"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			message.setSubject("Reset password Sharenodes");
			message.setText("farji@farji.com");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException | UnsupportedEncodingException mex) {
			mex.printStackTrace();
		}
	}
	public void sendVerificationMail(String emailid, String uEmail, String uCode) {
		String to = emailid;
		String from = "no-reply@sharenodes.com";
		String host = "localhost";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.port", "25");
		Session session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from, "Verify Account"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			message.setSubject("Verify your Account");
			message.setText("www.sharenodes.com/verify_account?email="+uEmail+"&code="+uCode);

			// Send message
			Transport.send(message);
		} catch (MessagingException | UnsupportedEncodingException mex) {
			mex.printStackTrace();
		}
	}
	public static void main(String args[]) {
		MailGun mg = new MailGun();
		mg.sendMail("gourab.p17@gmail.com");
	}

	
}
