/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio;

/**
 *
 * @author Edwin Farfan
 */
public class Roles {
    
    private int id;
    private String roleNombre;
    private Usuario usuario;

    
    
    /**
     * @return the roleNombre
     */
    public String getRoleNombre() {
        return roleNombre;
    }

    /**
     * @param roleNombre the roleNombre to set
     */
    public void setRoleNombre(String roleNombre) {
        this.roleNombre = roleNombre;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
}
