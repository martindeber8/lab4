
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesión</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
    </head>
    <body>
        <%@include file="BarraNavegacion.jsp" %>
        <br>
        <div class="container">
            <div class="row">
                <div class="col"></div>
                <div class="col-lg-4 col-md-6 col-10">
                    <h1 style="text-align: center;">Iniciar Sesión</h1>
                    <hr>
                    <form action="IniciarSesion" method="POST">                        
                        <div class="form-group">
                            <label for="usuario">Usuario:</label>
                            <input required type="text" class="form-control" id="usuario" name="usuario" placeholder="Ingrese su nombre de usuario">
                        </div>
                        <div class="form-group">
                            <label for="contraseña">Contraseña:</label>
                            <input required type="password" class="form-control" id="password" name="password" placeholder="Ingrese su contraseña">
                        </div>
                        <c:if test="${not empty mensajeError}">
                          <div style="text-align: center; color: red;">${mensajeError}</div>
                          <br>
                        </c:if>                          
                        <c:if test="${empty mensajeError}">                    
                        <br>
                        <br>
                        </c:if>
                        <div class="form-group row">
                            <div class="col"></div>
                            <div class="col">                                
                                <input type="submit" value="Iniciar Sesión" class="btn btn-dark" >
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
