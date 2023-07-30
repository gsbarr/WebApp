package com.WebApp.WebApp.dao;

import com.WebApp.WebApp.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UsuarioDao {

    Usuario crearUsuario();
    List<Usuario> getUsuario(@PathVariable int id);

    List<Usuario> getLista();

    void eliminar(int id);

    void registrar(Usuario u);
}
