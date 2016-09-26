/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.core.statusBar;

import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author Edwin Farfan
 */
public class ConnectionState {

    private int connectionState = STATE_NOTCONN;

    private JLabel label;

    public static final int STATE_NOTCONN = 0;
    public static final int STATE_STARTING = 1;
    public static final int STATE_STOPPING = 2;
    public static final int STATE_CONNECTED = 3;

    private static final String[] STATE_NAMES_KEYS
            = {"STATE_NOTCONN", "STATE_STARTING", "STATE_STOPPING", "STATE_CONNECTED"};
    private static String[] STATE_NAMES;

   

    // property change support    
    static {
      
        STATE_NAMES = new String[STATE_NAMES_KEYS.length];
        for (int i = 0; i < STATE_NAMES_KEYS.length; i++) {
            STATE_NAMES[i] =  STATE_NAMES_KEYS[i];
        } // for i STATE_NAMES_KEYS
    }

    private static final ConnectionState instance
            = new ConnectionState();

    public static ConnectionState getInstance() {
        return instance;
    }

    public String getStateName(int state) {
        return STATE_NAMES[state];
    }

    protected ConnectionState() {
        
        this.connectionState = STATE_NOTCONN;
        this.label.setToolTipText(
                "DB_CONNECTION_STATUS");
    }

    JComponent getComponent() {
        return this.label;
    }

    public int getConnectionState() {
        return connectionState;
    }

    public void setConnectionState(int connectionState) {
        // check parameter ...
        this.connectionState = connectionState;
        // propertyChangeSupport ...
      
        
        this.label.setToolTipText(
                "DB_CONNECTION_STATUS");
    }
}
