# Web App con JAX-RS para CRUD de Cursos con Jakarta EE y WildFly

## Descripción

Este proyecto es una aplicación CRUD (Crear, Leer, Actualizar, Eliminar) desarrollada con Jakarta EE 10, empaquetada como un archivo WAR y desplegada en un servidor WildFly 32.0.0.Final.

## Características Principales

- Implementación de un CRUD (Crear, Leer, Actualizar, Eliminar) para la entidad `Curso`.
- Exposición de servicios RESTful para la gestión de cursos.
- Uso de JPA con Hibernate como proveedor de persistencia.
- Integración con CDI para la gestión de dependencias.

## Tecnologías Utilizadas

[![Jakarta EE](https://img.shields.io/badge/Jakarta%20EE-10.0.0-blue)](https://jakarta.ee/)
[![Maven](https://img.shields.io/badge/Maven-3.9.6-yellow)](https://maven.apache.org/)
[![WildFly](https://img.shields.io/badge/WildFly-32.0.0.Final-red)](https://www.wildfly.org/)
[![MySQL Workbench](https://img.shields.io/badge/MySQL%20Workbench-8.0.32-blueviolet)](https://www.mysql.com/products/workbench/)
[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-2024.1.1-blue)](https://www.jetbrains.com/idea/)

## Requisitos Previos

- JDK 21 instalado.
- Maven 3.9.6 instalado.
- Servidor de aplicaciones WildFly 32.0.0.Final configurado y ejecutándose.
- MySQL Workbench 8.0.32 instalado.
- Base de datos MySQL configurada y accesible desde el servidor WildFly.
- IntelliJ IDEA 2024.1.1 instalado.

## Configuración del Entorno de Desarrollo

1. **Clonar el repositorio:**
    ```bash
    git clone https://github.com/tuusuario/tu-repositorio.git
    cd tu-repositorio
    ```

2. **Configurar el archivo `persistence.xml`:**
    - Ubicado en `src/main/resources/META-INF/persistence.xml`.
    - Asegurarse de que el datasource `java:/MySqlDS2` esté configurado correctamente en WildFly.

3. **Configurar el archivo `web.xml`:**
    - Ubicado en `src/main/webapp/WEB-INF/web.xml`.
    - Configurar para el servlet de Jakarta RESTful Web Services.

4. **Compilar y empaquetar la aplicación:**
    ```bash
    mvn clean install
    ```

5. **Desplegar en WildFly:**
    ```bash
    mvn wildfly:deploy
    ```

6. **Asegurarse de que WildFly esté corriendo y el datasource `java:/MySqlDS2` esté disponible.**

## Estructura de Carpetas

```markdown
.
src/main
├── java
│   └── org
│       └── mbohorquez
│           └── webapp
│               └── jaxrs
│                   ├── configs
│                   │   └── ProducerEntityManager.java
│                   ├── controller
│                   │   └── CursoRestController.java
│                   ├── models
│                   │   └── entities
│                   │       └── Curso.java
│                   ├── repositories
│                   │   ├── CursoRepository.java
│                   │   └── CursoRepositoryImpl.java
│                   └── service
│                       ├── CursoService.java
│                       └── CursoServiceImpl.java
├── resources
│   └── META-INF
│       └── persistence.xml
├── webapp
│   └── WEB-INF
│       └── web.xml
├── .gitignore
├── README.md
└── pom.xml
```

## Controlador REST

La clase `CursoRestController` está anotada para manejar las operaciones CRUD con JSON y expone las siguientes operaciones:

- `listar()`: Devuelve una lista de todos los cursos.
- `porId(Long id)`: Devuelve un curso por su ID.
- `crear(Curso curso)`: Crea un nuevo curso.
- `editar(Long id, Curso curso)`: Actualiza un curso existente.
- `eliminar(Long id)`: Elimina un curso por su ID.

Asegúrate de que WildFly esté corriendo y de que el datasource java:/MySqlDS2 esté configurado correctamente en el servidor WildFly antes de desplegar la aplicación.


![JAX-RS](https://github.com/martinbohorquez/_73_1_webapp-jaxrs/assets/121200468/ef214bee-a162-477e-8bbe-67ff2d2afd56)

## Licencia

Este proyecto está licenciado bajo la [Licencia MIT](LICENSE).


