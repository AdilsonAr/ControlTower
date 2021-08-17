package com.controltower.service;

import java.io.IOException;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;


public class EMailSenderService {

	public static void emailDelivery(String toEmail, String spreadsheetURL) {
		Email from = new Email("ealopezalmira@gmail.com");
	       Email to = new Email(toEmail);

	       String subject = "Your flights spreadsheets";
	       Content content = new Content("text/html", "<em></em> <strong>Your spreadsheet info:<br>"+spreadsheetURL);

	       Mail mail = new Mail(from, subject, to, content);
	       
	       //object sendgrid with the api key
	       SendGrid sg = new SendGrid("API-KEY");
	       Request request = new Request();
	       try {
	    	   request.setMethod(Method.POST);
		       request.setEndpoint("mail/send");
		       request.setBody(mail.build());

		       Response response = sg.api(request);

		       System.out.println(response.getStatusCode());
		       System.out.println(response.getHeaders());
		       System.out.println(response.getBody());
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	       
	}
	
}
