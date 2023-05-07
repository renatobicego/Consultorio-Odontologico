

window.addEventListener('load', async(event) => {

    const formulario = document.querySelector('#add_new_turno');

    //Obtener todos los odontologos
    const urlOdontologos = '/odontologos'
    await fetch(urlOdontologos)
        .then(res => res.json())
        .then(data => {
        for(let odontologo of data){
            if(!(odontologo.id == parseInt(document.querySelector('#odontologo').value))){      
                document.querySelector('#odontologo_select').innerHTML += 
                    `<option value=${odontologo.id}>${odontologo.nombre} ${odontologo.apellido} </option>`
            }
        }
    })

    //Obtener los pacientes
    const urlPacientes = '/pacientes'
    await fetch(urlPacientes)
        .then(res => res.json())
        .then(data => {
        for(let paciente of data){
            if(!(paciente.id == parseInt(document.querySelector('#paciente').value))){      
                document.querySelector('#paciente_select').innerHTML += 
                    `<option value=${paciente.id}>${paciente.nombre} ${paciente.apellido} </option>`
            }
        }
    })

    //Ante un submit del formulario se ejecutará la siguiente funcion
    formulario.addEventListener('submit', function (event) {
        event.preventDefault()
       //creamos un JSON que tendrá los datos de la nueva película
        const formData = {
            fecha: document.querySelector('#fecha').value + ':00',
            odontologo: {
                id: parseInt(document.querySelector('#odontologo_select').value)
            },
            paciente: {
                id: parseInt(document.querySelector('#paciente_select').value)
            }
            
        }

        //invocamos utilizando la función fetch la API peliculas con el método POST que guardará
        //la película que enviaremos en formato JSON
        const url = '/turnos';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                 //Si no hay ningun error se muestra un mensaje diciendo que la pelicula
                 //se agrego bien
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> turno agregado </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 resetUploadForm();

            })
            .catch(error => {
                    //Si hay algun error se muestra un mensaje diciendo que la pelicula
                    //no se pudo guardar y se intente nuevamente
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong>' + error + '</strong> </div>'

                      document.querySelector('#response').innerHTML = errorAlert;
                      document.querySelector('#response').style.display = "block";
                     //se dejan todos los campos vacíos por si se quiere ingresar otra pelicula
                     resetUploadForm();})
    });


    function resetUploadForm(){
            document.querySelector('#fecha').value= ''
            document.querySelector('#odontologo_select').value= ''
    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/get_turnos.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});
