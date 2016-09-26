/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.core.statusBar;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import org.openide.awt.StatusLineElementProvider;
import org.openide.util.lookup.ServiceProvider;
//import static sun.misc.ClassFileTransformer.add;

/**
 *
 * @author Edwin Farfan
 */
@ServiceProvider(service=StatusLineElementProvider.class)
public class ConnectionStateLine extends JPanel 
                implements StatusLineElementProvider 
{
   private static JLabel text = new JLabel();
   private static final String usuarioLabel = "Usuario: ";

    public ConnectionStateLine() {
        setOpaque(false);
        setPreferredSize(new Dimension(120, 24));
        Font font = text.getFont();
        Font boldFont = new Font(font.getFontName(), Font.BOLD, font.getSize());
        add(new JSeparator(SwingConstants.VERTICAL), BorderLayout.WEST);
        add(text);
        text.setFont(boldFont);
    }

    @Override
    public Component getStatusLineElement() {
        return this;
    }

    public static void setMessage(String usuario) {
        text.setText(usuarioLabel+usuario);
    }
    
    
}