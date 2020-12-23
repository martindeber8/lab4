package servlets;

import gestor.GestorCursos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Curso;


@MultipartConfig(
        fileSizeThreshold= 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize= 1024 * 1024 * 6,
        location= "D:\\martin\\UTN\\Laboratorio IV\\AcademiaWeb\\AcademiaWeb2\\web\\imagenes"
)
public class AgregarCurso extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        if(request.getSession().getAttribute("usuario") != null){
            rd = request.getRequestDispatcher("AgregarCurso.jsp");
        }
        else{
            rd = request.getRequestDispatcher("IniciarSesion.jsp");
        }        
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String descripcion = request.getParameter("descripcion");
        double precio = Double.parseDouble(request.getParameter("precio"));
        String fileName = "";
        for (Part part: request.getParts()){            
            fileName = getFileName(part);
            if(!fileName.isEmpty()){
                part.write(fileName);
            }
        }
        GestorCursos gc = new GestorCursos();
        gc.agregarCurso(new Curso(descripcion, precio, fileName));
        RequestDispatcher rd = request.getRequestDispatcher("ListaCursos.jsp");
        rd.forward(request, response);
        
    }
    
    private String getFileName(Part part){
        for(String content : part.getHeader("content-disposition").split(";")){
            if(content.trim().startsWith("filename") && part.getContentType().contains("image")){
                return content.substring(content.indexOf("=") + 2, content.length() -1);
            }
        }
        return "";
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
