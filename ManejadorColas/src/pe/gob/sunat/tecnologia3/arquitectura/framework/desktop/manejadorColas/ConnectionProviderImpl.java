/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.manejadorColas;

import com.rabbitmq.client.ConnectionFactory;

/**
 *
 * @author Edwin Farfan
 */
public class ConnectionProviderImpl implements ConnectionProvider{

    private String mqHost;

    private Integer mqPort;

    private String mqUsername;

    private String mqPassword;

    private String mqVirtualhost;

    public ConnectionFactory getConnectionFactory() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(mqHost);
//        connectionFactory.setPort(mqPort);
//        connectionFactory.setUsername(mqUsername);
//        connectionFactory.setPassword(mqPassword);
//        connectionFactory.setVirtualHost(mqVirtualhost);
//        connectionFactory.setAutomaticRecoveryEnabled(true);

        return connectionFactory;
    }

    /**
     * @param mqHost the mqHost to set
     */
    public void setMqHost(String mqHost) {
        this.mqHost = mqHost;
    }

    
    
}
