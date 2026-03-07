# Mercado Application

Este proyecto es una API REST simple construida con Spring Boot para manejar productos y actividades.

## Requisitos

- Java 17 o superior
- Maven 3.6+
- Base de datos configurada en `application.properties` (por defecto H2, PostgreSQL, etc.)

## Instalación y ejecución

1. Clonar el repositorio:
   ```bash
   git clone <repo-url> mercado
   cd "mercado"
   ```
2. Compilar el proyecto con Maven:
   ```bash
   mvn clean install
   ```
3. Ejecutar la aplicación:
   ```bash
   mvn spring-boot:run
   ```
4. La aplicación escuchará en `http://localhost:8080`.

> Si necesita empaquetar y ejecutar el jar:
> ```bash
> mvn package
> java -jar target/mercado-0.0.1-SNAPSHOT.jar
> ```

## Endpoints disponibles

### Productos

- **Crear producto** (POST)
  - URL: `POST /api/products`
  - Body JSON: `{ "name":"...", "description":"...", "price":123.45, "stock":10 }`

- **Listar productos** (GET)
  - URL: `GET /api/products`

- **Obtener producto por id** (GET)
  - URL: `GET /api/products/{id}`

- **Actualizar producto** (PUT)
  - URL: `PUT /api/products/{id}`
  - Body JSON: `{ "name":"...", "description":"...", "price":123.45, "stock":10 }`

- **Eliminar producto** (DELETE)
  - URL: `DELETE /api/products/{id}`

### Actividades

- **Crear actividad** (POST)
  - URL: `POST /api/activities`
  - Body JSON:
    ```json
    {
      "title":"...",
      "description":"...",
      "status":"BACKLOG",
      "priority":"HIGH",
      "dueDate":"2026-03-01"
    }
    ```

- **Listar actividades** (GET)
  - URL: `GET /api/activities`

- **Obtener actividad por id** (GET)
  - URL: `GET /api/activities/{id}`

- **Actualizar actividad** (PUT)
  - URL: `PUT /api/activities/{id}`
  - Body JSON: similar a crear

- **Marcar como done** (PATCH)
  - URL: `PATCH /api/activities/{id}/done`

- **Cambiar estado** (PATCH)
  - URL: `PATCH /api/activities/{id}/status?value=VALUE`

- **Eliminar actividad** (DELETE)
  - URL: `DELETE /api/activities/{id}`

## Uso con Postman

1. Importar colección o crear peticiones manualmente usando las rutas anteriores.
2. Asegúrate de usar `Content-Type: application/json` en los cuerpos de POST/PUT.
3. Se pueden probar validaciones enviando datos faltantes o incorrectos.

## Notas

- El proyecto usa Spring Data JPA; configure la conexión a la base de datos en `src/main/resources/application.properties`.
- Los DTOs y servicios están separados para permitir futuras mejoras.

