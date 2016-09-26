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
public interface ConnectionProvider {
    
    void setMqHost(String mqHost);
    ConnectionFactory getConnectionFactory();
}
