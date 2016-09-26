/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//PECS: Programa electronico de comunicacion con la sunat.
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.core;

//import gob.pe.sunat.model.LoginModel;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author 
 */
public class Login extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
//        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, "metodo Start de la aplicacion");
//        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         System.out.println( "metodo main de la aplicacion");
        launch(args);
    }
    
}
