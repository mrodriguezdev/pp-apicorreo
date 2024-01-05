# pp-apicorreo

Este proyecto, creado por **mrodriguezdev**, constituye el backend de mi portafolio web personal. Para obtener más información sobre Quarkus, visita [quarkus.io](https://quarkus.io/)

> [!NOTE]
> **PP:** Este proyecto es personal y ha sido creado con propósitos personales. La abreviatura "PP" se refiere a "Proyecto Personal".

## Descripción del proyecto
El proyecto se centra en la aplicación práctica de mis conocimientos en el desarrollo de microservicios, haciendo hincapié en la implementación de la arquitectura Hexagonal, también conocida como puertos y adaptadores.
Este backend se encarga específicamente de gestionar los formularios de contacto presentes en mi portafolio.

## Documentación OpenAPI

La documentación OpenAPI proporciona una especificación detallada de la API del proyecto.

```shell script
url=PATH/documentacion
```

## Variables de Entorno

Para ejecutar y configurar este proyecto, se deben definir las siguientes variables de entorno:

```shell script
CORS_ORIGIN=< URL permitida para solicitudes CORS >
HOST_CORREO=< Servidor de correo electrónico >
PUERTO_HOST=< Puerto del servidor de correo >
MAIL_ADDRES=< Nombre de usuario para acceder al servidor de correo >
MAIL_PASSWORD=< Contraseña asociada al usuario de correo >
MAIL_CC_ADDRES=< Dirección de correo en copia para la aplicación >
WEB_APP_DOMAIN=< URL de la aplicación web >
```