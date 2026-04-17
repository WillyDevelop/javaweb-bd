package com.willydev.logica;

import com.willydev.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {

    //Instanciamos la persistencia para que se conecte con la base de datos
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    //metodo crear usuario
    public void crearUsuario(Usuario usu) {
        controlPersis.crearUsuario(usu);
    }

    //metodo traer usuarios
    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }

    //metodo borrar usuario
    public void borrarUsuario(int id_eliminar) {
        controlPersis.borrarUsuario(id_eliminar);
    }

    //metodo traer usuario
    public Usuario traerUsuario(int id_editar) {
       return controlPersis.traerUsuario(id_editar);
    }

    //metodo editar usuario
    public void editarUsuario(Usuario usu) {
        controlPersis.editarUsuario(usu);
    }
}
