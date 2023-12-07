# Prueba-Tecnica
NOTA: He utilizado una base de datos en memoria H2, asi que solo es compilar y ejecutar

Para que este proyecto pueda compilar y ejecutarse bien, necesita Java 11 y cualquier version de Maven

Para crear imagen Docker se usa el siguiente comando:  docker build -t pruebatecnica .
Para ejecutar la imagen Docker se usa el siguiente comando: docker run -p 8082:8090 pruebatecnica
NOTA: Para que la imagen Docker se cree y se ejecute debes tener instalado Docker en el computador

Para entrar a la documentacion swagger cuando esta desplegado desde el IDE de desarrollo la url es la siguiente: http://localhost:8090/pruebaTecnica/swagger-ui.html#

Para entrar a la documentacion swagger cuando la aplicacion este desplegada en Docker la url es la siguiente: http://localhost:8082/pruebaTecnica/swagger-ui.html#
