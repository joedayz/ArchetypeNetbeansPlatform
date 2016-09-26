package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.modulos;

import java.beans.IntrospectionException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.openide.nodes.BeanNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.ChangeSupport;
import org.openide.util.Exceptions;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import java.util.List;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.dao.ProyectoDao;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.dao.sqlite.ProyectoDaoSqlite;

public class CreatedChildFactory extends ChildFactory.Detachable<BusinessObject> implements ChangeListener {

    List<BusinessObject> createdList = ServicioProyecto.getCreatedArrayList();
    ChangeSupport changeSupport = ServicioProyecto.getChangeSupport(this);
    private static ProyectoDao proyectoDao;

    public CreatedChildFactory() {
        changeSupport.addChangeListener(this);
    }

    @Override
    protected void addNotify() {
        refresh(true);
    }

    public void stateChanged(ChangeEvent e) {
        refresh(true);
    }

    @Override
    protected boolean createKeys(List<BusinessObject> list) {
        list.addAll(createdList);
        return true;
    }

    @Override
    protected Node createNodeForKey(BusinessObject key) {
        System.out.println("createNodeForKey:BusinessObject:::" + key.getNombre());
        try {
            return new CreatedNode(key, new InstanceContent());
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
        return null;
    }

    public class CreatedNode extends BeanNode {
        public CreatedNode(final BusinessObject bObject, final InstanceContent ic) throws IntrospectionException {
            super(bObject, Children.LEAF, new AbstractLookup(ic));
            ic.add(new CheckNode(bObject));
            ic.add(bObject);
            setDisplayName(bObject.getNombre());
            System.out.println("propiedad del nombre de BO: "+ bObject.getNombre());
            bObject.addPropertyChangeListener(new PropertyChangeListener() {
                public void propertyChange(PropertyChangeEvent evt) {
                    if (bObject.isActivo()) {
                        getProyectoDao().activarRegistro(bObject.getId());
                    }else{
                        getProyectoDao().desactivarRegistro(bObject.getId());
                    }
                }
            });
        }
    }
    
    private ProyectoDao getProyectoDao(){
        if (proyectoDao== null){
            proyectoDao = new ProyectoDaoSqlite();
        }
        return proyectoDao;
    }
    
}
