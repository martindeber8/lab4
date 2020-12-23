package servlets;

import gestor.GestorCursos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EliminarCurso extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCurso = Integer.parseInt(request.getParameter("idCurso"));
        GestorCursos gc = new GestorCursos();
        model.Curso curso = gc.getCurso(idCurso);
        request.setAttribute("datosCurso", curso);
        RequestDispatcher rd = request.getRequestDispatcher("EliminarCurso.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCurso = Integer.parseInt(request.getParameter("idCurso"));
        GestorCursos gc = new GestorCursos();
        gc.bajaCurso(idCurso);
        RequestDispatcher rd = request.getRequestDispatcher("ListaCursos.jsp");
        rd.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
