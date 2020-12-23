package gestor;

import dto.CursoDTO;
import dto.FacturadoCursoDTO;
import java.util.ArrayList;
import model.Alumno;
import model.Curso;
import model.Matricula;

public class GestorMatriculas extends GestorBD {

    public GestorMatriculas() {
        super();
    }
    
    public void agregarMatricula(Matricula matricula){
        try{
            conectar();
            pstmt = conexion.prepareStatement("INSERT INTO Matriculas VALUES (?, ?, null, null, null, ?)");
            pstmt.setInt(1, matricula.getAlumno().getIdAlumno());
            pstmt.setInt(2, matricula.getCurso().getIdCurso());
            pstmt.setDouble(3, matricula.getDescuento());
            pstmt.executeUpdate();
        }
        catch(Exception e){}
        desconectar();
    }
    
    public ArrayList<Alumno> getListaAlumnos(int idCurso){
        ArrayList<Alumno> lista = new ArrayList<Alumno>();
        try{
            conectar();
            String consulta = "SELECT a.idAlumno, nombre, apellido, documento\n" +
                              "FROM Alumnos a\n" +
                              "JOIN Matriculas m ON m.idAlumno = a.idAlumno \n" +
                              "JOIN Cursos c ON c.idCurso = m.idCurso\n" +
                              "WHERE m.idCurso = ?\n" +
                              "AND a.alta = 1";
            pstmt = conexion.prepareStatement(consulta);
            pstmt.setInt(1, idCurso);
            query = pstmt.executeQuery();
            while(query.next()){
                int idAlumno = query.getInt("idAlumno");
                String nombre = query.getString("nombre");
                String apellido = query.getString("apellido");
                String documento = query.getString("documento");
                Alumno alumno = new Alumno(idAlumno, documento, nombre, apellido);
                lista.add(alumno);
            }
        }
        catch(Exception e){}
        desconectar();
        
        return lista;
    }
    
    public ArrayList<CursoDTO> getListaCursos(int idAlumno){
        ArrayList<CursoDTO> lista = new ArrayList<CursoDTO>();
        try{
            conectar();
            String consulta = "SELECT c.idCurso, descripcion, notaPrimerParcial, notaSegundoParcial, notaFinal " +
                              "FROM Cursos c " +
                              "JOIN Matriculas m ON m.idCurso = c.idCurso " +
                              "JOIN Alumnos a ON a.idAlumno = m.idAlumno " +
                              "WHERE m.idAlumno = ?";
            pstmt = conexion.prepareStatement(consulta);
            pstmt.setInt(1, idAlumno);
            query = pstmt.executeQuery();
            while(query.next()){
                int idCurso = query.getInt("idCurso");
                String descripcion = query.getString("descripcion");
                int notaPrimerParcial = query.getInt("notaPrimerParcial");
                int notaSegundoParcial = query.getInt("notaSegundoParcial");
                int notaFinal = query.getInt("notaFinal");
                CursoDTO cursoDto = new CursoDTO(idCurso, descripcion, notaPrimerParcial, notaSegundoParcial, notaFinal);
                lista.add(cursoDto);
            }
        }
        catch(Exception e){}
        desconectar();
        
        return lista;
    }
    
    public double getSumatoriaDescuentos(){
        double total = 0;
        try{
            conectar();
            stmt = conexion.createStatement();
            query = stmt.executeQuery("SELECT SUM(descuento) FROM Matriculas");
            if(query.next()){
                total = query.getDouble(1);
            }
        }
        catch(Exception e){}
        desconectar();
        
        return total;
    }
    
    public ArrayList<FacturadoCursoDTO> getTotalFacturadoCurso(){
        ArrayList<FacturadoCursoDTO> lista = new ArrayList<FacturadoCursoDTO>();
        try{
            conectar();
            String consulta = "SELECT c.idCurso, descripcion, SUM(precio - descuento)\n" +
                              "FROM Cursos c\n" +
                              "JOIN Matriculas m ON m.idCurso = c.idCurso\n" +
                              "GROUP BY c.idCurso, descripcion";
            stmt = conexion.createStatement();            
            query = stmt.executeQuery(consulta);
            while(query.next()){
                int idCurso = query.getInt("idCurso");
                String descripcion = query.getString("descripcion");
                double totalFacturado = query.getDouble(3);
                FacturadoCursoDTO fcdto = new FacturadoCursoDTO(idCurso, descripcion, totalFacturado);
                lista.add(fcdto);
            }
        }
        catch(Exception e) {}
        desconectar();
        
        return lista;
    }
    
    public ArrayList<Alumno> getListaAlumnosDescuento(){
        ArrayList<Alumno> lista = new ArrayList<Alumno>();
        try{
            conectar();
            String consulta = "SELECT DISTINCT a.idAlumno, nombre, apellido, documento\n" +
                              "FROM Alumnos a\n" +
                              "JOIN Matriculas m ON m.idAlumno = a.idAlumno\n" +
                              "WHERE descuento > 0";
            stmt = conexion.createStatement();
            query = stmt.executeQuery(consulta);
            while(query.next()){
                int idAlumno = query.getInt("idAlumno");
                String nombre = query.getString("nombre");
                String apellido = query.getString("apellido");
                String documento = query.getString("documento");
                Alumno alumno = new Alumno(idAlumno, documento, nombre, apellido);
                lista.add(alumno);
            }
        }
        catch(Exception e) {}
        desconectar();
        
        return lista;
    }
    
    public void actualizarNotas(int idAlumno, int idCurso, int notaUno, int notaDos, int notaFinal){
        try{
            conectar();
            String consulta = "UPDATE Matriculas SET notaPrimerParcial = ?, notaSegundoParcial = ?, notaFinal = ? " +
                              " WHERE idAlumno = ? AND idCurso = ?";
            pstmt = conexion.prepareStatement(consulta);
            pstmt.setInt(1, notaUno);
            pstmt.setInt(2, notaDos);
            pstmt.setInt(3, notaFinal);
            pstmt.setInt(4, idAlumno);
            pstmt.setInt(5, idCurso);
            pstmt.executeUpdate();            
        }
        catch(Exception e){}
        desconectar();
    }
    
}
