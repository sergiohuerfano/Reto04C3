const BASE_URL = "http://localhost:8080/"

function consultarCinemas(){

    $.ajax({
        dataType:'json',
        url: BASE_URL + "api/Category/all",
        type:'GET',
        success:function(response){
            console.log(response),

            mostrarTabla(response.items)
        }

    });
}

/* mostrarTabla (imprimir data obtenida en pantalla)
* Funcion que imprime en pantalla la data de la TBL CINEMA
@param lista, constituida de id, owner, capacity, category_id y name
@return miTabla, devolviendo una tabla con la data obtenida
* Adiciona a cada linea un boton de 'Borrar' que incluye la funcion borrarCinema
* Adiciona a cada linea un boton de 'Cargar para editar' que incluye la funcion obtenerItemEditar1
*/
function mostrarTabla(lista){
    var miTabla = "<table>";

    for(let i=0;i<lista.length;i++){
        miTabla+="<th>";
        miTabla+="<tr>
        miTabla+="<td>PROPIETARIO</td>";
        miTabla+="<td>CAPACIDAD</td>";
        miTabla+="<td>CATEGORIA</td>";
        miTabla+="<td>NOMBRE</td>";
        miTabla+="</tr>
        miTabla+="</th>";
        miTabla+="<tr>";
        miTabla+="<td>"+lista[i].owner+"</td>";
        miTabla+="<td>"+lista[i].capacity+"</td>";
        miTabla+="<td>"+lista[i].category_id+"</td>";
        miTabla+="<td>"+lista[i].name+"</td>";
        myTable+="<td><button id='actualizarCinema'>Actualizar</button><button id='borrarCinema'>Borrar</button></td>";
        miTabla+="</tr>";
    }
    miTabla+="</table>";
    $("#listaCinemas").empty();
    $("#listaCinemas").append(miTabla);
}

/* guardarCinema (guardar informacion en la BD)
* Funcion que guarda un nuevo registro en la TBL CINEMA a traves de un llamado AJAX con metodo API "POST"
@param nuevoItem, donde se ingresa la información a almacenar (id, owner, capacity, category_id y name)
@return funcion consularCinema, e imprimiendo la información adicionada
*/
function guardarCinema(){
    var nuevoItem={
        owner:$("#owner").val(),
        capacity:$("#capacity").val(),
        category_id:$("#category_id").val(),
        name:$("#name").val()
    };

    var dataToSend=JSON.stringify(nuevoItem);

    $.ajax({
        dataType:'json',
        data: nuevoItem,
        url:BASE_URL + "api/Cinema/save",
        type:'POST',
        success:function(response){
            console.log(response);
            alert('Guardado exitosamente');
            consultarCinemas();
        },

    });
}

/* obtenerItemEditar (cargar en las cajas de texto el item seleccionado)
@param idItem
@return los datos del item seleccionado en las cajas de texto
*/
function obtenerItemEditar1(idItem){
    $.ajax({
        dataType: 'json',
        url: BASE_URL + "api/Cinema/" +idItem,
        type:'GET',
        success:function(respuesta) {
            console.log(respuesta);
            var item=respuesta.items[0];

            $("#owner").val(item.owner);
            $("#capacity").val(item.capacity);
            $("#category_id").val(item.category_id);
            $("#name").val(item.name);

        },
    });
}

/* editCinema (actualizar data ya existente en la BD)
* Funcion que permite actualizar la data existente de la TBL CINEMA, de acuerdo a su ID, con llamado AJAX Y metodo API "PUT"
@param myData, con ID como PK
*/
function editarCinema(){
    var myData={
        id:$("#id").val(),
        owner:$("#owner").val(),
        capacity:$("#capacity").val(),
        category_id:$("#category_id").val(),
        name:$("#name").val(),
    };

    var dataToSend=JSON.stringify(myData);
    $.ajax({
        dataType:'json',
        data: dataToSend,
        url:BASE_URL + "/api/Client/update",
        type:'PUT',
        contentType: 'application/json',

        success:function(respuesta){

            console.log(respuesta);
            alert("Información actualizada exitosamente");
            consultarCinemas();
        }
    });
}

/* borrarCinema (elimina data existente en la BD)
* Funcion que permite eliminar la data existente de la TBL CINEMA, con llamado AJAX y metodo API "DELETE"
@param idElemento, con ID como PK
*/
function borrarCinema(idElemento){
    var myData={
        id:idElemento
    };
    var dataToSend=JSON.stringify(myData);

    $.ajax({
        dataType:'json',
        data: dataToSend,
        contentType: 'application/json',
        url:+ "api/Cinema/" + id,
        type:'DELETE',

        success:function(respuesta){
            console.log(respuesta);
            alert("Información eliminada exitosamente");
            consultarCinemas();
        }
    });
}