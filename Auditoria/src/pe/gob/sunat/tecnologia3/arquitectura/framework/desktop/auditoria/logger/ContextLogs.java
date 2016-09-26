/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.auditoria.logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 *
 * @author Edwin Farfan
 */
public class ContextLogs {

    private LogManager logManager;

    static Logger logger = Logger.getLogger(ContextLogs.class.getName());

    public ContextLogs() throws SecurityException, IOException {
        logManager = LogManager.getLogManager();
        FileInputStream fis = new FileInputStream("logging.properties");
        logManager.readConfiguration(fis);
    }

    public void imprimerLogs() {
        logger.log(Level.INFO, "ESTE ES LA IMPRESION DE LOS LOGS.");
        for (String name : Collections.list(logManager.getLoggerNames())) {
            System.out.println(name);
        }
    }


}
