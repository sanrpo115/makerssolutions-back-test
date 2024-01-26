
# Makers Solutions Fintech Prueba Técnica

Este repositorio contiene el código fuente BackEnd a la solución a una prueba técnica diseñada por Makers Solutions Fintech, el proyecto se realizó en lenguaje Java y sigue los principios de Clean Architecture para organizar el código en capas y proporcionar una estructura modular y mantenible. 

Utiliza Java 21 y Maven 3.9.6 para la construcción y gestión de dependencias, el proyecto fue realizado por Santiago Restrepo Gallego.




## Stack 

**Client:** React, Reactstrap, SASS

**Server:** JAVA, Springboot, PostgreSQL


## Requisitos

- JDK 21
- Maven 3.9.6
- PostreSQL 16
## Ejecución Local

- Clona el repositorio 

```bash
  git clone https://github.com/sanrpo115/makerssolutions-back-test.git
```

- Dirigete al directorio del proyecto

```bash
  cd makerssolutions-back-test
```
    
- Abrir proyecto en IDE de preferencia (Eclipse o IntelliJ)

    
## Estructura del proyecto

La estructura del proyecto sigue la arquitectura limpia (Clean Architecture) con los siguientes paquetes principales:

- **application:** Contiene los casos de uso (Use Cases) y servicios de aplicación. Aquí se definen las interfaces para interactuar con la capa de dominio y se implementan los casos de uso específicos de la aplicación.

- **domain:** Contiene las entidades del dominio, los objetos de valor y la excepcion para el manejo de errores de las peticiones.

- **infrastructure:** Contiene implementaciones concretas de las interfaces definidas en las capas anteriores. Aquí se encuentran detalles de implementación como entidades de bases de datos, definición de servicios y controladores.

  ![image](https://github.com/sanrpo115/makerssolutions-back-test/assets/45106663/106b0e24-fb4f-48f4-bac7-689e98d618fa)




## Servicios

  - **CREATE:** Contiene la lógica de aplicación relacionada con la creación de entidades en el sistema.




  - **READ:** Contiene la lógica de aplicación relacionada con la lectura y recuperación de información del sistema.
  - **UPDATE:** Contiene la lógica de aplicación relacionada con la actualización de entidades en el sistema.
  - **DELETE:** Contiene la lógica de aplicación relacionada con la eliminación de entidades en el sistema.
## Usos/Ejemplos

Se agregan los distintos códigos **cURL** para probar por Postman los servicios

- **READ**
  - 
  - **Request:**
  ```cURL
  curl --location --request GET 'http://localhost:8080/api/v1/students' \
  --data-raw ''
  ```
    - **Response:** 
  ```JSON
  [
    {
      "id": 1,
      "firstname": "Santiago",
      "lastname": "Restrepo",
      "email": "santirpo@gmail.com"
    },
    {
      "id": 3,
      "firstname": "Santi",
      "lastname": "Restrepo",
      "email": "santi55@gmail.com"
    }
  ]
  ```

- **CREATE**
  -
    - **Request Success:**
    ```cURL
      curl --location --request POST 'http://localhost:8080/api/v1/students' \
      --header 'Content-Type: application/json' \
      --data-raw '{
          "firstname": "Santiago",
          "lastname": "Restrepo",
          "email": "santirpo115@gmail.com"
      }'
    ```
    - **Response Success:**
    ```JSON
    {
      "data": {
        "id": 15,
        "firstname": "Santiago",
        "lastname": "Restrepo",
        "email": "santirpo115@gmail.com"
      },
      "message": "Se ha creado el estudiante correctamente"
    }
    ```
    ---
    - **Request existing email:**
    ```cURL
      curl --location --request POST 'http://localhost:8080/api/v1/students' \
      --header 'Content-Type: application/json' \
      --data-raw '{
          "firstname": "Santi",
          "lastname": "Rpo",
          "email": "santirpo115@gmail.com"
      }'
    ```
    - **Response existing user:**
    ```JSON
    {
      "error": true,
      "message": "El estudiante ya existe"
    }
    ```
    ---
    - **Request numbers and whitespace in firstname y lastname fields:**
     ```cURL
      curl --location --request POST 'http://localhost:8080/api/v1/students' \
      --header 'Content-Type: application/json' \
      --data-raw '{
          "firstname": "Santi 15",
          "lastname": "Rpo",
          "email": "santirpo115@gmail.com"
      }'
    ```
    - **Response numbers and whitespace in firstname y lastname fields:**
    ```JSON
    {
      "firstname": "El campo debe contener solo letras",
      "error": true
    }
    ```
    ---
    - **Request without field info:**
     ```cURL
      curl --location --request POST 'http://localhost:8080/api/v1/students' \
      --header 'Content-Type: application/json' \
      --data-raw '{
          "firstname": "Santi",
          "email": "santirpo115@gmail.com"
      }'
    ```
    - **Response without field info:**
    ```JSON
    {
      "lastname": "El campo apellido es obligatorio"
      "error": true
    }
    ```
- **UPDATE**
  -
    - **Request Success:**
    ```cURL
      curl --location --request PUT 'http://localhost:8080/api/v1/students' \
      --header 'Content-Type: application/json' \
      --data-raw '{
          "id": "1",
          "firstname": "Santi",
          "lastname": "Restrepo",
          "email": "santirpo115@gmail.com"
      }'
    ```
    - **Response Success:**
    ```JSON
    {
      "data": {
        "id": 1,
        "firstname": "Santi",
        "lastname": "Restrepo",
        "email": "santirpo115@gmail.com"
      },
      "message": "Se ha actualizado correctamente el registro"
    }
    ```
    ---
    - **Request with non-existent ID:**
    ```cURL
      curl --location --request PUT 'http://localhost:8080/api/v1/students' \
      --header 'Content-Type: application/json' \
      --data-raw '{
          "id": "1023",
          "firstname": "Santi",
          "lastname": "Restrepo",
          "email": "santirpo115@gmail.com"
      }'
    ```
    - **Response with non-existent ID:**
    ```JSON
    {
      "error": true,
      "message": "El estudiante no existe"
    }
    ```
- **DELETE**
  -
    - **Request Success:**
    ```cURL
    curl --location --request DELETE 'http://localhost:8080/api/v1/students/3' \
    --data-raw ''
    ```
    - **Response Success:**
    ```JSON
    {
      "message": "Registro eliminado exitosamente"
    }
    ```
    ---
    - **Request non-existent ID:**
    ```cURL
    curl --location --request DELETE 'http://localhost:8080/api/v1/students/33' \
    --data-raw ''
    ```
    - **Response Success:**
    ```JSON
    {
      "error": true,
      "message": "No existe un registro con ese ID"
    }
    ```
