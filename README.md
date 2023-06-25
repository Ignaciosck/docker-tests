# Docker Tests - Proyectos de prueba 

Este repositorio contiene una serie de proyectos para realizar pruebas desplegando las herramientas necesarias en Docker.

El proyecto llamado backendtest que consiste en una API Rest desarrollada en JavaScript para gestionar restaurantes, platos, opiniones y usuarios.

El proyecto mongotest contiene clases para probar operaciones CRUD utilizando Java y MongoDB.

El proyecto mysqltest contiene clases para probar operaciones CRUD utilizando Java y MySQL.

## Requisitos

Asegúrate de tener instalada la aplicación Docker Desktop antes de levantar los contenedores de los proyectos.


O en su defecto, instalar:
- Docker
- Docker Compose


## Estructura del repositorio

El repositorio está organizado de la siguiente manera:
### Proyecto backendtest

  - `Dockerfile`: Archivo Dockerfile utilizado para construir la imagen Docker del proyecto.
  - `docker-compose.yml`: Archivo de Docker Compose para lanzar el proyecto junto con los servicios MySQL, PhpMyAdmin y el servicio de Node para ejecutar la imagen.
  - `backend.zip`: Imagen a importar que la API Rest.

Importar la imagen backend.zip con el comando:
```bash
docker load -i backend.zip
```

### Proyecto mongotest 
- `Proyecto Java mongotest`: Proyecto de prueba de operaciones CRUD en MongoDB utilizando Java.
- `docker-compose.yml`: Archivo de Docker Compose para lanzar el proyecto junto con los servicios MongoDB y Mongo Express.

### Proyecto mysqltest
- `Proyecto Java mysqltest/`: Directorio del proyecto de prueba de operaciones CRUD en MySQL utilizando Java.
- `docker-compose.yml`: Archivo de Docker Compose para lanzar el proyecto junto con los servicios de MySQL y PhpMyAdmin.
## Configuración y ejecución

Sigue los pasos a continuación para configurar y ejecutar el proyecto Backend Test:

1. Clona este repositorio en tu máquina local.

2. Accede al directorio del proyecto deseado y ejecuta el siguiente comando.
```bash
docker compose up -d
```

## Pruebas de Postman

En la carpeta `backendtest/` encontrarás un conjunto de pruebas de Postman para validar las diferentes funcionalidades de la API Rest. Importa el archivo `backend_test.postman_collection.json` en Postman y ejecuta las pruebas para verificar el correcto funcionamiento de la API.
