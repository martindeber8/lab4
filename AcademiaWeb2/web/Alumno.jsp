
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="gestor" scope="request" class="gestor.GestorMatriculas"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil del alumno</title>
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
                          <div class="col-lg-3 col-md-5 col-sm-8">                            
                            <img src="imagenes/persona.jpg" class="card-img" alt="..." style="max-height: 200px; max-width: 200px; min-height: 200px; min-width: 200px">                            
                          </div>
                          <div class="col-lg-8 col-md-5 col-sm-4">
                            <div class="card-body">
                              <h4 class="card-title">Id:  ${alumno.idAlumno}</h4>
                              <h4 class="card-title">${alumno.apellido}, ${alumno.nombre}</h4>
                              <p class="card-text">documento: ${alumno.documento}</p>
                              <div class="row">
                                  <div class ="col-lg-3 col-md-7">
                                      <form action="ModificarAlumno" method="GET">
                                        <input type="hidden" id="idAlumno" name="idAlumno" value="${alumno.idAlumno}">
                                        <input type="submit" value="Modificar datos">
                                      </form>
                                  </div>
                                  <div class="col-lg-3 col-md-5">
                                      <form action="EliminarAlumno" method="GET">
                                        <input type="hidden" id="idAlumno" name="idAlumno" value="${alumno.idAlumno}">
                                        <input type="submit" class="btn-danger" value="Eliminar Alumno">
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
                <div class="col-6">
                    <div class="row">
                        <div class="col">
                            <form action="InscripcionCurso" method="GET">
                                <input type="hidden" value="${alumno.idAlumno}" name="idAlumno">
                                <input type="submit" class="btn btn-primary" value="Inscribir en algun curso">
                            </form>
                        </div>
                        <div class="col">
                            <form action="AgregarPrograma" method="GET">
                                <input type="hidden" value="${alumno.idAlumno}" name="idAlumno">
                                <input type="submit" class="btn btn-success" value="Añadir Programa">
                            </form>
                        </div>
                    </div>                    
                </div>
                <div class="col"></div>
            </div> 
            <br>
            <div class="row">
                <div class="col"></div>
                <div class="col-10">
                    <h3 style="text-align: center">Cursos inscripto</h3>
                    <table class="table">
                        <thead>
                          <tr>
                            <th scope="col">Id del Curso</th>
                            <th scope="col">Descripcion</th>
                            <th scope="col">Primer parcial</th>
                            <th scope="col">Segundo parcial</th>
                            <th scope="col">Final</th>
                            <th scope="col"></th>
                          </tr>
                        </thead>                        
                        <tbody>
                          <c:forEach var="curso" items="${gestor.getListaCursos(alumno.idAlumno)}">
                          <tr>
                            <th scope="row">${curso.idCurso}</th>
                            <td>${curso.descripcion}</td>
                            <td>${curso.notaPrimerParcial}</td>
                            <td>${curso.notaSegundoParcial}</td>
                            <td>${curso.notaFinal}</td>
                            <td>
                                <form action="ModificarNotas" method="GET">
                                    <input type="hidden" id="idAlumno" name="idAlumno" value="${alumno.idAlumno}">
                                    <input type="hidden" id="primerParcial" name="primerParcial" value="${curso.notaPrimerParcial}">
                                    <input type="hidden" id="segundoParcial" name="segundoParcial" value="${curso.notaSegundoParcial}">
                                    <input type="hidden" id="notaFinal" name="notaFinal" value="${curso.notaFinal}">
                                    <input type="hidden" id="idCurso" name="idCurso" value="${curso.idCurso}">
                                    <input type="submit" value="Actualizar notas">
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
