function loadData(){
    let request = sendRequest('usuario/list', 'GET', '')
    let table = document.getElementById('usuarios-table');
    table.innerHTML = "";
    request.onload = function(){
        let data = request.response;
        console.log(data);
        data.forEach((element, index) => {
            table.innerHTML += `
                <tr>
                    <th>${element.idUsuario}</th>
                    <td>${element.nombre}</td>
                    <td>${element.apellidos}</td>
                    <td>${element.telefono}</td>
                    <td>${element.email}</td>
                    <td>${element.apartamentos.idApto}</td>
                    <td>
                        <button type="button" class="btn btn-primary" onclick='window.location = "/form_usuarios.html?id=${element.idUsuario}"'>Editar</button>
                        <button type="button" class="btn btn-danger" onclick='deleteUsuario(${element.idUsuario})'>Eliminar</button>
                    </td>
                </tr>
                `
        });
    }
    request.onerror = function(){
        table.innerHTML = `
            <tr>
                <td colspan="6">Error al recuperar los datos.</td>
            </tr>
        `;
    }
}
function loadUsuario(idUsuario){
    let request = sendRequest('usuario/list/'+ idUsuario, 'GET', '')
    let tipoN = document.getElementById('tipo-nombre')
    let tipoA = document.getElementById('tipo-apellido')
    let tipoT = document.getElementById('tipo-telefono')
    let tipoemail = document.getElementById('tipo-email')
    let tipoIdApto = document.getElementById('tipo-id-apartamento')
    let tipoNumApto = document.getElementById('tipo-num-apartamento')
    let tipoTorreApto = document.getElementById('tipo-torre-apartamento')
    let id = document.getElementById('usuario-id')
    request.onload = function(){
        let data = request.response
        id.value = data.idUsuario
        tipoN.value = data.nombre
        tipoA.value = data.apellidos
        tipoT.value = data.telefono
        tipoemail.value = data.email
        tipoIdApto.value = data.apartamentos.idApto
        tipoNumApto.value = data.apartamentos.no_Apto
        tipoTorreApto.value = data.apartamentos.no_Torre
    }
    request.onerror = function(){
        alert("Error al recuperar los datos.");
    }
}
function deleteUsuario(idUsuario){
    let request = sendRequest('usuario/'+idUsuario, 'DELETE', '')
    request.onload = function(){
        loadData()
    }
}
function saveUsuario(){
    let tipoN = document.getElementById('tipo-nombre').value
    let tipoA = document.getElementById('tipo-apellido').value
    let tipoT = document.getElementById('tipo-telefono').value
    let tipoemail = document.getElementById('tipo-email').value
    let tipoNumApto = document.getElementById('tipo-num-apartamento').value
    let tipoTorreApto = document.getElementById('tipo-torre-apartamento').value
    let id = document.getElementById('usuario-id').value
    let data = {
        'idUsuario': id,
        'nombre': tipoN, 
        'apellidos': tipoA, 
        'telefono':tipoT,    
        'email':tipoemail, 
        'apartamentos':{
            "no_Apto": tipoNumApto, 
            "no_Torre": tipoTorreApto
        }
    }
    let request = sendRequest('usuario/post','POST', data)
    request.onload = function(){
        window.location = 'usuarios.html';
    }
    request.onerror = function(){
        alert('Error al guardar los cambios.')
    }
}
function editarUsuario(){
    let tipoN = document.getElementById('tipo-nombre').value
    let tipoA = document.getElementById('tipo-apellido').value
    let tipoT = document.getElementById('tipo-telefono').value
    let tipoemail = document.getElementById('tipo-email').value
    let tipoIdApto = document.getElementById('tipo-id-apartamento').value
    let tipoNumApto = document.getElementById('tipo-num-apartamento').value
    let tipoTorreApto = document.getElementById('tipo-torre-apartamento').value
    let id = document.getElementById('usuario-id').value
    let data = {
        'idUsuario': id,
        'nombre': tipoN, 
        'apellidos': tipoA, 
        'telefono':tipoT,    
        'email':tipoemail, 
        'apartamentos':{
            'idApto': tipoIdApto, 
            "no_Apto": tipoNumApto, 
            "no_Torre": tipoTorreApto
        }
    }
    let request = sendRequest('usuario/edit', id ? 'PUT' : 'POST', data)
    request.onload = function(){
        window.location = 'usuarios.html';
    }
    request.onerror = function(){
        alert('Error al guardar los cambios.')
    }
}