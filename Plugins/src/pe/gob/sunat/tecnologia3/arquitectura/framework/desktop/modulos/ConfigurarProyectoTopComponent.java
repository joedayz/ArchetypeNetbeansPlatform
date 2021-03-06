package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.modulos;

import java.util.logging.Logger;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.nodes.Node;


@ConvertAsProperties(dtd = "-//org.filter//Created//EN",
autostore = false)
@TopComponent.Description(preferredID = "ConfigProyectoTopComponent",
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "explorer", openAtStartup = false)
@ActionID(category = "Window", id = "pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.modulos.ConfigProyectoTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_SelectionAction",
preferredID = "ConfigProyectoTopComponent")
public final class ConfigurarProyectoTopComponent extends TopComponent implements ExplorerManager.Provider {

    private static ConfigurarProyectoTopComponent instance;
    private static final String PREFERRED_ID = "ConfigProyectoTopComponent";
    private ExplorerManager em = new ExplorerManager();
    private static final Logger logger = Logger.getLogger(ConfigurarProyectoTopComponent.class.getName());
    

    public ConfigurarProyectoTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(ConfigurarProyectoTopComponent.class, "CTL_SelectionTopComponent"));
        Node rootNode = new ProyectoNode(new CreatedChildFactory());
        outlineView1.getOutline().setRootVisible(false);
        em.setRootContext(rootNode);
    }

    /** 
     * 
     * este metodo es llamado con el constructor para inicializar el form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        outlineView1 = new org.openide.explorer.view.OutlineView("Configuracion de Módulos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(outlineView1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(outlineView1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openide.explorer.view.OutlineView outlineView1;
    // End of variables declaration//GEN-END:variables

    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link #findInstance}.
     */
    public static synchronized ConfigurarProyectoTopComponent getDefault() {
        if (instance == null) {
            instance = new ConfigurarProyectoTopComponent();
        }
        return instance;
    }

    /**
     * obtener la instancia de ConfigurarProyectoTopComponent instance. No llamar a {@link #getDefault} directamente!
     */
    public static synchronized ConfigurarProyectoTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            logger.warning( "no se puede encontrar al componente: " + PREFERRED_ID + ".");
            return getDefault();
        }
        if (win instanceof ConfigurarProyectoTopComponent) {
            return (ConfigurarProyectoTopComponent) win;
        }
        logger.warning("Hay multiples componentes con el nombre:  '" + PREFERRED_ID + "'.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }

  
    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    Object readProperties(java.util.Properties p) {
        if (instance == null) {
            instance = this;
        }
        instance.readPropertiesImpl(p);
        return instance;
    }

    private void readPropertiesImpl(java.util.Properties p) {
        String version = p.getProperty("version");
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }

    public ExplorerManager getExplorerManager() {
        return em;
    }
}
