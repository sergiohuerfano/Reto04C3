/*
@author SergioHuerfano
*/

/* consultarCliente (obtener informacion de la TBL CLIENT)
@param void
* Funcion que llama el metodo API "GET" a traves de AJAX
* Responde en consola la data de la TBL CLIENT
* Llama a la funcion mostrarTabla
*/
function consultarCliente(){

    $.ajax({
        dataType:'json',
        url:'https://gd3065aa88a6e93-cinemasv1.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client',
        type:'GET',
        success:function(response){
            console.log(response),

            mostrarTablaCl(response.items)
        }

    });
}

/* mostrarTabla (imprimir data obtenida en pantalla)
* Funcion que imprime en pantalla la data de la TBL CINEMA
@param lista, constituida de id, owner, capacity, category_id y name
@return myTable, devolviendo una tabla con la data obtenida
* Adiciona a cada linea un boton de 'Borrar' que incluye la funcion borrarCinema
* Adiciona a cada linea un boton de 'Cargar para editar' que incluye la funcion obtenerItemEditar
*/
function mostrarTablaCl(lista){
    var miTabla = "<table>";
    for(i=0;i<lista.length;i++){
        miTable+="<th>";
        miTabla+="<tr>";
        miTabla+="<td>Nombre</td>";
        miTabla+="<td>Email</td>";
        miTabla+="<td>Edad</td>";
        miTabla+="</tr>";
        miTabla+="</th>";
        miTabla+="<tr>";
        miTabla+="<td>"+lista[i].name+"</td>";
        miTabla+="<td>"+lista[i].email+"</td>";
        miTabla+="<td>"+lista[i].age+"</td>";
        miTabla+="<td><button id='actualizarCliente'>Actualizar</button><button id='borrarCliente'>Borrar</button></td>";
        miTabla+="</tr>";
    }
    miTabla+="</table>";
    $("#listaClientes").empty();
    $("#listaClientes").append(miTabla);
}

/* guardarCliente (guardar informacion en la BD)
* Funcion que guarda un nuevo registro en la TBL CLIENT a traves de un llamado AJAX con metodo API "POST"
@param nuevoItem, donde se ingresa la información a almacenar (id, nombre, email y edad)
*/
function guardarCliente(){
    var nuevoItem={
        name:$("#name").val(),
        email:$("#email").val(),
        age:$("#age").val(),
    };

    var dataToSend=JSON.stringify(nuevoItem);

    $.ajax({
        dataType:'json',
        data: nuevoItem,
        url:BASE_URL + "api/Client/save",
        type:'POST',
        success:function(response){
            console.log(response);
            alert('Guardado exitosamente');
            consultarCliente();
        },

    });
}

/* obtenerItemEditar2 (cargar en las cajas de texto el item seleccionado)
@param idItem
@return los datos del item seleccionado en las cajas de texto
*/
function obtenerItemEditar2(idItem){
    $.ajax({
        dataType: 'json',
        url: BASE_URL + "api/Client/" +idItem,
        type:'GET',
        success:function(response) {
            console.log(response);
            var item=response.items[0];

            $("#id").val(item.id);
            $("#nameC").val(item.name);
            $("#email").val(item.email);
            $("#age").val(item.age);

        },
    });
}

/* editarCliente (actualizar data ya existente en la BD)
* Funcion que permite actualizar la data existente de la TBL CLIENT, de acuerdo a su ID, con llamado AJAX Y metodo API "PUT"
@param myData, con ID como PK
*/
function editarCliente(){
    var myData={
        id:$("#idC").val(),
        name:$("#nameC").val(),
        email:$("#email").val(),
        age:$("#age").val(),
    };

    var dataToSend=JSON.stringify(myData);
    $.ajax({
        dataType:'json',
        data: dataToSend,
        url:BASE_URL + "/api/Client/update",
        type:'PUT',
        contentType: 'application/json',

        success:function(response){

            console.log(response);
            alert("Información actualizada exitosamente");
            consultarCliente();
        }
    });
}

/* borrarCliente(elimina data existente en la BD)
* Funcion que permite eliminar la data existente de la TBL CLIENT, con llamado AJAX y metodo API "DELETE"
@param idElemento, con ID como PK
*/
function borrarCliente(idElemento){
    var myData={
        id:idElemento
    };
    var dataToSend=JSON.stringify(myData);

    $.ajax({
        dataType:'json',
        data: dataToSend,
        contentType: 'application/json',
        url:BASE_URL + "api/Client/" + id,
        type:'DELETE',

        success:function(response){
            console.log(response);
            alert("Información eliminada exitosamente");
            consultarCliente();
        }
    });
}