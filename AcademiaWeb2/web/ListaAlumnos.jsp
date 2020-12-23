<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="gestor" scope="request" class="gestor.GestorAlumnos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de alumnos</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
    </head>
    <body>
        <%@include file="BarraNavegacion.jsp" %>
        <br>
        <c:if test="${empty usuario}">
            <h2 style="text-align: center">Para acceder a este módulo es necesario Iniciar Sesion</h2>
        </c:if>
        <c:if test="${not empty usuario}">
        <div class="container">
            <h2 style="text-align: center">Listado de todos los alumnos</h2>
            <hr> 
            <div class="row">
                <div class="col"></div>
                <div class="col-3"><a href="AgregarAlumno"><button class="btn btn-primary">Agregar nuevo alumno</button></a></div>
                <div class="col"></div>
            </div>
            <br>                        
            <div class="row">
                <div class="col"></div>
                <div class="col-10">                                       
                    <table class="table">
                        <thead>
                          <tr>
                            <th scope="col">Identificador</th>
                            <th scope="col">Documento</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Apellido</th>
                            <th scope="col">Más</th>
                          </tr>
                        </thead>                        
                        <tbody>
                          <c:forEach var="alumno" items="${gestor.listaAlumnos}">
                          <tr>
                            <th scope="row">${alumno.idAlumno}</th>
                            <td>${alumno.documento}</td>
                            <td>${alumno.nombre}</td>
                            <td>${alumno.apellido}</td>
                            <td>
                                <form action="Alumno" method="POST">
                                    <input type="hidden" id="idAlumno" name="idAlumno" value="${alumno.idAlumno}">
                                    <input type="submit" value="Ver perfil">
                                </form>
                            </td>
                          </tr>    
                          </c:forEach>
                        </tbody>
                      </table>
                </div>
                <div class="col"></div>
            </div>
        </div>
        </c:if>

    </body>
</html>
