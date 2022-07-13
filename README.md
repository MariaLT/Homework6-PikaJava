# PikaJava- Homework 6

## Proyecto de Microservicios 

### Proyecto realizado por: 
* Sarah Fossi
* María León
* Carmen Gómez 
* Rocío Arellano

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Te damos la bienvenida a nuestro proyecto de microservicios
A continuación te invitamos a conocer qué hemos realizado en nuestro proyecto, y cual ha sido la lógica y forma de trabajo que hemos realizado. 
En este proyecto hemos utilizado el homework3 de referencia para convertir dicho proyecto en un proyecto de microservicios. 

-----------------------------------------------------------------------------------------------------------------------------------------

### ¿Cómo está conformado el proyecto?

Contamos con 2 proxys `lead-proxy-service` y `contOppAcc-proxy-service` y, con un edge `salesRep-edge-service`.
También contamos con `eureka-service` que nos permite registrar los servicios en el puerto 8761 y con un  `config-service` para la externalización y poder tener mayor escalabilidad.
También hemos realizado test de todas las peticiones de los diferentes proyectos que podrás encontrar en la carpeta de test respectiva de cada uno. 
Hemos realizado también Circuit Braker para que nuestra aplicación pueda funcionar de una forma más eficiente. 

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

### ¿Cómo usarlo? 

Para que  funcione correctamente, tendrás que levantar las terminales de cada proyecto. 
Encontrarás en este proyecto un documento `mySQL` donde encontrarás las contraseñas que tienes que usar así como los nombres de los esquemas de la base de datos. 
Te recomendamos que te crees una connection titulada homework con contraseña homework. 
También adjuntamos un documento ` Homework6.postman_collection.json ` donde encontrarás todas las peticiones que puedes hacer con el proyecto en Postman, para ahorrarte tiempo, ya que hemos incluido hasta los bodys necesarios. 
De todas formas, puedes probar a introducir nuevos datos, si así lo deseas. 
Para usar este documento solo tienes que importarlo a tu Postman. 

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
### Datos adicionales que nos gustaría que conocieras: 

* El proyecto ha sido realizado por partes iguales por las 4 miembros del grupo, debido a que nuestra dinámica de trabajo ha consistido en realizar reuniones virtuales durante todo el proyecto. No nos hemos dividido el trabajo, sino que lo hemos ido haciendo de forma simultánea en conjunto. Íbamos turnándonos para escribir el código pero el resto del equipo participaba de la escritura del mismo a la vez. 

* Al inicio del proyecto realizamos un diagrama de microservicios para poder ilustrar mejor nuestro trabajo.
Lo adjuntamos en nuestro repositorio como archivo png. Y, te lo mostramos a continuación: 

<p align="center">
    <img src = https://github.com/Pikajava/Homework6-PikaJava/blob/02068d2c80c54cab91504835befd3a2d312148bc/Diagrama%20microservicios.png
width="450">
</p>

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Por último nos gustaría agradecerte tu tiempo por probar e interesarte en nuestro proyecto; esperamos haber estado a la altura de lo que se nos pedía y que hayas pasado un agradable tiempo mientras lo revisabas. 
