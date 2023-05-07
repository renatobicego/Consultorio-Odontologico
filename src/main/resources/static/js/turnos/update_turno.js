

window.addEventListener('load', function () {


    //Buscamos y obtenemos el formulario donde estan
    //los datos que el usuario pudo haber modificado de la pelicula
    const formulario = document.querySelector('#update_turno_form');

    formulario.addEventListener('submit', function (event) {
        //creamos un JSON que tendrá los datos de la película
        //a diferencia de una pelicula nueva en este caso enviamos el id
        //para poder identificarla y modificarla para no cargarla como nueva
        const formData = {
            id: document.querySelector('#turno_id').value,
            odontologo: {
                id: parseInt(document.querySelector('#odontologo_select').value)
            },
            paciente: {
                id: parseInt(document.querySelector('#paciente_select').value)
            },
            fecha: document.querySelector('#fecha').value + ':00',
        };

        //invocamos utilizando la función fetch la API peliculas con el método PUT que modificará
        //la película que enviaremos en formato JSON
        const url = '/turnos';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })

    //Es la funcion que se invoca cuando se hace click sobre el id de una pelicula del listado
    //se encarga de llenar el formulario con los datos de la pelicula
    //que se desea modificar
    const findBy = async(id) => {
          const url = '/turnos'+"/"+id;
          const settings = {
              method: 'GET'
          }
          await fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let turno = data;
              document.querySelector('#turno_id').value=turno.id;
              document.querySelector('#odontologo').innerHTML=turno.odontologo.nombre + ' ' + turno.odontologo.apellido;
              document.querySelector('#odontologo').value=turno.odontologo.id;
              document.querySelector('#paciente').innerHTML=turno.paciente.nombre + ' ' + turno.paciente.apellido;
              document.querySelector('#paciente').value=turno.paciente.id;
              document.querySelector('#fecha').value=turno.fecha
               //el formulario por default esta oculto y al editar se habilita
              document.querySelector('#div_turno_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })

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
      }