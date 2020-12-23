package servlets;

import gestor.GestorAlumnos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Alumno;

public class AgregarAlumno extends HttpServlet {    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        if(request.getSession().getAttribute("usuario") != null){
            rd = request.getRequestDispatcher("AgregarAlumno.jsp");
        }
        else{
            rd = request.getRequestDispatcher("IniciarSesion.jsp");
        }        
        rd.forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String documento = request.getParameter("documento");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        Alumno alumno = new Alumno(documento, nombre, apellido);
        GestorAlumnos ga = new GestorAlumnos();
        ga.agregarAlumno(alumno);
        RequestDispatcher rd = request.getRequestDispatcher("ListaAlumnos.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
