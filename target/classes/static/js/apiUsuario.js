$(document).ready(function(){
    //user = crearUsuario();

    lista = listarUsuarios();

    $('#datatablesSimple').DataTable();

});





//definimos una funcion asincronica para hacer una peticion a la API
async function crearUsuario() {

    //URL del servicio  -  El codigo espera una respuesta
    const respuesta = await fetch('api/obtener/1', {
     method: 'GET', //metodo HTTP
      headers: {   //aca decimos que devuelve un JSON
          'Accept': 'application/json',
          'Content-Type': 'application/json'
       }
     });
    const usuario = await respuesta.json();
console.log("contenido usuario");
console.log(JSON.stringify(usuario));
document.write(JSON.stringify(usuario));
    // aca pondriamos la logica que llena la pagina
    return usuario;
}


async function listarUsuarios() {

    //let listaUsuarios = [];

    //URL del servicio  -  El codigo espera una respuesta
    const respuesta = await fetch('api/obtener/listaUser', {
     method: 'GET', //metodo HTTP
      headers: {   //aca decimos que devuelve un JSON
          'Accept': 'application/json',
          'Content-Type': 'application/json'
       }
     });
    const lista  = await respuesta.json();
    
    console.log("contenido lista usuario");
    console.log(JSON.stringify(lista));
    
    //document.write(JSON.stringify(lista));


    // aca pondriamos la logica que llena la pagina

    // si LISTA está vacío
    if (JSON.stringify(lista) === "{}"){
        console.log("Lista vacia");
    }
    else{
        console.log("Llenamos la lista");
        
        const tabla = document.querySelector("#datatablesSimple tbody");
        tabla.innerHTML = "";
    
        lista.forEach(usuario => {
    
            const tr = document.createElement("tr");
            tr.classList.add("tr_usuario");
            tr.innerHTML = `
                <td>${usuario.id}</td>
                <td>${usuario.nombre}</td>
                <td>${usuario.dni}</td>
                <td>${usuario.password}</td>
                <td>pruebatexto</td>
                <td>pruebatexto</td>
            `;
    
            tabla.append(tr);
            
           
        })

        //$('#datatablesSimple').DataTable().ajax.reload();
        //BUSCAR COMO RECARGAR EL DATATABLE (Lo de arriba no funciona)
       
        console.log("lista llenada");
    }
    
    return lista;
}
