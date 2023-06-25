# Especifica la imagen base
FROM node:18.16.0-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia los archivos necesarios al directorio de trabajo
COPY package.json package-lock.json ./

# Instala las dependencias
RUN npm install

# Copia el resto de los archivos al directorio de trabajo
COPY . .

# Expone el puerto de la aplicación
EXPOSE 4000

# Especifica la variable de entorno para el host de MySQL
ENV MYSQL_HOST=mysql

# Establece el directorio de trabajo
WORKDIR /app

# Ejecuta el comando para instalar dependencias y ejecutar la aplicación
CMD ["sh", "-c", "npm install && npm start"]
