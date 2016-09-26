/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.sqlite;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.URLMapper;

/**
 *
 * @author I301324
 */
public class SqliteConnection {

    private Connection connection;
    private Logger logger = Logger.getLogger(SqliteConnection.class.getName());
    private static Properties properties;

    
    public static SqliteConnection getInstance() {
        return SQLiteJDBCHolder.INSTANCE;
    }

    private SqliteConnection() {
        try {
            properties = new Properties();
            properties.load(getClass().getResourceAsStream("Config.properties"));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "properties fallo", ex);
        }
    }

    public Connection getConnection() throws Exception {
        if (null == connection) {
            return sqliteConexion();
        }
        return connection;
    }

    private Connection sqliteConexion() throws Exception {
        try {
            String dbName = properties.getProperty("dataBaseName");
            String driverName = properties.getProperty("driverDB");
            String prefix = System.getProperty("user.home")+ "/";
            URL dataBaseUrl = new File(prefix + dbName).toURI().toURL();

            Class.forName(driverName);
            logger.info("ruta de la base de datos:" + dataBaseUrl.toString());
            connection = DriverManager.getConnection("jdbc:sqlite:"+dataBaseUrl.toString());
            return connection;
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            String mensaje= "Fallo la conexion a la Base de datos.";
            logger.log(Level.SEVERE,mensaje , ex);
            throw new Exception(mensaje,ex);
        }
    }

    private static class SQLiteJDBCHolder {

        private static final SqliteConnection INSTANCE = new SqliteConnection();
    }

}
