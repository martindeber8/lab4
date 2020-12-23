<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar datos del Alumno</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
    </head>
    <body>
        <%@include file="BarraNavegacion.jsp" %>
        <br>
        <div class="container">
            <div class="row">
                <div class="col"></div>
                <div class="col-lg-4 col-md-6 col-10">
                    <h1 style="text-align: center;">Modificar datos del Alumno</h1>
                    <hr>
                    <form action="ModificarAlumno" method="POST">
                        <div class="form-group">
                            <label for="idAlumno">Identificador: (este campo no puede modificarse)</label>  
                            <input type="hidden" value="${datosAlumno.idAlumno}" id="idAlumno" name="idAlumno">
                            <input disabled required type="text" class="form-control" placeholder="${datosAlumno.idAlumno}" value="${datosAlumno.idAlumno}">
                        </div>
                        <div class="form-group">
                            <label for="documento">Documento:</label>
                            <input required type="text" class="form-control" id="documento" name="documento" placeholder="${datosAlumno.documento}" value="${datosAlumno.documento}">
                        </div>
                        <div class="form-group">
                            <label for="nombre">Nombre:</label>
                            <input required type="text" class="form-control" id="nombre" name="nombre" placeholder="${datosAlumno.nombre}" value="${datosAlumno.nombre}">
                        </div>
                        <div class="form-group">
                            <label for="apellido">Apellido:</label>
                            <input required type="text"  class="form-control" id="apellido" name="apellido" placeholder="${datosAlumno.apellido}" value="${datosAlumno.apellido}">
                        </div>
                        <br>
                        <div class="form-group row">
                            <div class="col"></div>
                            <div class="col">
                                <input type="submit" value="Modificar" class="btn btn-dark" >
                            </div>
                            <div class="col"></div>
                        </div>
                    </form>
                </div>
                <div class="col"></div>
            </div>
        </div>
    </body>
</html>
