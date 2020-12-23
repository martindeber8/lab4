<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="gestor" scope="request" class="gestor.GestorProgramas"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de programas</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
    </head>
    <body>
        <%@include file="BarraNavegacion.jsp" %>
        <br>
        <div class="container">
            <h2 style="text-align: center">5 programas mas descargados</h2>
            <hr>             
            <br>                        
            <div class="row">
                <div class="col"></div>
                <div class="col-10">                                       
                    <table class="table">
                        <thead>
                          <tr>                            
                            <th scope="col">Descripcion</th>
                            <th scope="col">Alumno</th>
                            <th scope="col">Descargas</th>
                            <c:if test="${not empty usuario}">
                            <th scope="col">Habilitacion</th>
                            </c:if>
                            <th scope="col"></th>
                          </tr>
                        </thead>                        
                        <tbody>
                          <c:forEach var="programa" items="${gestor.listaMasDescargados}">
                          <c:if test="${not empty usuario or (empty usuario and programa.habilitado == 1)}">
                          <tr>
                            <th scope="row">${programa.descripcion}</th>
                            <td>${programa.alumno.apellido}, ${programa.alumno.nombre}</td>
                            <td>${programa.cantidadDescargas}</td>
                            <c:if test="${not empty usuario}">
                                <td>
                                    <c:if test="${programa.habilitado == 1}">
                                        <form action="DescargaPrograma" method="POST">
                                            <input hidden id="idPrograma" name="idPrograma" value="${programa.idPrograma}">                                    
                                            <input type="submit" value="Deshabilitar" class="btn btn-danger">
                                        </form>
                                    </c:if>
                                    <c:if test="${programa.habilitado == 0}">
                                        <form action="DescargaPrograma" method="POST">
                                            <input hidden id="idPrograma" name="idPrograma" value="${programa.idPrograma}">                                    
                                            <input type="submit" value="Habilitar" class="btn btn-success">
                                        </form>
                                    </c:if>
                                </td>
                            </c:if>
                            <td>
                                <form action="DescargaPrograma" method="GET">
                                    <input hidden id="idPrograma" name="idPrograma" value="${programa.idPrograma}">
                                    <input hidden id="archivo" name="archivo" value="${programa.archivo}">
                                    <input type="submit" value="Descargar" onclick="window.open('programas/${programa.archivo}')">                                    
                                </form>                            
                            </td>
                          </tr>
                          </c:if>
                          </c:forEach>
                        </tbody>
                      </table>
                </div>
                <div class="col"></div>
            </div>
            <br>
            <h2 style="text-align: center">Listado de todos los programas</h2>
            <hr>             
            <br>                        
            <div class="row">
                <div class="col"></div>
                <div class="col-10">                                       
                    <table class="table">
                        <thead>
                          <tr>                            
                            <th scope="col">Descripcion</th>
                            <th scope="col">Alumno</th>
                            <th scope="col">Descargas</th>
                            <c:if test="${not empty usuario}">
                            <th scope="col">Habilitacion</th>
                            </c:if>
                            <th scope="col"></th>
                          </tr>
                        </thead>                        
                        <tbody>
                          <c:forEach var="programa" items="${gestor.listaTodosLosProgramas}">
                          <c:if test="${not empty usuario or (empty usuario and programa.habilitado == 1)}">
                          <tr>
                            <th scope="row">${programa.descripcion}</th>
                            <td>${programa.alumno.apellido}, ${programa.alumno.nombre}</td>
                            <td>${programa.cantidadDescargas}</td>
                            <c:if test="${not empty usuario}">
                                <td>
                                    <c:if test="${programa.habilitado == 1}">
                                        <form action="DescargaPrograma" method="POST">
                                            <input hidden id="idPrograma" name="idPrograma" value="${programa.idPrograma}">                                    
                                            <input type="submit" value="Deshabilitar" class="btn btn-danger">
                                        </form>
                                    </c:if>
                                    <c:if test="${programa.habilitado == 0}">
                                        <form action="DescargaPrograma" method="POST">
                                            <input hidden id="idPrograma" name="idPrograma" value="${programa.idPrograma}">                                    
                                            <input type="submit" value="Habilitar" class="btn btn-success">
                                        </form>
                                    </c:if>
                                </td>
                            </c:if>
                            <td>
                                <form action="DescargaPrograma" method="GET">
                                    <input hidden id="idPrograma" name="idPrograma" value="${programa.idPrograma}">
                                    <input hidden id="archivo" name="archivo" value="${programa.archivo}">
                                    <input type="submit" value="Descargar" onclick="window.open('programas/${programa.archivo}')">                                    
                                </form>                            
                            </td>
                          </tr>
                          </c:if>
                          </c:forEach>
                        </tbody>
                      </table>
                </div>
                <div class="col"></div>
            </div>
        </div>

    </body>
</html>
