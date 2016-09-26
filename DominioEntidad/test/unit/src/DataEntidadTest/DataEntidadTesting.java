/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataEntidadTest;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.Usuario;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.Proyecto;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.dao.ProyectoDao;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.dao.UsuarioDao;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.dao.sqlite.ProyectoDaoSqlite;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.dominio.dao.sqlite.UsuarioDaoSqlite;

/**
 *
 * @author Edwin Farfan
 */
public class DataEntidadTesting {

    UsuarioDao usuarioDao;
    ProyectoDao proyectoDao;

    @Before
    public void setup() throws Exception {
        usuarioDao = new UsuarioDaoSqlite();
        proyectoDao = new ProyectoDaoSqlite();
    }

//    @Test
    public void testInsertarUsuario() throws Exception {

        Usuario usuario = new Usuario();
        usuario.setUsuario("nuevo usuario2");
        usuario.setPassword("password2..");
        usuario.setRuc("1234ruc845922..");

        usuarioDao.insertarUsuario(usuario);
    }

//    @Test
    public void testActualizarUsuario() throws Exception {

        Usuario usuario = new Usuario();
        usuario.setId(3);
        usuario.setUsuario("nuevo19:11");
        usuario.setPassword("password19:11..");
        usuario.setRuc("1234ruc19:11..");

        usuarioDao.insertarUsuario(usuario);
    }

    @Test
    public void testObtenerRegistros() throws Exception {

        List<Proyecto> listaRegistros= proyectoDao.obtenerRegistros();
        
        Assert.assertNotNull("el objeto es null", listaRegistros);
        Assert.assertEquals(1, listaRegistros.size());
                
    }

}
