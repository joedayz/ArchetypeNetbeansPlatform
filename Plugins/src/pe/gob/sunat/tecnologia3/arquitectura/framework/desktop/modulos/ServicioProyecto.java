/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.modulos;

import java.util.ArrayList;
import java.util.List;
import org.openide.nodes.ChildFactory;
import org.openide.util.ChangeSupport;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.Proyecto;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.dao.ProyectoDao;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.dao.sqlite.ProyectoDaoSqlite;

/**
 *
 * @author Edwin Farfan
 */
public class ServicioProyecto {

    private static ChangeSupport cs;
    private static ProyectoDao proyectoDao;
    private static List createdArrayList;

    public static ChangeSupport getChangeSupport(ChildFactory.Detachable<BusinessObject> kids) {
        if (cs == null) {
            cs = new ChangeSupport(kids);
        }
        return cs;
    }

    public static List getCreatedArrayList() {

        if (proyectoDao == null) {
            proyectoDao = new ProyectoDaoSqlite();
            if (createdArrayList == null || !createdArrayList.isEmpty()) {
                List<Proyecto> proyectos = proyectoDao.obtenerRegistros();
                createdArrayList = new ArrayList();
                for (Proyecto proy : proyectos) {
                    createdArrayList.add(new BusinessObject(proy));
                }
            }
        }
        return createdArrayList;
    }

}
