/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.seguridad.realm;

import org.apache.shiro.realm.AuthorizingRealm;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.Usuario;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.dao.UsuarioDao;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.seguridad.UsuarioPrincipal;

/**
 *
 * @author Edwin Farfan
 */
public abstract class BaseRealm extends AuthorizingRealm {

    protected UsuarioDao userdao;

    public abstract void setUserdao(UsuarioDao userdao);

    protected UsuarioPrincipal getUsuarioFromDB(final String nombreUsuario) {
        Usuario user = userdao.buscarUsuario(nombreUsuario);
        return new UsuarioPrincipal(user.getUsuario(), user.getPassword(), user.getRuc());
    }
}
