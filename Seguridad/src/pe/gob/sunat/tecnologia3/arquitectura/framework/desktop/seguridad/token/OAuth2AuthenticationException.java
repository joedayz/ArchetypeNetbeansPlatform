/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.seguridad.token;

import org.apache.shiro.authc.AuthenticationException;

/**
 *
 * @author I301324
 */
public class OAuth2AuthenticationException extends AuthenticationException{
    
    public OAuth2AuthenticationException(Throwable cause) {
        super(cause);
    }
}
