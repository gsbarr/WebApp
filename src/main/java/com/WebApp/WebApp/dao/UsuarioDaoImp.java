package com.WebApp.WebApp.dao;

import com.WebApp.WebApp.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// UN DAO (Data Object) es la clase que realiza consultas al modelo y realiza operaciones sobre los datos

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Usuario crearUsuario() {
        //String query = "";
        return null;
    }

    @Override
    public List<Usuario> getLista() {
        String query = "FROM Usuario";  // OJO!!! Acá va la CLASE del modelo, NO la tabla
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(int id) {
        Usuario user = entityManager.find(Usuario.class, id);
        entityManager.remove(user);
    }

    @Override
    public void registrar(Usuario u) {
        entityManager.merge(u);
    }

    @Override
    public List<Usuario> getUsuario(int id) {
        return null;
    }

}

