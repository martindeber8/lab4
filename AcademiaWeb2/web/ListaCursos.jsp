
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="gestor" scope="request" class="gestor.GestorCursos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de cursos</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
    </head>
    <body>
        <%@include file="BarraNavegacion.jsp" %>
        <br>
        <div class="container">
            <h2 style="text-align: center">Listado de todos los cursos</h2>
            <hr>
            <c:if test="${not empty usuario}">
            <div class="row">
            <div class="col"></div>
                <div class="col-3">
                    <a href="AgregarCurso"><button class="btn btn-primary">Agregar nuevo curso</button></a>
                </div>
                <div class="col"></div>
            </div>
            </c:if>
            <br>
            <div class="row">
                <div class="col"></div>
                <div class="col-11">
                    <div class="row">
                    <c:forEach var="curso" items="${gestor.listaAlumnos}">                    
                        <div class="card col-3 col-md-6 col-sm-6 col-lg-3" style="width: 18rem; margin-bottom: 5px">
                            <c:if test="${not empty curso.imagen}">
                            <img src="imagenes/${curso.imagen}" class="card-img-top" alt="..." style="max-width: 100%; max-height: 100%; min-width: 100%; min-height: 60%; margin-top: 5px;">
                            </c:if>
                            <c:if test="${empty curso.imagen}">
                            <img src="imagenes/default.jpg" class="card-img-top" alt="..." style="max-width: 100%; max-height: 100%; min-width: 100%; min-height: 60%; margin-top: 5px;">
                            </c:if>
                            <div class="card-body">
                              <h5 class="card-title">Curso de ${curso.descripcion}</h5>
                              <c:if test="${not empty usuario}">
                              <form action="Curso" method="POST">
                                  <input type="hidden" id="idCurso" name="idCurso" value="${curso.idCurso}"/>
                                  <input type="submit" class="btn btn-dark" value="Ver curso">
                              </form>
                              </c:if>
                              <c:if test="${empty usuario}">
                                  <p class="text-muted">$ ${curso.precio}</p>
                              </c:if>
                            </div>
                        </div>                         
                    </c:forEach>
                    </div>    
                </div>
                <div class="col"></div>
            </div>
        </div>
    </body>
</html>
