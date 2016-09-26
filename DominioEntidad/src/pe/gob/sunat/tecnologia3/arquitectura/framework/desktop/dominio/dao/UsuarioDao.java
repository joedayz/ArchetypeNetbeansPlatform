/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.dao;

import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.Usuario;
import java.util.Set;


/**
 *
 * @author I301324
 */
public interface UsuarioDao {
    
    Usuario buscarUsuario(String usuario); 
    
    Set<String> getRoleDelUsuario(int usuario);
    
    void insertarUsuario(Usuario usuario)throws Exception;
    
}
