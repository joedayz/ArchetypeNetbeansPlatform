/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.manejadorColas;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.jmq.jmsclient.runtime.BrokerInstance;
import com.sun.messaging.jmq.jmsclient.runtime.ClientRuntime;
import com.sun.messaging.jmq.jmsservice.BrokerEvent;
import com.sun.messaging.jmq.jmsservice.BrokerEventListener;

/**
 *
 * @author Edwin Farfan
 */
public class EmbeddedBrokerExample {
    
    public void run(String[] args) throws Exception{

        // obtain the ClientRuntime singleton object
        ClientRuntime clientRuntime = ClientRuntime.getRuntime();

        // create the embedded broker instance
        BrokerInstance brokerInstance = clientRuntime.createBrokerInstance();

        // convert the specified broker arguments into Properties
        // this is a utility function: it doesn't change the broker
        Properties props = brokerInstance.parseArgs(args);

        // initialise the broker instance 
        // using the specified properties
        // and a BrokerEventListener
        BrokerEventListener listener = new ExampleBrokerEventListener();
        brokerInstance.init(props, listener);

        // now start the embedded broker
        brokerInstance.start();

        System.out.println ("Embedded broker started");

        // now create a direct connection to the embedded broker 
        // this is identical to a normal TCP connection except that a special URL is used
        com.sun.messaging.ConnectionFactory qcf = new com.sun.messaging.ConnectionFactory();
        qcf.setProperty(ConnectionConfiguration.imqAddressList, "mq://localhost/direct");

        Connection connection = qcf.createConnection();
        System.out.println ("Created direct connection to embedded broker");

        // now create a session and a producer and consumer in the normal way 
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("exampleQueue");
        MessageConsumer consumer = session.createConsumer(queue);
        MessageProducer producer = session.createProducer(queue);

        // send a message to the queue in the normal way
        TextMessage textMessage = session.createTextMessage("This is a message");
        producer.send(textMessage);

        // receive a message from the queue in the normal way
        connection.start();
        Message receivedMessage = consumer.receive(1000);
        System.out.println ("Received message "+((TextMessage)receivedMessage).getText());

        // close the client connection
        connection.close();

        // stop the embedded broker
        brokerInstance.stop();

        // shutdown the embedded broker
        brokerInstance.shutdown();

    }

    public static void main(String[] args) throws Exception {

        EmbeddedBrokerExample ebe = new EmbeddedBrokerExample();
        ebe.run(args);
 
    }

    class ExampleBrokerEventListener implements BrokerEventListener {

        public void brokerEvent(BrokerEvent brokerEvent) {
            System.out.println ("Received broker event:"+brokerEvent);
        }

        public boolean exitRequested(BrokerEvent event, Throwable thr) {
            System.out.println ("Broker is requesting a shutdown because of:"+event+" with "+thr);

            // return true to allow the broker to shutdown
            return true;
        }
    }
    
}
