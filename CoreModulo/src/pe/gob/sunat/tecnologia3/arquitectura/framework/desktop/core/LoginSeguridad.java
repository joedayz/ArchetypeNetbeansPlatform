/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.core;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openide.util.NbBundle;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.core.statusBar.ConnectionStateLine;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.jetty.SimpleWebappServer;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.seguridad.Autenticador;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.seguridad.UsuarioPrincipal;

/**
 *
 * @author Edwin Farfan
 */
public final class LoginSeguridad {
    private static Autenticador autenticacion;
    private static  Logger log = Logger.getLogger(LoginSeguridad.class.getName());  
    
    public static String autenticacionSeguridad(UsuarioPrincipal principal) {
        String errorAutentificacion = null;
        try {
            autenticacion = Autenticador.getInstance();
            if (autenticacion.validarAutenticacion(principal)) {
//                    CargaCentral.cargaMQ();
                ConnectionStateLine.setMessage(principal.getUsuario());
                
                SimpleWebappServer server = new SimpleWebappServer();
                server.startWebServer();
            }
        } catch (Throwable e) {
            log.log(Level.SEVERE,e.getMessage());
            errorAutentificacion = NbBundle.getMessage(LoginSeguridad.class, "usuario.credenciales.invalidas");
        }
        return errorAutentificacion;
    }

}
