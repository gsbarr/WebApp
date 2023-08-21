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
    public ResponseEntity<String> registrarUsuario(@RequestBody Map<String, String> nuevoU) {

        //Creamos usuario
        user.registrar(nuevoU);

        //Devolvemos una respuesta vacía (para habilitar el CORS)
        HttpHeaders responseHeaders = new HttpHeaders();
        //responseHeaders.set("Access-Control-Allow-Methods", "GET, POST, PUT");
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        responseHeaders.set("Access-Control-Allow-Headers", "Content-Type");
        return new ResponseEntity<String>("Usuario creado", responseHeaders, HttpStatus.OK);

    }

    // Para obtener un unico usuario por ID
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    public Usuario obtUserId(@PathVariable int id) {
        return user.getUsuario(id);
    }

    // Para obtener lista total de usuarios
    @RequestMapping(value = "api/usuarios/listaUser", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> listaUser() {
        HttpHeaders responseHeaders = new HttpHeaders();
        //responseHeaders.setLocation(location);
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<List<Usuario>>(user.getLista(), responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "api/usuarios/del/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable int id) {
        user.eliminar(id);
    }

}
