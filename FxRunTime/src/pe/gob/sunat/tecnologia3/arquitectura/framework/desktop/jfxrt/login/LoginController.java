/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.jfxrt.login;

//import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.auditoria.LoggerAnnotation;
//import gob.pe.sunat.sincronizacion.CargaCentral;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.apache.commons.lang.StringUtils;
import org.openide.LifecycleManager;
import org.openide.util.NbBundle;

/**
 * FXML Controller class
 *
 * @author I301324
 */
public class LoginController  implements Initializable {

    private static int numeroCaracterUsuario = 8;
    private Logger log = Logger.getLogger(LoginController.class.getName());            
    
    @FXML
    private TextField txtRuc;
    @FXML
    private TextField txtNombreUsuario;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label labelRuc;
    @FXML
    private Label labelUser;
    @FXML
    private Label labelPassword;

    @FXML
    private Label status;
    @FXML
    private AnchorPane AnchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    public String autenticacionFx() {

        System.out.println("authentificationAction!!!");
        return validacionDeCampos();
    }

    private String validacionDeCampos(){
        String usuario = txtNombreUsuario.getText();
        String password = txtPassword.getText();
        String ruc = txtRuc.getText();
        
        if(!StringUtils.isNotBlank(usuario)){// || usuario.length()< numeroCaracterUsuario){
            return NbBundle.getMessage(LoginController.class, "error.usuario.vacio");
        }
        if(!StringUtils.isNotBlank(password)){
            return NbBundle.getMessage(LoginController.class, "error.password.vacio");
        }
        if(!StringUtils.isNotBlank(ruc)){
            return NbBundle.getMessage(LoginController.class, "error.ruc.vacio");
        }
        return null;
    }
    
    public String getNombreUsuario(){
        return txtNombreUsuario.getText();
    } 
    public String getPassword(){
       return txtPassword.getText(); 
    }
    public String getRuc(){
        return txtRuc.getText();
    }

    private void ocultarLogin(ActionEvent event) {
        ((Node) event.getSource()).getScene().getWindow().hide();
//        LoginForm.getInstance().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        LoginForm.getInstance().dispose();
    }

    private void cancelButtonAction(ActionEvent event) {
        log.info("Buton Cancelar.....");
        LifecycleManager.getDefault().exit();
    }

    public void setStatusText(String status) {
        this.status.setText(status);
    }

    public void setLabelUser(String labelUser) {
        this.labelUser.setText(labelUser);
    }
}
