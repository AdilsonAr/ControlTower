package com.controltower.service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

public class EMailSenderService {

  private EMailSenderService() {}

  public static void emailDelivery(String toEmail, String spreadsheetURL) {
    Email from = new Email("ealopezalmira@gmail.com");
    Email to = new Email(toEmail);

    String subject = "Your flights spreadsheets";
    Content content =
        new Content("text/html", "<em></em> <strong>Your spreadsheet info:<br><a href='" + spreadsheetURL+"'> Flights Spreadsheet </a>");

    Mail mail = new Mail(from, subject, to, content);

    // object sendgrid with the api key
    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    Request request = new Request();
    Logger logger = Logger.getLogger(EMailSenderService.class.getName());
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());

      Response response = sg.api(request);

      logger.log(Level.FINE, () -> "Status code: " + response.getStatusCode());
      logger.log(Level.FINE, () -> "Headers: " + response.getHeaders());
      logger.log(Level.FINE, () -> "Body: " + response.getBody());

    } catch (IOException e) {
      logger.log(Level.WARNING,() -> "Error: " + e);
    }
  }
}
