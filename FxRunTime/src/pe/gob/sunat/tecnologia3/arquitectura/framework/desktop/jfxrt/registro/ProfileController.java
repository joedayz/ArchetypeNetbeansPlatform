package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.jfxrt.registro;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 * Profile Controller demo.
 */
public class ProfileController extends AnchorPane implements Initializable {

    @FXML
    private TextField user;
    @FXML
    private TextField phone;
    @FXML
    private TextField email;
    @FXML
    private TextArea address;
    @FXML
    private CheckBox subscribed;
    @FXML
    private Hyperlink logout;
    @FXML
    private Button save;

    @FXML
    private Label success;
    @FXML
    private Font x1;
    @FXML
    private Insets x3;
    @FXML
    private Font x2;
    @FXML
    private Button reset;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void processLogout(ActionEvent event) {
    }

//    @LoggerAnnotation(modulo = "Demo Registro")
    @FXML
    public void saveProfile(ActionEvent event) {

//        User loggedUser = User.of("1");//application.getLoggedUser();
//        loggedUser.setEmail(email.getText());
//        loggedUser.setPhone(phone.getText());
//        loggedUser.setSubscribed(subscribed.isSelected());
//        loggedUser.setAddress(address.getText());
//        animateMessage();
    }

//    @LoggerAnnotation(modulo = "Demo Registro")
    @FXML
    public void resetProfile(ActionEvent event) {

        System.out.println("ingresa al metodo:::: resetProfile sin autenticar...");
//        if (!Autenticador.getInstance().isAuthenticated()) {
            System.out.println("ingresa al metodo:::: resetProfile del profileController...");
            email.setText("");
            phone.setText("");
            subscribed.setSelected(false);
            address.setText("");
            success.setOpacity(0.0);
//        }
    }


    private void animateMessage() {
        FadeTransition ft = new FadeTransition(Duration.millis(1000), success);
        ft.setFromValue(0.0);
        ft.setToValue(1);
        ft.play();
    }
}
