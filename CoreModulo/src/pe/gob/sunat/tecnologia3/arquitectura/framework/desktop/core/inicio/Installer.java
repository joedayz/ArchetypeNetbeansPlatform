/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.core.inicio;

import javax.swing.SwingUtilities;
//import org.netbeans.api.autoupdate.UpdateElement;
//import org.netbeans.api.autoupdate.UpdateManager;
//import org.netbeans.api.autoupdate.UpdateUnit;
//import org.openide.filesystems.FileObject;
//import org.openide.filesystems.URLMapper;
import org.openide.modules.ModuleInstall;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.core.LoginForm;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginForm.getInstance();
            }
        });
    }

    @Override
    public void validate() {
      
        System.out.println("validate en el inicializador...");
        
    }
    
//   public static final String MODULE_ID = "gob.pe.sunat.platform.update";
//   
//   private static UpdateElement moduleInfo;
   
//    public static Installer getDefault() {
//      return findObject(Installer.class, true);
//   }
//   
//   public FileObject getModuleResource(String path) {
//      URL url = getClass().getClassLoader().getResource(path);
//       FileObject resource = URLMapper.findFileObject(url);
//      return resource;
//   }
//
//   public static UpdateElement getModuleInfo() {
//      if (moduleInfo == null) {
//         for (UpdateUnit unit : UpdateManager.getDefault().getUpdateUnits(UpdateManager.TYPE.MODULE)) {
//            if (unit.getInstalled() != null && unit.getInstalled().getCodeName().equals(MODULE_ID)) {
//               moduleInfo = unit.getInstalled();
//               break;
//            }
//         }
//      }
//
//      return moduleInfo;
//   }
   
}
