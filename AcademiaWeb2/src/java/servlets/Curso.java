package servlets;

import gestor.GestorCursos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Curso extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCurso = Integer.parseInt(request.getParameter("idCurso"));
        GestorCursos gc = new GestorCursos();
        model.Curso curso = gc.getCurso(idCurso);
        request.setAttribute("curso", curso);
        RequestDispatcher rd = request.getRequestDispatcher("Curso.jsp");
        rd.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
