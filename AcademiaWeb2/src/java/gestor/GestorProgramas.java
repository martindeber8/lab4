package gestor;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.Alumno;
import model.Programa;

public class GestorProgramas extends GestorBD {

    public GestorProgramas() {
        super();
    }

    public void agregarPrograma(Programa programa){
        try{
            conectar();
            pstmt = conexion.prepareStatement("INSERT INTO Programas VALUES (?, ?, ?, 1, 0)");
            pstmt.setInt(1, programa.getAlumno().getIdAlumno());
            pstmt.setString(2, programa.getArchivo());
            pstmt.setString(3, programa.getDescripcion());
            pstmt.executeUpdate();
        }
        catch(Exception e){}
        desconectar();
    }
    
    public ArrayList<Programa> getListaProgramas(){
        ArrayList<Programa> lista = new ArrayList<Programa>();
        try{
            conectar();
            stmt = conexion.createStatement();
            query = stmt.executeQuery("SELECT * FROM Programas WHERE habilitado = 1 ORDER BY idPrograma DESC");
            while(query.next()){
                int idPrograma = query.getInt("idPrograma");
                int idAlumno = query.getInt("idAlumno");
                String archivo = query.getString("archivo");
                String descripcion = query.getString("descripcion");
                int habilitado = query.getInt("habilitado");
                int cantidadDescargars = query.getInt("cantidadDescargas");                
                Programa programa = new Programa(idPrograma, getAlumno(idAlumno), archivo, descripcion, habilitado, cantidadDescargars);
                lista.add(programa);
            }
        }
        catch(Exception e){}
        desconectar();
        
        return lista;        
    }
    
    public ArrayList<Programa> getListaTodosLosProgramas(){
        ArrayList<Programa> lista = new ArrayList<Programa>();
        try{
            conectar();
            stmt = conexion.createStatement();
            query = stmt.executeQuery("SELECT * FROM Programas ORDER BY idPrograma DESC");
            while(query.next()){
                int idPrograma = query.getInt("idPrograma");
                int idAlumno = query.getInt("idAlumno");
                String archivo = query.getString("archivo");
                String descripcion = query.getString("descripcion");
                int habilitado = query.getInt("habilitado");
                int cantidadDescargars = query.getInt("cantidadDescargas");                
                Programa programa = new Programa(idPrograma, getAlumno(idAlumno), archivo, descripcion, habilitado, cantidadDescargars);
                lista.add(programa);
            }
        }
        catch(Exception e){}
        desconectar();
        
        return lista;        
    }    
    
    private Alumno getAlumno(int id){ ///// para traer el alumno del programa
        Alumno alumno = null;
        try{
            conectar();
            pstmt = conexion.prepareStatement("SELECT * FROM Alumnos WHERE idAlumno = ?");
            pstmt.setInt(1, id);
            ResultSet query = pstmt.executeQuery();
            if(query.next()){
                int idAlumno = query.getInt("idAlumno");
                String documento = query.getString("documento");
                String nombre = query.getString("nombre");
                String apellido = query.getString("apellido");
                alumno = new Alumno(idAlumno, documento, nombre, apellido);
            }
        }
        catch(Exception e){}        
        
        return alumno;
    }
    
    public void aumentarCantidadDescargas(int id){
        try{
            conectar();
            pstmt = conexion.prepareStatement("UPDATE Programas SET cantidadDescargas = cantidadDescargas + 1 WHERE idPrograma = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
        catch(Exception e){}
        desconectar();
    }
    
    public void habODeshabPrograma(int id){
        try{
            conectar();
            pstmt = conexion.prepareStatement("UPDATE Programas SET habilitado = ~habilitado WHERE idPrograma = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
        catch(Exception e){}
        desconectar();
    }
    
    public ArrayList<Programa> getListaMasDescargados(){
        ArrayList<Programa> lista = new ArrayList<Programa>();
        try{
            conectar();
            stmt = conexion.createStatement();
            query = stmt.executeQuery("SELECT TOP 5 * FROM Programas WHERE habilitado = 1 ORDER BY cantidadDescargas DESC");
            while(query.next()){
                int idPrograma = query.getInt("idPrograma");
                int idAlumno = query.getInt("idAlumno");
                String archivo = query.getString("archivo");
                String descripcion = query.getString("descripcion");
                int habilitado = query.getInt("habilitado");
                int cantidadDescargas = query.getInt("cantidadDescargas");
                Programa programa = new Programa(idPrograma, getAlumno(idAlumno), archivo, descripcion, habilitado, cantidadDescargas);
                lista.add(programa);
            }
        }
        catch(Exception e){}
        desconectar();
        
        return lista;
    }
    
    
    
}
