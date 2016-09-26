/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.seguridad.token;

import java.util.ArrayList;
import java.util.Collection;
 
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

/**
 *
 * @author I301324
 */
public class FacebookAuthenticationInfo implements AuthenticationInfo {

    private static final long serialVersionUID = 1L;

    private PrincipalCollection principalCollection;

    public FacebookAuthenticationInfo(){
        
    }
            
    public FacebookAuthenticationInfo(FacebookUserDetails facebookUserDetails, String realmName) {
        Collection<String> principals = new ArrayList<String>();
        principals.add(facebookUserDetails.getId());
        principals.add(facebookUserDetails.getFirstName() + " " + facebookUserDetails.getLastName()); // Is this appropriate is the name not really a Principal ?
        this.principalCollection = new SimplePrincipalCollection(principals, realmName);
    }

    @Override
    public PrincipalCollection getPrincipals() {
        return principalCollection;
    }

    @Override
    public Object getCredentials() {
        return null;// no credentials required
    }
}
