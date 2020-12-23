package servlets;

import gestor.GestorMatriculas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModificarNotas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
        int idCurso = Integer.parseInt(request.getParameter("idCurso"));
        int primerParcial = Integer.parseInt(request.getParameter("primerParcial"));
        int segundoParcial = Integer.parseInt(request.getParameter("segundoParcial"));
        int notaFinal = Integer.parseInt(request.getParameter("notaFinal"));        
        int notas[] = new int[]{primerParcial, segundoParcial, notaFinal};         
        model.Alumno alumno = new gestor.GestorAlumnos().getAlumno(idAlumno);        
        request.setAttribute("alumno", alumno);
        request.setAttribute("notas", notas);
        request.setAttribute("idCurso", idCurso);
        RequestDispatcher rd = request.getRequestDispatcher("ModificarNotas.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
        int idCurso = Integer.parseInt(request.getParameter("idCurso"));
        int primerParcial = Integer.parseInt(request.getParameter("primerParcial"));
        int segundoParcial = Integer.parseInt(request.getParameter("segundoParcial"));
        int notaFinal = Integer.parseInt(request.getParameter("notaFinal"));
        GestorMatriculas gm = new GestorMatriculas();
        gm.actualizarNotas(idAlumno, idCurso, primerParcial, segundoParcial, notaFinal);
        RequestDispatcher rd = request.getRequestDispatcher("Alumno");
        rd.forward(request, response);        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
