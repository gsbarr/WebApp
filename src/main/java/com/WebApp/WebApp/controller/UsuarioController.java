package com.WebApp.WebApp.controller;

import com.WebApp.WebApp.dao.UsuarioDao;
import com.WebApp.WebApp.dao.UsuarioDaoImp;
import com.WebApp.WebApp.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController  {

    @Autowired  //Inyección de dependencias
    private UsuarioDaoImp  user;
    @RequestMapping(value = "api/crear")
    public Usuario crearUsuario() {
        Usuario u1 = new Usuario();
        u1.setNombre("Carlos");
        u1.setDni("2222");
        u1.setPassword("1234");
        return u1;
    }

    @RequestMapping(value = "api/obtener/{id}", method = RequestMethod.GET)
    public List<Usuario> getUsuario(@PathVariable int id) {
        return user.getUsuario(id);
    }

}
