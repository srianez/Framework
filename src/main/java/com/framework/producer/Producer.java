package com.framework.producer;

import java.io.File;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.framework.cupomfiscal.PDFtoByte;

public class Producer {
    
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    
    private static String subject = "Teste";
    
    public static void main(String[] args) throws JMSException {
        File dir = new File("/Users/dnoda/cupons/");
        File[] directoryListing = dir.listFiles();
        
        if (directoryListing != null) {
          for (File invoice : directoryListing) {
            System.out.println("*****\n\n\n\n" + invoice.getAbsolutePath() + "\n\n\n\n*****");
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = (Connection) connectionFactory.createConnection();
            connection.start();
        
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
            Destination destination = session.createQueue(subject);
        
            MessageProducer producer = session.createProducer(destination);
        
//        TextMessage message = session.createTextMessage("Olá, tudo bem?");
        
            BytesMessage bytesMessage = session.createBytesMessage();
            bytesMessage.writeBytes(PDFtoByte.convert(invoice));
        
            producer.send(bytesMessage);
            System.out.println("Sentage");

            connection.close();
         }
      } 
   }
}