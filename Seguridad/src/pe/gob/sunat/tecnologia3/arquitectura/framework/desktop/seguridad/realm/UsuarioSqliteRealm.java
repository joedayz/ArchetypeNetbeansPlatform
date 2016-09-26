/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.seguridad.realm;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Set;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.dao.UsuarioDao;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.seguridad.token.PlatformAuthToken;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.Usuario;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.seguridad.UsuarioPrincipal;

/**
 *
 * @author Edwin Farfan
 */
public class UsuarioSqliteRealm extends BaseRealm {

    private static Logger logger = Logger.getLogger(UsuarioSqliteRealm.class.getName());
    

    public UsuarioSqliteRealm() {
        super();
    }

    @Override
    public void setUserdao(UsuarioDao userdao) {
        this.userdao = userdao;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        if (token instanceof PlatformAuthToken) {
            logger.log(Level.INFO, "support PlatformauthToken");
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return getClass().getName();//"UsuarioSqliteRealm";
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        logger.log(Level.INFO, "entrando al metodo doGetAuthenticationInfo.");
        if (!PlatformAuthToken.class.isInstance(token)) {
            logger.log(Level.SEVERE, "token no soportado " + token.getClass().getName(), token);
            throw new UnsupportedTokenException();
        }

        String nombreUsuario = ((PlatformAuthToken) token).getPrincipal();
        UsuarioPrincipal usuarioRealm = getUsuarioFromDB(nombreUsuario);

        return new SimpleAuthenticationInfo(usuarioRealm, usuarioRealm.getPassword(), getName());

    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        int usernId = ((Usuario) principals.getPrimaryPrincipal()).getId();
        Set<String> roleNames = null;
        roleNames = userdao.getRoleDelUsuario(usernId);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        return info;
    }

   

}
