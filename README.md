# 📘 API REST - Gestión de Citas 2026 con Java, Lombok, Swagger y MapStruct

Este proyecto es una **API RESTful desarrollada en Java con Spring Boot** para la gestión de citas. Utiliza buenas prácticas de desarrollo como DTOs, separación de capas, documentación con Swagger y mapeo automático con MapStruct. Además, se usa Lombok para simplificar el código.

## 🛠 Tecnologías utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- Lombok
- MapStruct
- Swagger / OpenAPI
- MySQL
- Maven

## ✨ Funcionalidades principales

- Registro, consulta, actualización y cancelación de citas, pacientes, especialidad, medico.
- Uso de DTOs para exponer datos a los clientes
- Documentación automática de la API con Swagger UI
- Mapeo eficiente entre entidades y DTOs usando MapStruct
- Reducción de código repetitivo con anotaciones de Lombok (`@Getter`, `@Setter`, `@Builder`, etc.)

## 🚀 Cómo ejecutar el proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/JoahanCarlo/Cita2026.git

2. Configura tu conexión a la base de datos en src/main/resources/application.properties
   spring.datasource.url=jdbc:mysql://localhost:3306/citamedico
   spring.datasource.username=root
   spring.datasource.password=
   
4. Ejecuta el proyecto:
   ./mvnw spring-boot:run
   
5. Accede a Swagger para probar los endpoints:
   http://localhost:8080/swagger-ui/index.html
