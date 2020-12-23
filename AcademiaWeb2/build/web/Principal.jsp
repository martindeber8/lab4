
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Academia</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
    </head>
    <body>
        <%@include file="BarraNavegacion.jsp" %>
        <br>
        <div class="container">
            <div class="row" style="text-align: center;">
                <div class="col"></div>
                <div class="col-6">
                    <h2>Segundo Parcial Laboratorio IV - Tema 3 - Pagina web para Academia</h2>
                    <hr>
                    <p>
                        Trabajo práctico realizado por:
                        <br>
                        <b>de Bernardo, Lautaro Martin</b>
                        <br>
                        legajo: <b>110930</b> curso: <b>2W2</b>
                    </p>
                    <br>
                    <h3>Leer el archivo LEER.TXT que se encuentra fuera de la carpeta del proyecto</h3>
                    <p style="text-align: left;">                        
                        <b>Información necesaria para navegar por el proyecto:</b>  
                        <br>
                        - Es necesario correr el script (inserts inclusive) de la bbdd que se encuentra fuera de la carpeta del proyecto
                        <br>
                        - Hay que cambiar la cadena de conexion en la clase GestorBD, asi como usuario y contraseña
                        <br>
                        - El único usuario habilitado es admin  (usuario: admin  //  contraseña: admin).
                        <br>
                        - Para acceder a algunos modulos (como alumnos y reportes) es necesario estar logueado como admin.
                        <br>
                        - Loguearse como admin desbloquea funciones de ABMC de cursos y alumnos.
                        <br>
                        - Hay algunos datos y archivos cargados a modo de ejemplo (algunos programas e imagenes)
                        <br>
                        - En el modulo programas se encuentra la lista de los 5 programas mas descargados y la lista completa (se pueden deshabilitar estando logueado)
                        <br>
                        - En el modulo Cursos se pueden observar los cursos disponibles y logueado se puede agregar nuevos cursos, modificar y ver la lista de alumnos por cada curso.
                        <br>
                        - En el modulo Alumnos (hay que estar logueado para que aparezca) se puede hacer la ABMC de alumnos, agregar programas y hacer las inscripciones.
                        <br>
                        - En el modulo Reportes se encuentra: 1.Lista de alumnos con descuentos, 2.Total facturado por curso, 3.Total Descuentos.
                        <br>
                        - El proyecto cumple con todas las consignas pedidas e incluye algunas otras funcionalidades para que sea mas consistente con lo pedido.
                        <br>
                        - El proyecto se realizo con GlassFish 5.0.1 y JDK 1.8_151 por problemas de compatibilidad (la carpeta sun de glassfish fue borrada para poder realizar el proyecto)
                    </p>
                </div>
                <div class="col"></div>
            </div>
        </div>       
        
    </body>
</html>
