/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.dao.sqlite;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.QueryRunner;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.Proyecto;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.dao.ProyectoDao;

/**
 *
 * @author Edwin Farfan
 */
public class ProyectoDaoSqlite extends BaseDaoSqlite<Proyecto, Integer> implements ProyectoDao{

    private static final String nombreTabla= "proyecto";
    Logger logger = Logger.getLogger(ProyectoDaoSqlite.class.getName());
    
    public ProyectoDaoSqlite() {
        super(Proyecto.class);
        setNombreTabla(nombreTabla);
    }

    @Override
    public void activarRegistro(Integer id) {
      
        actualizarEstado(id,1);
    }

    @Override
    public void desactivarRegistro(Integer id) {
        actualizarEstado(id,0);
        
    }

    private void actualizarEstado(Integer id, Integer estado){
         try {
            QueryRunner run = new QueryRunner();
            int result = run.update(getConexion(), "update Proyecto set activo=? where id=?", estado, id);
            logger.log(Level.INFO,"id del registro que se actualizo: {0} con el estdo: {1} y con el id: {2}",new Object[]{result, estado, id} );
        } catch (SQLException ex ) {
            logger.log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }


   
}
