# Use an official lightweight Node.js image with npm
FROM node:21-alpine3.18

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar los archivos necesarios, incluyendo package.json y package-lock.json
COPY package.json .
COPY package-lock.json .
COPY ./build /app/build

COPY . .
RUN npm install
RUN npm run build
EXPOSE 3000

CMD ["npm", "start"]
