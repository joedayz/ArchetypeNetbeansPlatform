/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.seguridad.token;

//import gob.pe.sunat.sincronizacion.NetworkConexion;
import org.apache.shiro.authc.AuthenticationToken;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.seguridad.UsuarioPrincipal;

/**
 *
 * @author Edwin Farfan
 */
public class AuthenticationTokenFactory {

    private static UsuarioPrincipal principal;

    public static AuthenticationToken getInstance() {
        if (hasNetConection()) {
            return new OAuth2Token(principal.getPassword());
        }
        return new PlatformAuthToken(principal);
    }

    private static boolean hasNetConection() {
        return false;
        //return NetworkConexion.isInternetConexion();
    }

    public static void setPrincipal(UsuarioPrincipal userPrincipal) {
        principal = userPrincipal;
    }

}
