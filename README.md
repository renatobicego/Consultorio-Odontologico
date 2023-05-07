
# CTD - Proyecto Integrador: Consultorio Odontológico

Proyecto integrador de la materia Backend I de funciones CRUD y API REST para el manejo de pacientes, odontologos y turnos de una pagina web de una clínica odontológica. El Front-end permite observar y utilizar los distintos Endpoints, hecho con Javascript y CSS unicamente.

## Framework
- `Spring Boot`

## Dependencias
- `Spring Web:` Alta de servidor
- `Spring Data JPA:`: ORM
- `Spring Security:` Seguridad y Login
- `Log4j:` Manejo de logs
- `JUNIT:` Test unitarios


## Requisitos

- [Maven](https://maven.apache.org/download.cgi)
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

## Instalación
- ### Clonar:

 ```bash
cd carpeta-destino
git clone https://github.com/renatobicego/Consultorio_Odontologico.git

```
- ### Maven:

```bash
mvn clean package
java -jar consultorio.jar
```

Una vez hecho esto Tomcat levantara el servidor en el puerto 8080. La credenciales por defecto son `USER: admin` y `PASS: admin`. Se pueden editar o crear nuevas credenciales en `src/main/java/com/integrador/consultorio/services/security/DataLoader.java`.

## Endpoints


### Pacientes

- Guardar: `POST` -> `localhost:8080/pacientes/`

  - `BODY`
  
  ```json
    {
      "nombre": "Renato",
      "apellido": "Bicegp",
      "fechaIngreso": "2023-04-17",
      "domicilio": {
        "calle": "9 de Julio",
        "numero": 4,
        "localidad": "Mendoza",
        "provincia": "Mendoza"
      }
    }
    ```

- Buscar: `GET` -> `localhost:8080/pacientes/{id}`

  - `RESPUESTA` ID =1
  ```json
  {  
      "id":1,
      "nombre": "Renato",
      "apellido": "Bicego",
      "fechaIngreso": "2023-04-17",
      "domicilio": {
        "id":1,
        "calle": "9 de Julio",
        "numero": 4,
        "localidad": "Mendoza",
        "provincia": "Mendoza"
      }
    }
  ```  
- Actualizar existente: `PUT` -> `localhost:8080/pacientes/`
  - `BODY` 
  ```json
   {   
      "id":1,
      "nombre": "Renato",
      "apellido": "Bicego",
      "fechaIngreso": "2023-04-17",
      "domicilio": {
        "id":1,
        "calle": "9 de Julio",
        "numero": 4,
        "localidad": "Las Heras",
        "provincia": "Mendoza"
      }
    }
   ```
- Eliminar por id: `DELETE` -> `localhost:8080/pacientes/{id}`

  - `200 OK`- Paciente eliminado

- Buscar a todos los pacientes: `GET` -> `PATH/pacientes(`

### Odontólogos

- Guardaro: `POST` -> `localhost:8080/odontologos/`
  - `BODY`
   
    ```json
    {
      "nombre": "Carlos",
      "apellido": "Bicego",
      "matricula": 123
    }
    ```
- Buscar: `GET` -> `localhost:8080/odontologos/{id}`

  - `RESPUESTA` ID =1

```json
  {   
      "id": 1,
      "nombre": "Carlos",
      "apellido": "Bicego",
      "matricula": 123
    }
```
- Actualizar existente: `PUT` -> `localhost:8080/odontologos/`
  - `BODY`
  
 ```json
  {   
      "id": 1,
      "nombre": "Carlos",
      "apellido": "Bicego",
      "matricula": 321
    }
```
- Eliminar por id: `DELETE` -> `localhost:8080/odontologos/{id}`

   - `200 OK`- Odontologo eliminado

- Buscar a todos los odontologos: `GET` a `PATH/odontologos`



### Turnos

- Guardar: `POST` -> `localhost:8080/turnos/`

  - `BODY`
    ```json
    {
      "paciente": { "id": "1" },
      "odontologo": { "id": "1" },
      "fecha": "2023-04-17T19:30:00"
    }
    ```

- Buscar por id: `GET` -> `localhost:8080/turnos/{id}`

  - `RESPUESTA`
  
   ```json
    {
      "id": 1,
      "paciente": { "id": "1" },
      "odontologo": { "id": "1" },
      "fecha": "2023-04-17T19:30:00"
    }
    ```

- Actualizar existente: `PUT` -> `PATH/turnos`
  - `BODY`
    ```json
    {
      "id": 1,
      "paciente": { "id": "1" },
      "odontologo": { "id": "1" },
      "fecha": "2023-04-17T19:30:00"
    }
    ```
- Eliminar por id: `DELETE` -> `localhost:8080/turnos/{id}`

  - `200 OK`- Turno eliminado

- Buscar a todos los turnos: `GET` a `PATH/turnos`

