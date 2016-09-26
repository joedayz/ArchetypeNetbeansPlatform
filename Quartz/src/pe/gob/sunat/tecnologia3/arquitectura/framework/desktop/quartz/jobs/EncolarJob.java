/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.quartz.jobs;


import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.manejadorColas.MQUtils;

/**
 *
 * @author Edwin Farfan
 */
public class EncolarJob implements Job {

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        try {
            MQUtils.enviarMensaje("este es un mensaje "+ System.currentTimeMillis());
            
        } catch (Exception ex) {
            Logger.getLogger(EncolarJob.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
