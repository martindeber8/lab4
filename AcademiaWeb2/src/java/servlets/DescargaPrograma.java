package servlets;

import gestor.GestorProgramas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DescargaPrograma extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idPrograma = Integer.parseInt(request.getParameter("idPrograma"));
        GestorProgramas gp = new GestorProgramas();
        gp.aumentarCantidadDescargas(idPrograma);        
        RequestDispatcher rd = request.getRequestDispatcher("ListaProgramas.jsp");
        rd.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idPrograma = Integer.parseInt(request.getParameter("idPrograma"));
        GestorProgramas gp = new GestorProgramas();
        gp.habODeshabPrograma(idPrograma);
        RequestDispatcher rd = request.getRequestDispatcher("ListaProgramas.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
