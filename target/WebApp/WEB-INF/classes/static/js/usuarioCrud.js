// Funcion para eliminar usuario
function eliminarUser(){
    idUsuario = document.querySelector("#idUser");

    if (confirm("¿Desea eliminar el usuario")){

        console.log("eliminando usuario "+idUsuario.value);
        try{
            
            respuesta = fetch('api/usuarios/del/' + idUsuario.value, {
                method: 'DELETE', //metodo HTTP
                headers: {   //aca decimos que devuelve un JSON
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            });
            console.log("Respuesta HTTP: " + respuesta.status);
        }
        catch (error){
            //hubo un error
            console.log("Error en borrado: " + error);
        }

        console.log("Usuario eliminado");
        
    }
    
    
}


//funcion para crear nuevo usuario
function crearUser(){
    inputNombre = document.querySelector("#inputNombre");
    inputDNI = document.querySelector("#inputDNI");
    inputPassword = document.querySelector("#inputPassword");
    inputPasswordCon = document.querySelector("#inputPasswordConfirm");
    let datos = {};
    let codigoResp;

    // Verifico si las password coinciden
    if (inputPassword.value != inputPasswordCon.value){
        alert("Las contraseñas no coinciden");
        return;
    }

    // Armamos el JSON con los datos del registro
    datos.nombre = inputNombre.value;
    datos.dni = inputDNI.value;
    datos.password = inputPassword.value;
    // ID del domicilio
    datos.fk_domicilio = 1;

    console.log(JSON.stringify(datos));

    console.log("creando usuario... ");
    // Petición HTTP
    try{   
        respuesta = fetch('http://localhost:8080/api/usuarios', {
            method: 'POST', //metodo HTTP
            headers: {   //aca decimos que devuelve un JSON
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)     //Acá van los datos del registro
        })
        .then(response => {
            codigoResp = response.status;
            console.log("Respuesta de petición: "+response.status);
     
            //recargamos la pagina
            if(codigoResp >= 200 && codigoResp < 300){
            console.log("Recargando pagina...")
            location.reload();
            }
        });
   
    }
    catch (error){
        //hubo un error
        console.log("Error en registro: " + error);
    }

}