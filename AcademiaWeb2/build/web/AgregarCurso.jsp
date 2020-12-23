
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar curso</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
    </head>
    <body>
        <%@include file="BarraNavegacion.jsp" %>
        <br>
        <div class="container">
            <div class="row">
                <div class="col"></div>
                <div class="col-lg-4 col-md-6 col-10">
                    <h1 style="text-align: center;">Agregar Curso</h1>
                    <hr>
                    <form action="" method="POST" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="descripcion">Descripcion:</label>
                            <input required type="text" class="form-control" id="descripcion" name="descripcion" placeholder="Ingrese la descripcion">
                        </div>
                        <div class="form-group">
                            <label for="precio">Precio: ($)</label>
                            <input required type="number" class="form-control" id="precio" name="precio" placeholder="Ingrese el precio">
                        </div>      
                        <div>
                            <label for="imagen">Agregar Imagen:</label>
                            <input type="file" accept="image/*" id="imagen" name="imagen">
                            <span>(El servidor solo alojara archivos de tipo imagen)</span>
                        </div>              
                        <br>
                        <div class="form-group row">
                            <div class="col"></div>
                            <div class="col">
                                <input type="submit" value="Agregar" class="btn btn-dark" >
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
