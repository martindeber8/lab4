<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Alumno</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
    </head>
    <body>
        <%@include file="BarraNavegacion.jsp" %>
        <br>
        <div class="container">
            <div class="row">
                <div class="col"></div>
                <div class="col-lg-4 col-md-6 col-10" style="text-align: center">
                    <h1>Eliminar Curso</h1>
                    <hr>
                    <p>Usted está por dar de baja al curso:</p>                    
                    <h4>${datosCurso.descripcion}</h4>
                    <br>
                    <div class="row">
                        <div class="col"></div>
                        <div class="col">
                            <form action="EliminarCurso" method="POST">
                                <input type="hidden" value="${datosCurso.idCurso}" id="idCurso" name="idCurso">
                                <input type="submit" value="Eliminar" class="btn btn-danger">
                            </form>
                            <br>
                            <a href="ListaCursos.jsp" class="btn btn-primary">Cancelar</a>
                        </div>
                        <div class="col"></div>
                    </div>
                </div>
                <div class="col"></div>
            </div>
        </div>
    </body>
</html>
