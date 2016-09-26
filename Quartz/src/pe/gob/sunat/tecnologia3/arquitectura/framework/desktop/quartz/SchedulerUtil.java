/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.quartz;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.Scheduler;

/**
 *
 * @author Edwin Farfan
 */
public class SchedulerUtil {

    private final static Logger logger = Logger.getLogger(SchedulerUtil.class.getName());

    private static final String ORG_QUARTZ_SCHEDULER_INSTANCENAME = "org.quartz.scheduler.instanceName";
    private static final String QUARTZ_PROPERTIES = "quartz.properties";

    private static Properties schedProps = new Properties();

    static {
        try {
            schedProps.load(SchedulerUtil.class.getClassLoader().getResourceAsStream(QUARTZ_PROPERTIES));
        } catch (Exception e) {
            schedProps = null;
            logger.log(Level.WARNING, "Error reading scheduler cfg file " + QUARTZ_PROPERTIES, e);
        }
    }

    /**
     *
     * Obtener una instancia del scheduler con el nombre. cuando el scheduler
     * con este ya existe, devuelve a éste con el mismo nombre. Cuando el nombre
     * es nuevo, una nueva instancia del planificador se crea y la retornará.
     *
     *
     * @param nombre
     * @return
     */
    public static synchronized void getQuartzScheduler(String nombreSchedule) throws Exception {
       
        if (schedProps == null) {
            throw new SchedulerException("Initialization of scheduler properties failed");
        }
        
        schedProps.setProperty(ORG_QUARTZ_SCHEDULER_INSTANCENAME, nombreSchedule);
        executeScheduler();
    }

    private static void executeScheduler() throws SchedulerException {
        Scheduler schedule;
        StdSchedulerFactory schedFact = new StdSchedulerFactory(schedProps);
        schedFact.initialize(schedProps);
        
        schedule = schedFact.getScheduler();
        schedule.start(); 
    }
   
}
