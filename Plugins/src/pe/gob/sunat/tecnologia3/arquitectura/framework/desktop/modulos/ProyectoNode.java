package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.modulos;

import org.openide.nodes.AbstractNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;

/**
 *
 * @author Edwin Farfan
 */
public class ProyectoNode extends AbstractNode {
    private final ChildFactory.Detachable kids;
    
    public ProyectoNode(ChildFactory.Detachable kids) {
        super(Children.create(kids, true));
        this.kids = kids;
       
        ServicioProyecto.getCreatedArrayList();
        ServicioProyecto.getChangeSupport(kids).fireChange();
                        
    }

}
