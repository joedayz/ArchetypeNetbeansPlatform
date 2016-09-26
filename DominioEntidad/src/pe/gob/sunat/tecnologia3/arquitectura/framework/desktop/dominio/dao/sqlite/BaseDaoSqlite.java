/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.dao.sqlite;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.dao.BaseDao;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.sqlite.SqliteConnection;

/**
 *
 * @author Edwin Farfan
 */
public class BaseDaoSqlite<T, PK extends Serializable> implements BaseDao<T, PK> {

    private static Logger logger = Logger.getLogger(UsuarioDaoSqlite.class.getName());
    private Class<T> entidad;
    private Connection conexion;
    private String nombreTabla;

    public BaseDaoSqlite(final Class<T> entidad) {
        this.entidad = entidad;
    }

    protected Connection getConexion() throws Exception {
        if (conexion == null) {
            conexion = SqliteConnection.getInstance().getConnection();
        }
        return conexion;
    }

    @Override
    public List<T> obtenerRegistros() {
        List<T> object = null;
        logger.log(Level.INFO, "metodo: obtenerRegistros...");
        try {
            StringBuffer sqlQuery = new StringBuffer();
            sqlQuery.append("select * from ");
            sqlQuery.append(nombreTabla);
            sqlQuery.append(" where status=1 ");

            QueryRunner queryRunner = new QueryRunner();
            ResultSetHandler blh = new BeanListHandler(entidad);

            object = (List<T>)queryRunner.query(getConexion(), sqlQuery.toString(), blh);

            logger.log(Level.INFO, "Ejecutor el query.");
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error en el query.{0}", ex.getMessage());
        } 
       return object;
    }

    protected void cerrarConexion()  {
        DbUtils.closeQuietly(conexion);
        logger.log(Level.INFO, "Cerrando conexion de sqlite");
    }
    
    @Override
    public T entidadPorId(PK id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registroExiste(PK id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T guardar(T object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarRegistro(PK id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setNombreTabla(String tabla){
        this.nombreTabla = tabla;
    }

}
