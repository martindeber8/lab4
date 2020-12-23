<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Notas</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
    </head>
    <body>
        <%@include file="BarraNavegacion.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col"></div>
                <div class="col-lg-4 col-md-6 col-10">
                    <h4>Modificar notas del alumno ${alumno.apellido}, ${alumno.nombre}</h4>
                    <hr>
                    <form action="ModificarNotas" method="POST">
                        <div class="form-group">
                            <label for="primerParcial">Nota del Primer Parcial:</label>
                            <input required type="number" class="form-control" id="primerParcial" name="primerParcial" value="${notas[0]}">
                        </div>
                        <div class="form-group">
                            <label for="segundoParcial">Nota del Primer Parcial:</label>
                            <input required type="number" class="form-control" id="segundoParcial" name="segundoParcial" value="${notas[1]}">
                        </div>
                        <div class="form-group">
                            <label for="notaFinal">Nota del Final:</label>
                            <input required type="number" class="form-control" id="notaFinal" name="notaFinal" value="${notas[2]}">
                        </div>
                        <div class="form-group row">
                            <div class="col"></div>
                            <div class="col">
                                <input type="hidden" value="${alumno.idAlumno}" id="idAlumno" name="idAlumno">
                                <input type="hidden" value="${idCurso}" id="idCurso" name="idCurso">
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
