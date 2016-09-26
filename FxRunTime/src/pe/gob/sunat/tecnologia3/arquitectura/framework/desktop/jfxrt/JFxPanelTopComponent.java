/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.jfxrt;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.GroupLayout;
import org.openide.util.Exceptions;
import org.openide.windows.TopComponent;

/**
 * Clase generica para la construcción de un TopComponent integrado con Javafx
 *
 * @author Edwin Farfan
 */
public abstract class JFxPanelTopComponent extends TopComponent {

    protected static final String PREFIJO_NAME_FXML = "registro/";
    protected JFXPanel jFXPanel;
    private Initializable controller;
    private static final Logger LOG = Logger.getLogger(JFxPanelTopComponent.class.getName());

    public void cargarTopComponent() {
        LOG.info("Ingresa al metodo que inicializa el componente");
        initComponents();
        init();
    }

    private void initComponents() {

        jFXPanel = new JFXPanel();
        setPreferredSize(new Dimension(32767, 32767));

        GroupLayout jFxPanelLayout = new GroupLayout(jFXPanel);
        jFXPanel.setLayout(jFxPanelLayout);
        jFxPanelLayout.setHorizontalGroup(
                jFxPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 476, Short.MAX_VALUE)
        );
        jFxPanelLayout.setVerticalGroup(
                jFxPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 561, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jFXPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jFXPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
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

            final URL location = JFxPanelTopComponent.class.getResource(getNameFxml());//new File(getNameFxml()).toURI().toURL();
            final FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

            final Parent root = (Parent) fxmlLoader.load(location.openStream());
            final Scene scene = new Scene(root);

            ((JFXPanel) jFXPanel).setScene(scene);

            setController((Initializable)fxmlLoader.getController());
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    public abstract String getNameFxml();
    
    private void setController(Initializable controller){
        this.controller = controller;
    }

}
