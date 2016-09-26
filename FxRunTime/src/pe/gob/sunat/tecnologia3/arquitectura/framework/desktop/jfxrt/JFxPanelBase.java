/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.jfxrt;

/**
 * Clase Base para la generacion de un Panel integrado con JavaFx
 * @author Edwin Farfan
 */
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.lang.Class;
import java.net.URL;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.JComponent;
import org.openide.util.Exceptions;

public class JFxPanelBase extends JPanelBase {

    protected  JComponent jFxPanel;
    private Initializable controller;
    private String pathFxmlFile;
    private static final String PREFIJO_MODULO_FXML_PATH = "login";
    
    public JFxPanelBase() {
        jFxPanel = null;
        controller = null;
    }
    
    public JComponent getJFXPanel() {

        if (jFxPanel == null) {
            try {
                Class c = Class.forName("javafx.embed.swing.JFXPanel");
                jFxPanel = (JComponent) c.newInstance();
                jFxPanel.setPreferredSize(getDimension());
                setLayout(getLayout());
                add(jFxPanel, BorderLayout.CENTER);

            } catch (InstantiationException  | IllegalAccessException | ClassNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            } 
        }
        return jFxPanel;
    }

    public void init() {
        Platform.setImplicitExit(false);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                createScene();
            }
        });
    }

    private void createScene() {
        try {
            
            final URL location = JFxPanelBase.class.getResource(pathFxmlFile);//new File(pathFxmlFile).toURI().toURL();
            final FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

            final Parent root = (Parent) fxmlLoader.load(location.openStream());
            final Scene scene = new Scene(root);

            ((JFXPanel) getJFXPanel()).setScene(scene);

            setController((Initializable)fxmlLoader.getController());
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }


    public void setFXMLName(String path){
        this.pathFxmlFile = PREFIJO_MODULO_FXML_PATH+ path;
    }

    public void setController(Initializable controller){
        this.controller = controller;
    }
    
    public Initializable getController(){
        return this.controller;
    }

}
