package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.modulos;

import org.openide.explorer.view.CheckableNode;

class CheckNode implements CheckableNode {

    private BusinessObject businessObject;
    private Boolean selected = false;

    public CheckNode(BusinessObject bo) {
        this.businessObject = bo;
        this.selected = bo.isActivo();
    }
   
    public boolean isCheckable() {
        return true;
    }

    public boolean isCheckEnabled() {
        return true;
    }

    public Boolean isSelected() {
        if (selected) {
            return true;
        } else {
            return false;
        }
    }

    //este metodo es llamando por la vista cuando el checkbox es seleccionado o deseleccionado 
    public void setSelected(Boolean isSelected) {
        this.selected = isSelected;
        businessObject.setActivo(isSelected);
    }

}
