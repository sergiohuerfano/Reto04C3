const BASE_URL = "http://localhost:8080/"
/*
@author SergioHuerfano
*/

/* consultarMensajes (obtener informacion de la TBL MESSAGE)
@param void
* Funcion que llama el metodo API "GET" a traves de AJAX
* Responde en consola la data de la TBL MESSAGE
* Llama a la funcion mostrarTabla
*/
function consultarMsj(){

    $.ajax({
        dataType:'json',
        url:BASE_URL + "api/Message/all",
        type:'GET',
        success:function(response){
            console.log(response),

            mostrarTablaMsj(response.items)
        }

    });
}

/* mostrarTablaMsj (imprimir data obtenida en pantalla)
* Funcion que imprime en pantalla la data de la TBL MESSAGE
@param lista, constituida de id, message
@return myTable, devolviendo una tabla con la data obtenida
* Adiciona a cada linea un boton de 'Borrar' que incluye la funcion borrarCinema
* Adiciona a cada linea un boton de 'Cargar para editar' que incluye la funcion obtenerItemEditar
*/
function mostrarTablaMsj(lista){
    var miTabla = "<table>";
    for(let i=0;i<lista.length;i++){
        miTabla+="<th>";
        miTabla+="<tr>";
        miTabla+="<td>ID</td>";
        miTabla+="<td>MESSAGE</td>";
        miTabla+="</tr>";
        miTabla+="</th>";
        miTabla+="<tr>";
        miTabla+="<td>"+lista[i].id+"</td>";
        miTabla+="<td>"+lista[i].messagetext+"</td>";
        miTabla+="<td><button id='actualizarMensaje'>Actualizar</button><button id='borrarMensaje'>Borrar</button></td>";
        miTabla+="</tr>";
    }
    miTabla+="</table>";
    $("#listaMensajes").empty();
    $("#listaMensajes").append(miTabla);
}

/* guardarMsj (guardar informacion en la BD)
* Funcion que guarda un nuevo registro en la TBL MESSAGE a traves de un llamado AJAX con metodo API "POST"
@param nuevoItem, donde se ingresa la información a almacenar (id, message)
*/
function guardarMsj(){
    var nuevoMsj={
        messagetext:$("#messagetext").val(),
    };

    var dataToSend=JSON.stringify(nuevoMsj);

    $.ajax({
        dataType:'json',
        data: nuevoMsj,
        contentType:'application/json',
        url:BASE_URL + "api/Message/save",
        type:'POST',
        success:function(response){
            console.log(response);
            alert('Guardado exitosamente');
            consultarMsj();
        },

    });
}

/* obtenerItemEditar3 (cargar en las cajas de texto el item seleccionado)
@param idItem
@return los datos del item seleccionado en las cajas de texto
*/
function obtenerItemEditar3(idItem){
    $.ajax({
        dataType: 'json',
        url: BASE_URL+"/id/Message/" +idItem,
        type:'GET',
        success:function(response) {
            console.log(response);
            var item=response.items[0];

            $("#idM").val(item.id);
            $("#messagetext").val(item.messagetext);

        },
    });
}

/* editarMsj (actualizar data ya existente en la BD)
* Funcion que permite actualizar la data existente de la TBL MESSAGE, de acuerdo a su ID, con llamado AJAX Y metodo API "PUT"
@param myData, con ID como PK
*/
function editarMsj(){
    var myData={
        id:$("#idM").val(),
        messagetext:$("#messagetext").val(),
    };

    var dataToSend=JSON.stringify(myData);
    $.ajax({
        dataType:'json',
        data: dataToSend,
        url:BASE_URL + "/api/Message/update",
        type:'PUT',
        contentType: 'application/json',

        success:function(response){

            console.log(response);
            alert("Información actualizada exitosamente");
            consultarMsj();
        }
    });
}

/* borrarMsj(elimina data existente en la BD)
* Funcion que permite eliminar la data existente de la TBL message, con llamado AJAX y metodo API "DELETE"
@param idElemento, con ID como PK
*/
function borrarMsj(idElemento){
    var myData={
        id:idElemento
    };
    var dataToSend=JSON.stringify(myData);

    $.ajax({
        dataType:'json',
        data: dataToSend,
        contentType: 'applicarion/json',
        url:BASE_URL + "api/Client/" + id,,
        type:'DELETE',

        success:function(response){
            console.log(response);
            alert("Información eliminada exitosamente");
            consultarMsj();
        }
    });
}