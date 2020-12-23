package servlets;

import gestor.GestorAlumnos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EliminarAlumno extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
        GestorAlumnos ga = new GestorAlumnos();
        model.Alumno alumno = ga.getAlumno(idAlumno);
        request.setAttribute("datosAlumno", alumno);
        RequestDispatcher rd = request.getRequestDispatcher("EliminarAlumno.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
        GestorAlumnos ga = new GestorAlumnos();
        ga.bajaAlumno(idAlumno);
        RequestDispatcher rd = request.getRequestDispatcher("ListaAlumnos.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
