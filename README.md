# projectoBD
## Montando la base de datos
1. Descargar e instalar [Docker desktop](https://www.docker.com/products/docker-desktop/).
2. En una linea de comandos, navegar hasta la raiz de este repositorio.
3. Favor de ejecutar el siguiente comando en caso de trabajar en `windows`
```
git config core.autocrlf input
```
4. Inicia el contenedor de docker
- Si no quieres ver el log de la BD, ejecutar:
``` 
docker compose up -d
```
- Si quieres ver el log de la BD, ejecutar:
```
docker compose up
```
5. Creas una nueva conexion a la bd desde el `sqldeveloper` con los siguientes datos.

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

## Estructura de archivos
Nuestros archivos estan organizados de la siguiente forma:
- **Data**: Directorio creado por el contenedor, en este se persiste la base de datos localmente y nunca se sube a git.
- **databaseScripts**: Directorio donde se guardan los archivos .sh que se encargaran de la configuracion de la base de datos
  - **setup**: Se  ejecutan cuando se configura por primera vez la base de datos.
  - **startup*: Se ejecutan cuando se "prende" la base de datos
- **sqlScripts**: Directorio donde se guardan los archivos sql que configuran la base de datos, el funcionamiento es similar al de `databaseScripts`
  - **setup**
    - **admin**: archivos que se deben ejecutar con el usuario `sys` de la base de datos
  - **startup**