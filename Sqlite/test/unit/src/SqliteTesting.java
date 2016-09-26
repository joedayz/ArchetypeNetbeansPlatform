
import java.io.File;
import java.net.URL;
import java.util.Properties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Edwin Farfan
 */
public class SqliteTesting {

    private static Properties properties;

    @Before
    public void setup() throws Exception {
        properties = new Properties();
        properties.load(getClass().getResourceAsStream("src/pe/gob/sunat/tecnologia3/arquitectura/framework/desktop/sqlite/Config.properties"));
    }

    @Test
    public void testFileFoundIntoProject() throws Exception{

        String propertyDB = properties.getProperty("dataBaseName");
        System.out.println("testFileFoundIntoProject.propertyDB:::: " + propertyDB);
        
//        URL locationURL = getClass().getResource("Parameters.sqlite");
//        System.out.println("testFileFoundIntoProject.locationURL:::: " + locationURL);
//        Assert.assertNotNull(locationURL);
        
        
        URL locationFile = new File(properties.getProperty("dataBaseName")).toURI().toURL();
        System.out.println("testFileFoundIntoProject.locationFile:::: " + locationFile.toString());
        Assert.assertNotNull(locationFile);
        
        
        
        //String driverName = getClass().getResource(properties.getProperty("driverDB")).toString();
        //System.out.println("testFileFoundIntoProject.driverName:::: " + driverName);
//        Assert.assertNotNull(driverName);
    }
    
    
    @Test
    public void testInsertarUsuario(){
        
        
        
    }
}
