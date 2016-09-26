/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.seguridad;

//import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.auditoria.LoggerAnnotation;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.openide.util.NbBundle;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.seguridad.token.AuthenticationTokenFactory;

/**
 *
 * @author Edwin Farfan
 */
public class Autenticador {

    private static final String SHIRO_FILE_CONFIG = "classpath:shiro.ini";
    private static Autenticador instance = null;
    private SPSession session;
    private Subject currentUser;
    private final Logger logger = Logger.getLogger(Autenticador.class.getName());

    private Autenticador() {
    }

    public static Autenticador getInstance() {
        if (instance == null) {
            instance = new Autenticador();
        }
        return instance;
    }

    private Subject autenticar(UsuarioPrincipal principal) {
        logger.log(Level.INFO, "(class)Autenticador.autenticar...");

        try {
            SecurityUtils.setSecurityManager(getSecurityManager());

            currentUser = getSubject();

            AuthenticationTokenFactory.setPrincipal(principal);
            AuthenticationToken token = AuthenticationTokenFactory.getInstance();

            currentUser.login(token);
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            String messageError = NbBundle.getMessage(Autenticador.class, "usuario.no.autenticado.db", principal.getUsuario());
            throw new AuthenticationException(messageError, e);
        }
        return currentUser;
    }

    private SecurityManager getSecurityManager() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(SHIRO_FILE_CONFIG);
        SecurityManager securityManager = factory.getInstance();
        return securityManager;
    }

//    @LoggerAnnotation(modulo = "Seguridad")
    public boolean validarAutenticacion(UsuarioPrincipal principal) throws Throwable {

        currentUser = autenticar(principal);
        logger.log(Level.INFO, "Objeto Principal:::: {0}", currentUser.getPrincipal());

        return currentUser.isAuthenticated();
    }

    private static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    private SPSession getSession() {
        return (SPSession) getSubject().getSession();
    }

    public boolean isAuthenticated() {
        return getSubject().isAuthenticated();
    }

    public boolean getRole(String roleName) {
        return getSubject().hasRole(roleName);
    }

    public UsuarioPrincipal getUsuarioLogeado() {
        return (UsuarioPrincipal) getSubject().getPrincipal();
    }

    public void logout() {
        SecurityUtils.getSecurityManager().logout(currentUser);
    }
}
