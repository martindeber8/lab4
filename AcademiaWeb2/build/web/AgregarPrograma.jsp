
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Programa</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
    </head>
    <body>
        <%@include file="BarraNavegacion.jsp" %>
        <br>
        <div class="container">
            <div class="row">
                <div class="col"></div>
                <div class="col-lg-4 col-md-6 col-10">
                    <h1 style="text-align: center;">Agregar Programa</h1>
                    <hr>
                    <form action="AgregarPrograma" method="POST" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="alumno">Alumno:</label>
                            <input type="hidden" value="${datosAlumno.idAlumno}" id="idAlumno" name="idAlumno">
                            <input disabled type="text" class="form-control" id="alumno" name="alumno" value="${datosAlumno.apellido}, ${datosAlumno.nombre}">
                        </div>
                        <div class="form-group">
                            <label for="precio">Descripcion:</label>
                            <input required type="text" class="form-control" id="descripcion" name="descripcion" placeholder="Ingrese una breve descripcion">
                        </div>                         
                        <div>
                            <label for="imagen">Subir Archivo:</label>
                            <input required type="file"  id="archivo" name="archivo">                            
                        </div>              
                        <br>
                        <div class="form-group row">
                            <div class="col"></div>
                            <div class="col">
                                <input type="submit" value="Agregar" class="btn btn-dark" >
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
