package com.willydev.persistencia;

import com.willydev.logica.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import java.util.List;

public class ControladoraPersistencia {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("WillyDevPU");


    // Operacion Create
    public void crearUsuario(Usuario usu) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin(); // Iniciamos la transacción
            em.persist(usu);             // Guardamos el objeto
            em.getTransaction().commit(); // Confirmamos los cambios
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Si algo falla, volvemos atrás
            }
            e.printStackTrace();
        } finally {
            em.close(); // Siempre cerramos el EM
        }
    }

    // Operacion READ
    public List<Usuario> traerUsuarios() {
        EntityManager em = emf.createEntityManager();
        try {
            List<Usuario> lista = em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
            return lista;
        } finally {
            em.close();
        }
    }

    public void borrarUsuario(int id_eliminar) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            // Primero buscamos el objeto en la base de datos
            Usuario usu = em.find(Usuario.class, id_eliminar);

            // Si existe, lo borramos
            if (usu != null) {
                em.remove(usu);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

    public Usuario traerUsuario(int id_editar) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Usuario.class, id_editar);
        } finally {
            em.close();
        }
    }

    public void editarUsuario(Usuario usu) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // El método merge busca el ID del objeto 'usu' en la BD.
            // Si lo encuentra, actualiza los campos. Si no, lo crea.
            em.merge(usu);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            // Imprimir el error para debuggear
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
