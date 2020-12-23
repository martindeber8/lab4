package gestor;

import java.util.ArrayList;
import model.Alumno;

public class GestorAlumnos extends GestorBD {

    public GestorAlumnos() {
        super();
    }
    
    public void agregarAlumno(Alumno alumno){
        try{
            conectar();
            pstmt = conexion.prepareStatement("INSERT INTO Alumnos VALUES (?, ?, ?, 1)");
            pstmt.setString(1, alumno.getDocumento());
            pstmt.setString(2, alumno.getNombre());
            pstmt.setString(3, alumno.getApellido());            
            pstmt.executeUpdate();
        }
        catch(Exception e){}
        desconectar();
    }
    
    public ArrayList<Alumno> getListaAlumnos(){
        ArrayList<Alumno> lista = new ArrayList<Alumno>();
        try{
            conectar();
            stmt = conexion.createStatement();
            query = stmt.executeQuery("SELECT * FROM Alumnos WHERE alta = 1 ORDER BY idAlumno DESC");
            
            while(query.next()){
                int idAlumno = query.getInt("idAlumno");
                String documento = query.getString("documento");
                String nombre = query.getString("nombre");
                String apellido = query.getString("apellido");
                Alumno alumno = new Alumno(idAlumno, documento, nombre, apellido);
                lista.add(alumno);
            }
        }
        catch(Exception e){}
        desconectar();
            
        return lista;
    }
    
    public Alumno getAlumno(int id){
        Alumno alumno = null;
        try{
            conectar();
            pstmt = conexion.prepareStatement("SELECT * FROM Alumnos WHERE idAlumno = ?");
            pstmt.setInt(1, id);
            query = pstmt.executeQuery();
            if(query.next()){
                int idAlumno = query.getInt("idAlumno");
                String documento = query.getString("documento");
                String nombre = query.getString("nombre");
                String apellido = query.getString("apellido");
                alumno = new Alumno(idAlumno, documento, nombre, apellido);
            }
        }
        catch(Exception e){}
        desconectar();
        
        return alumno;
    }
    
    public void modificarAlumno(Alumno alumno){
        try{
            conectar();
            pstmt = conexion.prepareStatement("UPDATE Alumnos SET documento = ?, nombre = ?, apellido = ? WHERE idAlumno = ?");
            pstmt.setString(1, alumno.getDocumento());
            pstmt.setString(2, alumno.getNombre());
            pstmt.setString(3, alumno.getApellido());
            pstmt.setInt(4, alumno.getIdAlumno());
            pstmt.executeUpdate();
        }
        catch(Exception e){}
        desconectar();
    }
    
    public void bajaAlumno(int idAlumno){
        try{
            conectar();
            pstmt = conexion.prepareStatement("UPDATE Alumnos SET alta = 0 WHERE idAlumno = ?");
            pstmt.setInt(1, idAlumno);
            pstmt.executeUpdate();
        }
        catch(Exception e){}
        desconectar();
    }
    
    
}
