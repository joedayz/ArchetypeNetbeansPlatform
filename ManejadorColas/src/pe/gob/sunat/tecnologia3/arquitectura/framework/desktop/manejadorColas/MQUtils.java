/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.manejadorColas;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author Edwin Farfan
 */
public final class MQUtils {

    private static ConnectionProvider connectionProvider;

    private static Connection connection;

    private static Channel channel;

    public final static String QUEUE_NAME = "MQPlatform";

    private static void init() {
        connectionProvider = new ConnectionProviderImpl();
        connectionProvider.setMqHost("localhost");
    }

    public static void enviarMensaje(String mensaje) throws IOException, TimeoutException {
        init();

        connection = connectionProvider.getConnectionFactory().newConnection();
        channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
   
        channel.basicPublish("", QUEUE_NAME, null, mensaje.getBytes());
        System.out.println(" [x] Sent '" + mensaje + "'");
        cerrarConexion();
    }

    private static void cerrarConexion() throws IOException, TimeoutException {

        channel.close();
        connection.close();
    }

}
