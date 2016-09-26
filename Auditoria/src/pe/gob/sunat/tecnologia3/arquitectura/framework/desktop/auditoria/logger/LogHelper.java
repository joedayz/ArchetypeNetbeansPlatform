/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.auditoria.logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 *
 * @author Edwin Farfan
 */
public final class LogHelper {

    private static LogManager logManager;

    static Logger logger = Logger.getLogger(ContextLogs.class.getName());

    static {
        logManager = LogManager.getLogManager();
        InputStream fis;
        try {
            fis = LogHelper.class.getClassLoader().getResourceAsStream("logging.properties");
            logManager.readConfiguration(fis);
        } catch (IOException ex) {
            Logger.getLogger(LogHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void log(long last, String methodName, String params,String modulo) {
        logger.log(Level.INFO, mensaje(last, methodName, params, modulo));

    }

    private static String mensaje(long last, String methodName, String params, String modulo) {
        StringBuilder msg = new StringBuilder();
        msg.append(String.format(" Modulo: [%s]", modulo));
        msg.append(String.format(" Metodo: [%s]", methodName));
        msg.append(String.format(" Argumentos: [%s]", params));
        msg.append(String.format(" Duracion del metodo: [%s]", last));

        return msg.toString();
    }

//    public static void trace(Object source, String msg, Object[] args) {
//
//        logger(source);//.trace(format(msg, args));
//    }
//
//    private static org.slf4j.Logger logger(Object source) {
//        org.slf4j.Logger logger;
//
//        if ((source instanceof Class)) {
//            logger = LoggerFactory.getLogger((Class) source);
//        } else if ((source instanceof String)) {
//            logger = LoggerFactory.getLogger((String) String.class.cast(source));
//        } else {
//            logger = LoggerFactory.getLogger(source.getClass());
//        }
//        if ("org.slf4j.impl.Log4jLoggerAdapter".equals(logger.getClass().getName())) {
//            try {
//                Field fqcn = logger.getClass().getDeclaredField("FQCN");
//
//                setFinalStatic(fqcn, LogHelper.class.getName());
//            } catch (NoSuchFieldException ex) {
//                throw new IllegalStateException(ex);
//            } catch (IllegalAccessException ex) {
//                throw new IllegalStateException(ex);
//            }
//        }
//        return logger;
//    }
    

}
