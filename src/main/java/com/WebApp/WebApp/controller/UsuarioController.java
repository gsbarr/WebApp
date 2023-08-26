package com.WebApp.WebApp.controller;

import com.WebApp.WebApp.dao.UsuarioDao;
import com.WebApp.WebApp.dao.UsuarioDaoImp;
import com.WebApp.WebApp.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController  {

    @Autowired  //Inyección de dependencias
    private UsuarioDaoImp  user;

    // Función de prueba
    @RequestMapping(value = "api/prueba")
    public Usuario pruebaUsuario() {
        Usuario u1 = new Usuario();
        u1.setNombre("Carlos");
        u1.setDni("2222");
        u1.setPassword("1234");
        return u1;
    }

    // Para crear un usuario
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public String registrarUsuario(@RequestBody Map<String, String> nuevoU) {
        //Creamos usuario
        user.registrar(nuevoU);

        return "Usuario creado";

    }

    // Para obtener un unico usuario por ID
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    public Usuario obtUserId(@PathVariable int id) {
        return user.getUsuario(id);
    }

    // Para obtener lista total de usuarios
    @RequestMapping(value = "api/usuarios/listaUser", method = RequestMethod.GET)
    public List<Usuario> listaUser() {
        return user.getLista();
    }

    @RequestMapping(value = "api/usuarios/del/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable int id) {
        user.eliminar(id);
    }

}
