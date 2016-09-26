/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.jfxrt;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 * Clase Base para crar un JPanel
 * @author Edwin Farfan
 */
public class JPanelBase extends JPanel{
    
    protected  Dimension dimension = new Dimension(800, 500);
    protected  LayoutManager layout = new BorderLayout();

    public JPanelBase() {
        super();
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    @Override
    public LayoutManager getLayout() {
        return layout;
    }

    @Override
    public void setLayout(LayoutManager layout) {
        this.layout = layout;
    }
    
    
}
