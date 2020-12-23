
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="gestor" scope="request" class="gestor.GestorMatriculas"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reportes</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
    </head>
    <body>
        <%@include file="BarraNavegacion.jsp" %>
        <br>
        <div class="container">
            <h2 style="text-align: center">Reportes</h2>
            <hr>
            <div class="row">
                <div class="col-5">
                    <h5>Alumnos con algun descuento:</h5>
                    <h6>Total de descuentos realizados en pesos: $ ${gestor.sumatoriaDescuentos}</h6>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="row">Documento</th>
                                <th scope="row">Nombre Completo</th>                            
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="alumno" items="${gestor.listaAlumnosDescuento}">
                            <tr>
                                <td>${alumno.documento}</td>
                                <td>${alumno.apellido}, ${alumno.nombre}</td>                            
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>                
                </div>
                <div class="col"></div>
                <div class="col-5">
                    <h5>Total facturado por curso:</h5>
                    <br>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="row">Descripcion</th>
                                <th scope="row">Total facturado</th>                            
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="curso" items="${gestor.totalFacturadoCurso}">
                            <tr>
                                <td>${curso.descripcion}</td>
                                <td>$ ${curso.totalFacturado}</td>                            
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
