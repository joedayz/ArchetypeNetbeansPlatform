
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.core;

import java.awt.Dimension;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.jfxrt.JFxPanelBase;

/**
 * Clase que se encarga de fachada para obtener el JFXPanelBase
 * @author Edwin Farfan
 */
public class LoginFXForm extends JFxPanelBase {

    private static final String NAME_FXML = "/Login.fxml";

    public LoginFXForm() {
        setFXMLName(NAME_FXML);
        setDimension(new Dimension(350, 250));
    }

}
