/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.seguridad;

import java.io.Serializable;

/**
 *
 * @author I301324
 */
public class UsuarioPrincipal implements Serializable {

    private String usuario;
    private String password;
    private String ruc;

    public UsuarioPrincipal(String usuario, String password, String ruc) {
        super();
        this.usuario = usuario;
        this.password = password;
        this.ruc = ruc;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
