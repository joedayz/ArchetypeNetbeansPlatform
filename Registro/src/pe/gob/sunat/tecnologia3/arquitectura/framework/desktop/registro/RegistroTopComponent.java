/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.registro;

//import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.auditoria.LoggerAnnotation;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.jfxrt.JFxPanelTopComponent;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.jfxrt.registro.ProfileController;

/**
 * @author Edwin Farfan
 */
@ActionID(category = "View", id = "pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.registro.RegistroTopComponent")
@TopComponent.Description(
        preferredID = "RegistroTopComponent",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(
        mode = "View",
        openAtStartup = true,
        position = 10)

@ActionReference(
        path = "Menu/View",
        position = 10)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_RegistroTopComponent",
        preferredID = "RegistroTopComponent"
)
public final class RegistroTopComponent extends JFxPanelTopComponent {

    private static final String NAME_FXML = "profile.fxml";
    
    @Override
    public String getNameFxml(){
        return PREFIJO_NAME_FXML + NAME_FXML;
    }

//    @LoggerAnnotation(modulo="DemoRegistro")
    public RegistroTopComponent() {
        cargarTopComponent();
        System.out.println("ingresa al constructor del RegistroAction...");
        setName(NbBundle.getMessage(RegistroTopComponent.class, "CTL_RegistroTopComponent"));
        setToolTipText(NbBundle.getMessage(RegistroTopComponent.class, "HINT_RegistroTopComponent"));

    }

   

}
