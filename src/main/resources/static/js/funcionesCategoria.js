const BASE_URL = "http://localhost:8080/"

function consultarCategoria(){
    $.ajax({
        url: BASE_URL + "api/Category/all",
        type: "GET",
        datatype: 'json',
        success:(response) => {
            cargarCategorias(response)
        }
    });
}

function cargarCategorias(items){
    let miTabla = "<table>"

    for(let i=0; i<items.length; i++){
        miTabla+="<th>";
        miTabla+="<tr>";
        miTabla+="<td>NOMBRE</td>";
        miTabla+="<td>EMAIL</td>";
        miTabla+="</tr>";
        miTabla+="</th>";
        miTabla+="<tr>";
        miTabla+="<td>"+items[i].name+"</td>";
        miTabla+="<td>"+items[i].description+"</td>";
        miTabla+="<td><button id='actualizarCategoria'>Actualizar</button><button id='borrarCategoria'>Borrar</button></td>";
        miTabla+="</tr>";
    }
    miTabla+="</table>";
    $("#listaCategorias").empty()
    $("#listaCategorias").append(miTabla);
}

function guardarCategoria(){
    var nuevoItem={
        name: $("#name").val()
        description: $("#description").val()}

    var dataToSend: JSON.stringify(nuevoItem}),
    $.ajax({
        url: BASE_URL + "api/Category/save",
        type:"POST",
        dataType: 'json',
        data: nuevoItem,
        contentType:"application/JSON",
        success:() => {
            alert("Categoria guardada")
            consultarCategoria()

        }
    });
}

function actualizarCategoria(){
    $.ajax({
        url: BASE_URL + "api/Category/update",
        type: "PUT",
        dataToSend: JSON.stringify({
            id: document.getElementById("actualizarCategoria").dataset.id,
            name: $("#name").val(),
            description: $("#description").val()
        }),
        contentType:"application/JSON",
        success:() => {
            alert("Categoria actualizada")
            consultarCategoria()
            $("#name").val("")
            $("#description").val("")
        }
    });
}

function borrarCategoria(id) {
    $.ajax({
        url :BASE_URL + "api/Category/" + id,
        type:"DELETE",
        datatype:'json',
        dataToSend: JSON.stringify({
            id
        }),
        contentType:"application/JSON",
        success:() => {
            alert("Categoria eliminada")
            consultarCategoria()
        }
    });
}