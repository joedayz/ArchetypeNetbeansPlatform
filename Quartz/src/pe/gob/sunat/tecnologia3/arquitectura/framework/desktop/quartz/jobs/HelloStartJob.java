package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.quartz.jobs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Date;
import org.quartz.Job;
import static org.quartz.JobBuilder.newJob;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author I301324
 */
public class HelloStartJob implements Job {

    
    private String name;
    private String group;
    private String description;
    
    public void execute(JobExecutionContext jobExecutionContext)
            throws JobExecutionException {
        System.out.println("Hello Start Job -- Executed on : " + new Date());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
