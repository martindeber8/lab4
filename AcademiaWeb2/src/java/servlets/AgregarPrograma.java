package servlets;

import gestor.GestorAlumnos;
import gestor.GestorProgramas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Programa;

@MultipartConfig(
        fileSizeThreshold= 1024 * 1024,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize= 1024 * 1024 * 55,
        location= "D:\\martin\\UTN\\Laboratorio IV\\AcademiaWeb\\AcademiaWeb2\\web\\programas"
)
public class AgregarPrograma extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
        GestorAlumnos ga = new GestorAlumnos();
        model.Alumno alumno = ga.getAlumno(idAlumno);
        request.setAttribute("datosAlumno", alumno);
        RequestDispatcher rd = request.getRequestDispatcher("AgregarPrograma.jsp");
        rd.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
        model.Alumno alumno = new gestor.GestorAlumnos().getAlumno(idAlumno);        
        String descripcion = request.getParameter("descripcion");
        String fileName = "";
        for (Part part: request.getParts()){            
            fileName = getFileName(part);
            if(!fileName.isEmpty()){
                fileName = idAlumno + "_" + fileName;
                part.write(fileName);
            }
        }
        GestorProgramas gp = new GestorProgramas();
        gp.agregarPrograma(new Programa(alumno, fileName, descripcion));
        RequestDispatcher rd = request.getRequestDispatcher("ListaProgramas.jsp");
        rd.forward(request, response);        
    }
    
    private String getFileName(Part part){
        for(String content : part.getHeader("content-disposition").split(";")){
            if(content.trim().startsWith("filename")){
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
