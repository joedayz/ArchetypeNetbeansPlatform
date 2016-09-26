/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import static pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.manejadorColas.Constantes.QUEUE_NAME;

/**
 *
 * @author Edwin Farfan
 */
public class SendMessage {

    

    public static void main(String[] argv) throws Exception {

    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost ("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.queueDeclare (QUEUE_NAME, false, false, false, null);
    String message = "Message 004!";

    channel.basicPublish ("", QUEUE_NAME, null, message.getBytes());
    System.out.println (" [x] Sent '" + message + "'");
	
    channel.close();
    connection.close();
  }
   
}
