# projectoBD
Pasos a seguir para montar la base de datos:
- Descargar e instalar [Docker desktop](https://www.docker.com/products/docker-desktop/).
- En una linea de comandos, navegar hasta la raiz de este repositorio.
- Si no quieres ver el log de la BD, ejecutar:
``` 
docker compose up -d
```
- Si quieres ver el log de la BD, ejecutar:
```
docker compose up
```
- Creas una nueva conexion a la bd desde el `sqldeveloper` con los siguientes datos.

|parametro|valor|
|-|-|
|name|Proyecto|
|username|prueba|
|password|prueba|
|role|default|
|hostname|localhost|
|port|1522|
|sid|xe|

Despues de seguir estos pasos te deberá dejar conectar a la base de datos

Favor de hacer push al repositorio cada que hagas commit en la base de datos para que los demas podamos ver los datos confirmados en la BD.

Ojo, antes de trabajar en el sql developer deben asegurarse de que el contenedor está corriendo.
