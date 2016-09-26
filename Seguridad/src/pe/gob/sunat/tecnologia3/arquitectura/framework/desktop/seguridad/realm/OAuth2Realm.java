/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.seguridad.realm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.StringUtils;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.Usuario;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.dao.UsuarioDao;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.seguridad.token.OAuth2Token;

/**
 *
 * @author Edwin Farfan
 */
public class OAuth2Realm extends BaseRealm {

    private static final String APP_SECRET = "0359179e426ccc5e3fdeb90000327095"; 
    private static final String APP_ID = "1699047167038383"; 
    private static Logger logger = Logger.getLogger(OAuth2Realm.class.getName());

    public void setUserdao(UsuarioDao userdao) {
        userdao = userdao;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        OAuth2Token facebookToken = (OAuth2Token) token;

        if (facebookToken.getAuthCode() != null && facebookToken.getAuthCode().trim().length() > 0) {
            URL authUrl;
            try {

                StringBuffer redirectUri = new StringBuffer();
                redirectUri.append("https://graph.facebook.com/oauth/access_token?client_id=");
                redirectUri.append(APP_ID);
                redirectUri.append("&client_secret=").append(APP_SECRET);
                redirectUri.append("&grant_type=client_credentials");
                redirectUri.append("&redirect_uri=https://graph.facebook.com/oauth/access_token?client_id=");
                redirectUri.append(APP_ID);
                redirectUri.append("&client_secret=").append(APP_SECRET);
                redirectUri.append("&redirect_uri=##facebook.oauth.callback##&client_secret=");
                redirectUri.append(APP_SECRET);
                redirectUri.append("&code=").append(facebookToken.getAuthCode());

                authUrl = new URL(redirectUri.toString());

                String authResponse = readURL(authUrl);
                logger.log(Level.INFO, authResponse);
                String accessToken = getPropsMap(authResponse).get("access_token");
                logger.log(Level.INFO, " Token de acceso..." + accessToken);
//                URL url = new URL("https://graph.facebook.com/"+APP_ID+"?access_token=" + accessToken);
//                String fbResponse = readURL(url);
//                FacebookUserDetails fud = new FacebookUserDetails(fbResponse);
//                return new FacebookAuthenticationInfo(fud, this.getName());
                if (StringUtils.isNotBlank(accessToken)) {
                    userdao.insertarUsuario(new Usuario());
                }
                return null;
            } catch (Throwable e1) {
                e1.printStackTrace();
                throw new AuthenticationException(e1);
            }
        }
        return null;
    }

    private String readURL(URL url) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream is = url.openStream();
        int r;
        while ((r = is.read()) != -1) {
            baos.write(r);
        }
        return new String(baos.toByteArray());
    }

    private Map<String, String> getPropsMap(String someString) {
        String[] pairs = someString.split("&");
        Map<String, String> props = new HashMap<String, String>();
        for (String propPair : pairs) {
            String[] pair = propPair.split("=");
            props.put(pair[0], pair[1]);
        }
        return props;
    }
}
