package com.kvtrades.sendMessage.web;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.*;
import com.sun.mail.smtp.*;

public class SendEmail {
	private String username;
	private String userEmail;
	private String subject;
	private String msg;
	private String appEmail = "youremail@mailhost.domain";
	private String appMailPass = "youremailpassword"; 
	
	public SendEmail(String username, String email, String subject, String msg) {
		super();
		this.username = username;
		this.userEmail = email;
		this.subject = subject;
		this.msg = this.username + " sent message,\n" + msg;
	}
	
	public boolean sendMail() {
		boolean isTrue = false;
		Properties properties = new Properties();

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
	      //create the Session object
	      Session session = Session.getInstance(properties,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(appEmail,appMailPass);
	    }
	         });

	    try {
	    //create a MimeMessage object
	    Message message = new MimeMessage(session); 
	    //set From email field 
	    message.setFrom(new InternetAddress(this.appEmail)); 
	    //set To email field
	    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.userEmail)); 
	    //set email subject field
	    message.setSubject(this.subject); 
	    //set the content of the email message
	    message.setContent(this.msg, "text/html");
	    //send the email message
	    Transport.send(message);
	    System.out.println("Email Message Sent Successfully");
	    isTrue = true;

	    } catch (MessagingException e) {
	       throw new RuntimeException(e);
	    }
	    
	    return isTrue;
	}
}
