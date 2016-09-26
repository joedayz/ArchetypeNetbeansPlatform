/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.dao.sqlite;

import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.Roles;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.Usuario;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.dao.UsuarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.auditoria.LoggerAnnotation;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.sqlite.SqliteConnection;

/**
 *
 * @author Edwin Farfan
 */
public class UsuarioDaoSqlite extends BaseDaoSqlite<Usuario, Integer> implements UsuarioDao {

    
    private static Logger logger = Logger.getLogger(UsuarioDaoSqlite.class.getName());

    private static final String nombreTabla= "Usuario";
    
    public UsuarioDaoSqlite() {
        super(Usuario.class);
        setNombreTabla(nombreTabla);
    }
    
    private final String sqlUsuarioQuery = "select * from usuario where ";
    private PreparedStatement ps;
    private ResultSet rs;

//    private Connection getConexion() throws Exception {
//        if (conexion == null) {
//            conexion = SqliteConnection.getInstance().getConnection();
//        }
//        return conexion;
//    }

    private boolean existeUsuario(int id) throws Exception {
        String sqlQuery = sqlUsuarioQuery + "id=?";
        ps = getConexion().prepareStatement(sqlQuery);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        if (rs.next()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    @LoggerAnnotation(modulo = "Dominio Model")
    public Usuario buscarUsuario(String nombreUsuario) {
        logger.log(Level.INFO, "metodo: buscarUsuario...{0}", nombreUsuario);
        List<Usuario> listaUsuarios= new ArrayList<Usuario>();
        try {
            String sqlQuery = sqlUsuarioQuery + "usuario =? and status=1";
            
            QueryRunner queryRunner = new QueryRunner();
            ResultSetHandler blh = new BeanListHandler(Usuario.class);
            
            listaUsuarios = (List<Usuario>)queryRunner.query(getConexion(), sqlQuery, blh, nombreUsuario);
            if(listaUsuarios!=null && !listaUsuarios.isEmpty()){
                return listaUsuarios.get(0);
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error en el query." + ex.getMessage());
        } 
        return null;
    }

//    private void cerrarConexion() throws SQLException {
//        rs.close();
//        ps.close();
//        logger.log(Level.INFO, "Cerrando conexion de sqlite");
//    }

    @Override
    @LoggerAnnotation(modulo = "Model")
    public Set<String> getRoleDelUsuario(int usuario) {
        logger.log(Level.INFO, "metodo: getRoleDelUsuario..." + usuario);
        Set<String> roleNames = new LinkedHashSet();
        try {
            String selectQuery = "select r.rol_id as id , r.rol_name as nombre from rol r,  rol_usuario ru ";
            String whereQuery = " where ru.usuario_id =? and ru.rol_id= r.rol_id  and r.status=?";

            String sqlQuery = selectQuery + whereQuery;
            logger.log(Level.INFO, "Query para obtener los roles %s", sqlQuery);
            ps = getConexion().prepareStatement(sqlQuery);
            ps.setInt(1, usuario);
            ps.setInt(2, 1);
            rs = ps.executeQuery();

            while (rs.next()) {
                Roles rol = new Roles();

                rol.setId(rs.getInt(rs.findColumn("id")));
                rol.setRoleNombre(rs.getString(rs.findColumn("nombre")));
                roleNames.add(rol.getRoleNombre());
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error en el query." + ex.getMessage());
        }
        return roleNames;
    }

    @LoggerAnnotation(modulo = "Model")
    public void insertarUsuario(Usuario usuario) throws Exception {

        logger.log(Level.SEVERE, "metodo: insertarUsuario/update ...");

        if (usuario.getId() != 0 && existeUsuario(usuario.getId())) {
            updateUsuario(usuario);
        } else {
            StringBuffer insertQuery = new StringBuffer();
            insertQuery.append("insert into usuario VALUES ");
            insertQuery.append("(?,?,?,?,?,?,?)");
            ps = getConexion().prepareStatement(insertQuery.toString());

            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getPassword());
            ps.setString(4, usuario.getRuc());
            ps.setInt(5, 1);
            ps.setInt(6, 1);
            ps.executeUpdate();

            logger.log(Level.INFO, "ejecuto la sentencia de insert para el usuarioID=  " + usuario.getId());
        }
    }

    @LoggerAnnotation(modulo = "Model")
    public void updateUsuario(Usuario usuario) throws Exception {
        logger.log(Level.INFO, "metodo: insertarUsuario...");

        try {
            StringBuffer updateQuery = new StringBuffer();

            updateQuery.append("update usuario ");
            updateQuery.append("set usuario=? , password=?, ruc=?, status=?, version=?, fecha_modificacion=? ");
            updateQuery.append("where id = " + usuario.getId());

            ps = getConexion().prepareStatement(updateQuery.toString());

            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getPassword());
            ps.setString(4, usuario.getRuc());
            ps.setInt(5, 1);
            ps.setInt(6, 2);
            ps.executeUpdate();

            logger.log(Level.INFO, "ejecuto la sentencia de update para el usuarioID=  " + usuario.getId());
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
            logger.log(Level.SEVERE, ex.getMessage());
        }

    }
}
