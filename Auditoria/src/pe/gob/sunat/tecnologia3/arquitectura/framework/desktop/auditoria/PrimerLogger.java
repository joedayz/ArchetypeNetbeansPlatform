/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.auditoria;

/**
 *
 * @author Edwin Farfan
 */
public class PrimerLogger {
 
    @LoggerAnnotation(modulo = "first logger")
    public static void Imprime(String argv) {
        System.out.println(argv);
    }
    
     
    public static String NoImprime(String argv) {
        System.out.println(argv);
        return "";
    }
    
}
