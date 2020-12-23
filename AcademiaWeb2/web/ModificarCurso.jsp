<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar datos del Curso</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
    </head>
    <body>
        <%@include file="BarraNavegacion.jsp" %>
        <br>
        <div class="container">
            <div class="row">
                <div class="col"></div>
                <div class="col-lg-4 col-md-6 col-10">
                    <h1 style="text-align: center;">Modificar datos del Curso</h1>
                    <hr>
                    <form action="ModificarCurso" method="POST">
                        <div class="form-group">
                            <label for="idCurso">Id del curso: (este campo no puede modificarse)</label>  
                            <input type="hidden" value="${datosCurso.idCurso}" id="idCurso" name="idCurso">
                            <input disabled required type="text" class="form-control" placeholder="${datosCurso.idCurso}" value="${datosCurso.idCurso}">
                        </div>
                        <div class="form-group">
                            <label for="descripcion">Descripción:</label>
                            <input required type="text" class="form-control" id="descripcion" name="descripcion" placeholder="${datosCurso.descripcion}" value="${datosCurso.descripcion}">
                        </div>
                        <div class="form-group">
                            <label for="precio">Precio: ($)</label>
                            <input required type="number" class="form-control" id="precio" name="precio" placeholder="${datosCurso.precio}" value="${datosCurso.precio}">
                        </div>
                        <div>
                            <label for="imagen">Cambiar Imagen:</label>
                            <input type="file" accept="image/*" id="imagen" name="imagen">
                            <span>(El servidor solo alojara archivos de tipo imagen)</span>
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
