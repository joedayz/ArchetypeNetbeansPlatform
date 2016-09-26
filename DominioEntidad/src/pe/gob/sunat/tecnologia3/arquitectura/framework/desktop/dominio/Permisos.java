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
public class Permisos {
    
    private String permisos;
    private Roles rol;

    /**
     * @return the permisos
     */
    public String getPermisos() {
        return permisos;
    }

    /**
     * @param permisos the permisos to set
     */
    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    /**
     * @return the rol
     */
    public Roles getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Roles rol) {
        this.rol = rol;
    }
    
    
}
