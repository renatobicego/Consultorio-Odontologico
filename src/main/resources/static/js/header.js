
let user
const getUser = async() => {
    const url = "/authenticate"
    await fetch(url)
    .then(res => res.json())
    .then(data => {
        user = data
    })
}

const logout = async() => {
    const url = '/logout'
    await fetch(url)
}


window.addEventListener('load', async() => {
    await getUser()

    //Inyectar nav bar al header. Si usuario no es admin, no va
    // a poder ingresar a la gestión de odontologos y pacientes
    document.querySelector('header').innerHTML = 
    `<nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="">DH</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="index.html">Home</a>
                    </li>
                    ${user.role == 'ROL_ADMIN' ? 
                        '<li class="nav-item dropdown">' + 
                        '<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">' +
                                'Gestion de Odontologos' +
                            '</a>' +
                            '<ul class="dropdown-menu">' +
                                '<li><a class="dropdown-item" href="post_odontologos.html">Alta</a></li>' +
                                '<li><a class="dropdown-item" href="get_odontologos.html">Listar</a></li>' +
                            '</ul>' + 
                        '</li>' +
                        '<li class="nav-item dropdown">' +
                            '<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">' +
                                'Gestion de Pacientes' +
                            '</a>' +
                            '<ul class="dropdown-menu">' +
                            ' <li><a class="dropdown-item" href="post_pacientes.html">Alta</a></li>' +
                                '<li><a class="dropdown-item" href="get_pacientes.html">Listar</a></li>' +
                            '</ul>' +
                        '</li>'
                    : ''}
                
    
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Gestion de Turnos
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="post_turnos.html">Alta</a></li>
                            <li><a class="dropdown-item" href="get_turnos.html">Listar</a></li>
                        </ul>
                    </li>

                    <li class="nav-item">
                        <form id='cerrar-sesion'>
                            <button type='submit'  class="btn btn-secondary">Cerrar Sesión</button>
                        </form>
                    </li>
    
                </ul>
            </div>
        </div>
    </nav>`

    //Cerrar sesión
    document.querySelector('#cerrar-sesion').addEventListener('submit', logout)

})
