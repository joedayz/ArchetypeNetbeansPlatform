package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.modulos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.openide.util.Exceptions;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.Proyecto;

public class BusinessObject {

    private String nombre;
    private Integer id;
    private boolean activo = false;
    private PropertyChangeSupport propertyChangeSupport;

    public BusinessObject(Proyecto proy) {
        this.nombre = proy.getNombre();
        this.activo = proy.isActivo();
        this.id = proy.getId();
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setActivo(boolean newValue) {
        boolean oldValue = this.activo;
        this.activo = newValue;
        propertyChangeSupport.firePropertyChange("selected", oldValue, newValue);

    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String newValue) {
        this.nombre = newValue;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public boolean isActivo() {
        return activo;
    }

}
