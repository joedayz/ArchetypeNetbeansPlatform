/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.apache.commons.lang.StringUtils;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.LifecycleManager;
import org.openide.NotifyDescriptor;
import org.openide.awt.StatusDisplayer;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.jfxrt.login.LoginController;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.seguridad.UsuarioPrincipal;

/**
 *
 * @author Edwin Farfan
 */
public class LoginForm extends DialogDescriptor {

    private static  Logger log = Logger.getLogger(LoginForm.class.getName());    
    private static LoginForm loginFrameInstance = null;
    private static LoginFXForm jfxPanel = new LoginFXForm();
    private JButton ok;
    private JButton cancel;
    

    public static LoginForm getInstance() {
        if (loginFrameInstance == null) {
            loginFrameInstance = new LoginForm();
        }
        return loginFrameInstance;
    }

    private LoginForm() {
        super(jfxPanel.getJFXPanel(), "Plataforma Cliente Sunat");
        jfxPanel.init();
        ok = new JButton();
        cancel = new JButton();

        ok.setText("Entrar");
        cancel.setText("Cancelar");

        setOptions(new Object[]{ok, cancel});
        DialogDisplayer.getDefault().notifyLater(this);
        actionListeners();
    }

    private void actionListeners() {

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                log.log(Level.INFO,"Boton:::   cancel  ");
                exit();
            }
        });

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                LoginController controller = (LoginController) jfxPanel.getController();
                String mensajeError = controller.autenticacionFx();

                if (mensajeError != null) {
                    mostrarMensajeError(mensajeError);
//                    controller.setLabelUser(mensajeError);

                } else {
                    mensajeError = LoginSeguridad.autenticacionSeguridad(getUsuarioPrincipal(controller));
                    if (StringUtils.isNotBlank(mensajeError)) {
                        mostrarMensajeError(mensajeError);
                    }
                }
            }
        });

        this.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                if (NotifyDescriptor.CLOSED_OPTION.equals(evt.getNewValue())) {
                    exit();
                }
            }
        });
    }

    private static UsuarioPrincipal getUsuarioPrincipal(final LoginController controller){
        String usuariotxt= controller.getNombreUsuario();
        String passwordtxt= controller.getPassword();
        String ructxt= controller.getRuc();
       return  new UsuarioPrincipal(usuariotxt, passwordtxt,ructxt);
    }
    
    private static void mostrarMensajeError(String mensaje) {
        log.log(Level.INFO, "Mensaje::: {0}  ...ok button   ", mensaje);
        NotifyDescriptor nd = new NotifyDescriptor.Message(mensaje);
        Object actionResponse = DialogDisplayer.getDefault().notify(nd); 
        if (actionResponse == NotifyDescriptor.OK_OPTION 
                || actionResponse == NotifyDescriptor.CLOSED_OPTION ) {
            exit();
        }
    }
    
    private static void exit() {
        LifecycleManager.getDefault().exit();
    }

}
