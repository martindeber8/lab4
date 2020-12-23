package servlets;

import gestor.GestorMatriculas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InscripcionCurso extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
        model.Alumno alumno = new gestor.GestorAlumnos().getAlumno(idAlumno);
        request.setAttribute("alumno", alumno);
        RequestDispatcher rd = request.getRequestDispatcher("InscripcionCurso.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
        int idCurso = Integer.parseInt(request.getParameter("idCurso"));
        double descuento = Double.parseDouble(request.getParameter("descuento"));
        GestorMatriculas gm = new GestorMatriculas();
        model.Alumno alumno = new gestor.GestorAlumnos().getAlumno(idAlumno);
        model.Curso curso = new gestor.GestorCursos().getCurso(idCurso);
        gm.agregarMatricula(new model.Matricula(alumno, curso, descuento));
        RequestDispatcher rd = request.getRequestDispatcher("Alumno");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
