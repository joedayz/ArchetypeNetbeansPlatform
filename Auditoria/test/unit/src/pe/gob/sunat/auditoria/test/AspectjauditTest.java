/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.auditoria.test;

import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.auditoria.PrimerLogger;


/**
 **
 *
 * @author Edwin Farfan
 */

  
public class AspectjauditTest {
   
    public static void main(String[] argv) {
       PrimerLogger.Imprime("Test Aspectj1...");
       
       PrimerLogger.NoImprime("No Imprime el aspecto before ...");
    }

}
