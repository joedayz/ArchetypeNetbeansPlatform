package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.seguridad.token;

import org.apache.shiro.authc.AuthenticationToken;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.seguridad.UsuarioPrincipal;

/**
 *
 * @author Edwin Farfan 
 */
public class PlatformAuthToken implements AuthenticationToken {

    private String username;
    private String credential;
    private String ruc;

    public PlatformAuthToken(UsuarioPrincipal principal){
        this.username = principal.getUsuario();
        this.credential =  principal.getPassword();
        this.ruc = principal.getRuc();
    }
    
    @Override
    public String getPrincipal() {
        return username;
    }

    @Override
    public String getCredentials() {
        return credential;
    }
    
    public String getRuc(){
        return ruc;
    }
    
}
