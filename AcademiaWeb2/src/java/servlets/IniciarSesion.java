package servlets;

import gestor.GestorUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

public class IniciarSesion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = null;
        if(request.getSession() != null){          
            rd = request.getRequestDispatcher("Principal.jsp");
        }
        else{
            rd = request.getRequestDispatcher("IniciarSesion.jsp");
        }        
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreUsuario = request.getParameter("usuario");
        String contraseña = request.getParameter("password");        
        Usuario usuario = new GestorUsuarios().getUsuario(nombreUsuario, contraseña);
        if(usuario != null){
            request.getSession().setAttribute("usuario", usuario);
            RequestDispatcher rd = request.getRequestDispatcher("Principal.jsp");
            rd.forward(request, response);
        }
        else{
            request.setAttribute("mensajeError", "Usuario o contraseña incorrecta");
            RequestDispatcher rd = request.getRequestDispatcher("IniciarSesion.jsp");
            rd.forward(request, response);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
