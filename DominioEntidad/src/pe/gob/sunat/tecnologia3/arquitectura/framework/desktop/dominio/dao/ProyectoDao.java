/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.dao;

import java.util.List;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.Proyecto;

/**
 *
 * @author Edwin Farfan
 */
public interface ProyectoDao extends BaseDao<Proyecto, Integer> {

  public void activarRegistro(Integer id);
  public void desactivarRegistro(Integer id);
  
}
