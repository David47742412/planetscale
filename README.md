## consumo de api de mascotas

esta api emplea los metodos http, GET, POST, PUT, DELETE

### Rutas:

* base-url/mascotas/all (metodo: GET) - devuelve todo la data
    * respuesta (ejemplo):
    * {
      "Message": "data returned",
      "Data": []
      }

***

* base-url/mascotas/ver/1 (metodo: GET) - devuelve el detalle de 1
    * respuesta:
    * {
      "id": 52,
      "nombre": "lua",
      "raza": "perro",
      "propietario": "Darwin David"
      }

***

* base-url/mascotas/get/report (metodo: GET) - devuelve toda la data con un formato especial
    * respuesta:
    * {
      "Darwin David": "lua"
      }

***

* base-url/mascotas/add (metodo: POST) - inserta una mascota
    * cuerpo de la consulta:
        * {
          "nombre": "lua",
          "raza": "perro",
          "propietario": "Darwin David"
          }
    * respuesta:
        * {
          "Message": "Se ha registrado correctamente todo sobre el registro #52",
          "Data": {
          "id": 52,
          "nombre": "lua",
          "raza": "perro",
          "propietario": "Darwin David"
          }

***

* base-url/mascotas/edit (metodo: PUT) - Modificar una mascota
    * cuerpo de la consulta:
        * {
          "id": 1,
          "nombre": "lua cambiada",
          "raza": "gato",
          "propietario": "Darwin David 2"
          }
    * respuesta:
        * {
          "Message": "Se ha actualizado el registro #1 Correctamente",
          "Data": {
          "id": 1,
          "nombre": "lua cambiada",
          "raza": "gato",
          "propietario": "Darwin David 2"
          }

***

* base-url/mascotas/edit (metodo: DELETE) - Elimina una mascota
    * cuerpo de la consulta:
        * {
          "id": 1
          }
    * respuesta:
        * status 204 (not content)