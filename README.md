User Management System - Jakarta EE 11
Este proyecto es una aplicación web robusta diseñada para la gestión de usuarios, implementando una Arquitectura en Capas y utilizando el estándar de persistencia JPA con el namespace de Jakarta.

Tecnologías y Herramientas
Lenguaje: Java 17.

Servidor: Apache Tomcat 11.0.21.

Persistencia: JPA 3.1 (Hibernate 6.4+) con MySQL 8.

Namespace: jakarta.* (Migración completa desde javax).

Gestión de Dependencias: Maven.

IDE Recomendado: IntelliJ IDEA.

Arquitectura del Proyecto
El código está organizado de forma modular para separar las responsabilidades:

com.willydev.servlets: Controladores que manejan las peticiones del navegador.

com.willydev.logica: Contiene las entidades (objetos de negocio) y la controladora lógica.

com.willydev.persistencia: Gestiona la conexión con la base de datos mediante el EntityManager.

webapp: Contiene las vistas dinámicas en JSP.

Guía de Instalación
Sigue estos pasos para ejecutar el proyecto en tu entorno local:

1. Preparar la Base de Datos
Asegúrate de tener MySQL (o Laragon) corriendo.

Abre tu gestor de base de datos (phpMyAdmin, Workbench, etc.).

Crea una base de datos vacía llamada: javaweb.

2. Configurar la Persistencia
Dirígete a la ruta: src/main/resources/META-INF/persistence.xml.
Verifica que las credenciales de conexión coincidan con las tuyas:

User: root

Password: tu_contraseña (deja vacío si no tienes).

URL: jdbc:mysql://localhost:3306/javaweb

3. Configuración en el IDE
Clonar el repositorio:

Bash
git clone https://github.com/tu-usuario/nombre-del-repo.git
Importar como Proyecto Maven: El IDE descargará automáticamente Hibernate 6 y el conector de MySQL.

Maven Clean: Ejecuta el comando mvn clean install para asegurar que todas las carpetas (especialmente META-INF) se compilen correctamente.

4. Despliegue en Tomcat 11
Configura tu servidor Apache Tomcat 11 en el IDE.

Añade el artefacto del proyecto (el archivo .war o exploded).

¡Importante! Asegúrate de que el Application Context sea / o el nombre de tu carpeta para que las URLs funcionen correctamente.

Inicia el servidor.

Uso de la Aplicación
Una vez iniciado, accede a: http://localhost:8080/nombre-proyecto/ (o la URL que configuraste).

Registro: Completa el formulario con DNI, Nombre, Apellido y Teléfono. Haz clic en "Enviar".

Consulta: Haz clic en el botón "Mostrar Usuarios" para ver la lista persistida en la base de datos en una nueva tabla dinámica.

Importante saber
Manejo de Errores: Se implementó una lógica de try-catch-finally en la persistencia para garantizar que el EntityManager siempre se cierre, evitando fugas de memoria.

Sesiones: Se utiliza HttpSession para transferir la lista de usuarios desde el Servlet a la vista JSP de forma segura.

✒️ Autor
WillyDevelop
