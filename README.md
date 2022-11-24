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
|username|dev|
|password|dev|
|role|default|
|hostname|localhost|
|port|1522|
|service|XEPDB1|

Despues de seguir estos pasos te deberá dejar conectar a la base de datos

Ojo, antes de trabajar en el sql developer debes asegurarte de que el contenedor está corriendo.

Siempre ejecuta 
```
docker compose up
```
para iniciar la ejecución del contenedor.
