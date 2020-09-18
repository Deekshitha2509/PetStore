package com.rest.dto;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

	public class EmailSending {
	public void sendEmail(Services services){

	System.out.println("In mail sending");

	       final String username = "deekshitha25092001@gmail.com";
	       final String password = "07109553404976";
	       
	       String sendMessage = "Your Booking is confirmed\n"
	       		+ "Booking Details:\n"
	       		+ services.getName()+"\n"
	       		+ services.getPetType()+"\n"
	       		+ services.getNumOfDays()+"\n"
	       		+ services.getFromDate()+"\n"
	       		+ services.getServiceAddress()+"\n"
	       		+ services.getPhoneno()+"\n"
	       		+ services.getTotalPrice();
	       		
	       		
	       Properties prop = new Properties();
	       prop.put("mail.smtp.host", "smtp.gmail.com");
	       prop.put("mail.smtp.port", "587");
	       prop.put("mail.smtp.auth", "true");
	       prop.put("mail.smtp.starttls.enable", "true"); //TLS

	       Session session = Session.getInstance(prop,
	               new javax.mail.Authenticator() {
	                   protected PasswordAuthentication getPasswordAuthentication() {
	                       return new PasswordAuthentication(username, password);
	                   }
	               });

	       try {

	           Message message = new MimeMessage(session);
	           message.setFrom(new InternetAddress( "deekshitha25092001@gmail.com"));
	           message.setRecipients(
	                   Message.RecipientType.TO,
	                   InternetAddress.parse("dikshithach123@gmail.com")
	                  
	           );
	           message.setSubject("Confirmation mail ");
	           message.setText(sendMessage);

	           Transport.send(message);

	           System.out.println("Done");

	       } catch (MessagingException e) {
	           e.printStackTrace();
	       }
	   }
	}

	

	


