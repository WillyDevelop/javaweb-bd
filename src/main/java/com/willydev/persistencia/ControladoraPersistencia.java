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
}
