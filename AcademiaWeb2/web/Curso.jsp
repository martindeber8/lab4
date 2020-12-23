
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="gestor" scope="request" class="gestor.GestorMatriculas"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Curso de ${curso.descripcion}</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
    </head>
    <body>        
        <%@include file="BarraNavegacion.jsp" %>
        <br>
        <div class="container">
            <div class="row">
                <div class="col"></div>
                <div class="col-10">
                    <div class="card mb-3" >
                        <div class="row no-gutters">
                          <div class="col-lg-4 col-md-7 col-sm-8">
                            <c:if test="${not empty curso.imagen}">
                                <img src="imagenes/${curso.imagen}" class="card-img" alt="..." style="max-height: 200px; max-width: 300px; min-height: 200px; min-width: 300px">
                            </c:if>
                            <c:if test="${empty curso.imagen}">
                                <img src="imagenes/default.jpg" class="card-img" alt="..." style="max-height: 200px; max-width: 300px; min-height: 200px; min-width: 300px">
                            </c:if>
                          </div>
                          <div class="col-lg-8 col-md-5 col-sm-4">
                            <div class="card-body">
                              <h4 class="card-title">${curso.descripcion}</h4>
                              <p class="card-text">Curso de ${curso.descripcion}</p>
                              <p class="card-text"><small class="text-muted">Precio: $ ${curso.precio}</small></p>
                              <div class="row">
                                  <div class="col-lg-3 col-md-7">
                                      <form action="ModificarCurso" method="GET">
                                        <input type="hidden" id="idCurso" name="idCurso" value="${curso.idCurso}">
                                        <input type="submit" value="Modificar datos">
                                      </form>
                                  </div>
                                  <div class="col-lg-3 col-md-5">
                                    <form action="EliminarCurso" method="GET">
                                      <input type="hidden" id="idCurso" name="idCurso" value="${curso.idCurso}">
                                      <input type="submit" class="btn-danger" value="Eliminar Curso">
                                    </form>      
                                  </div>
                              </div>
                              
                            </div>
                          </div>
                        </div>
                    </div>
                </div>
                <div class="col"></div>
            </div>   
            <div class="row">
                <div class="col"></div>
                <div class="col-10">
                    <h3 style="text-align: center">Listado de alumnos de este curso</h3>
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
                          <c:forEach var="alumno" items="${gestor.getListaAlumnos(curso.idCurso)}">
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
    </body>
</html>
