package servlets;

import gestor.GestorCursos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModificarCurso extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCurso = Integer.parseInt(request.getParameter("idCurso"));
        GestorCursos gc = new GestorCursos();
        model.Curso curso = gc.getCurso(idCurso);
        request.setAttribute("datosCurso", curso);
        RequestDispatcher rd = request.getRequestDispatcher("ModificarCurso.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCurso = Integer.parseInt(request.getParameter("idCurso"));
        String descripcion = request.getParameter("descripcion");
        double precio = Double.parseDouble(request.getParameter("precio"));
        String imagen = request.getParameter("imagen");
        GestorCursos gc = new GestorCursos();
        gc.modificarCurso(new model.Curso(idCurso, descripcion, precio, imagen));
        RequestDispatcher rd = request.getRequestDispatcher("Curso");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
