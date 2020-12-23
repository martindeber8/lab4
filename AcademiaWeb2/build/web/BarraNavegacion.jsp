<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
        <a class="navbar-brand" href="Principal.jsp">Academia</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <a class="nav-link" href="ListaProgramas.jsp">Programas</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="ListaCursos.jsp">Cursos</a>
            </li>
            <c:if test="${not empty usuario}">
            <li class="nav-item">
              <a class="nav-link" href="ListaAlumnos.jsp">Alumnos</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="Reportes.jsp">Reportes</a>
            </li>
            </c:if>
          </ul>
          <span class="navbar-text">      
            <ul class="navbar-nav mr-auto">
                <c:if test="${empty usuario}">
                    <li class="nav-item">  
                        <a class="nav-link nav-item" href="IniciarSesion.jsp">Iniciar Sesión</a>    
                    </li>
                </c:if>
                <c:if test="${not empty usuario}">
                    <li class="nav-item">  
                        <span class="nav-link">Bienvenido ${usuario.nombreUsuario}</span> 
                    </li>
                    <li class="nav-item">  
                        <a class="nav-link nav-item" href="CerrarSesion">Cerrar Sesión</a>    
                    </li>
                </c:if>
            </ul>
          </span>
        </div>
      </nav>
