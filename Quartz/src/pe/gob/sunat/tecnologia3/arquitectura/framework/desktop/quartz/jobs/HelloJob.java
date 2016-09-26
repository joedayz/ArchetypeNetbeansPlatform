package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.quartz.jobs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author I301324
 */
public class HelloJob implements Job {

    public void execute(JobExecutionContext jobExecutionContext)
            throws JobExecutionException {
        System.out.println("Hello World -- Executed on : " + new Date());
    }
}
