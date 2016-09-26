
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Edwin Farfan
 */
public class JFxUnitTest {

    @Test
    public void testUrlFileFound() throws Exception {

//        URL location = new File("file:///src/pe/gob/sunat/tecnologia3/arquitectura/framework/desktop/jfxrt/login/Login.fxml").toURI().toURL();
        URL location = new File("src/pe/gob/sunat/tecnologia3/arquitectura/framework/desktop/jfxrt/login/Login.fxml").toURI().toURL();
        String stringLocation = new File("src/pe/gob/sunat/tecnologia3/arquitectura/framework/desktop/jfxrt/login/Login.fxml").getCanonicalPath();
//        URL location =new URL("pe\\gob\\sunat\\tecnologia3\\arquitectura\\framework\\desktop\\jfxrt\\login\\Login.fxml");

        URL locationURL = getClass().getResource("src/pe/gob/sunat/tecnologia3/arquitectura/framework/desktop/jfxrt/login/Login.fxml");

        System.out.println("location: " + location);
        System.out.println("stringLocation: " + stringLocation);
        System.out.println("locationURL: " + locationURL);

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(locationURL);
        Parent root = (Parent) fxmlLoader.load(locationURL.openStream());
        Assert.assertNotNull(root);

        Assert.assertNotNull(location);
        Assert.assertNotNull(stringLocation);
        Assert.assertNotNull(locationURL);
    }

}
