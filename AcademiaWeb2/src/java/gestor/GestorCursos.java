package gestor;

import java.util.ArrayList;
import model.Curso;

public class GestorCursos extends GestorBD {

    public GestorCursos() {
        super();
    }
    
    public void agregarCurso(Curso curso){
        try{
            conectar();
            pstmt = conexion.prepareStatement("INSERT INTO Cursos VALUES (?, ?, ?, 1)");
            pstmt.setString(1, curso.getDescripcion());
            pstmt.setDouble(2, curso.getPrecio());
            pstmt.setString(3, curso.getImagen());
            pstmt.executeUpdate();
        }
        catch(Exception e){}
        desconectar();
    }
    
    public ArrayList<Curso> getListaAlumnos(){
        ArrayList<Curso> lista = new ArrayList<Curso>();
        try{
            conectar();
            stmt = conexion.createStatement();
            query = stmt.executeQuery("SELECT * FROM Cursos WHERE alta = 1");
            
            while(query.next()){
                int idCurso = query.getInt("idCurso");
                String descripcion = query.getString("descripcion");
                double precio = query.getDouble("precio");        
                String imagen = query.getString("imagen");
                Curso curso = new Curso(idCurso, descripcion, precio, imagen);
                lista.add(curso);
            }
        }
        catch(Exception e){}
        desconectar();
            
        return lista;
    }
    
    public Curso getCurso(int id){
        Curso curso = null;
        try{
            conectar();
            pstmt = conexion.prepareStatement("SELECT * FROM Cursos WHERE idCurso = ?");
            pstmt.setInt(1, id);
            query = pstmt.executeQuery();
            if(query.next()){
                int idCurso = query.getInt("idCurso");
                String descripcion = query.getString("descripcion");
                double precio = query.getDouble("precio");
                String imagen = query.getString("imagen");
                curso = new Curso(idCurso, descripcion, precio, imagen);
            }
        }
        catch(Exception e){}
        desconectar();
        
        return curso;
    }
    
    public void modificarCurso(Curso curso){
        try{
            conectar();
            if(curso.getImagen().isEmpty() || curso.getImagen() == null){
                pstmt = conexion.prepareStatement("UPDATE Cursos SET descripcion = ?, precio = ? WHERE idCurso = ?");
                pstmt.setString(1, curso.getDescripcion());
                pstmt.setDouble(2, curso.getPrecio());
                pstmt.setInt(3, curso.getIdCurso());
            }
            else{
                pstmt = conexion.prepareStatement("UPDATE Cursos SET descripcion = ?, precio = ?, imagen = ? WHERE idCurso = ?");
                pstmt.setString(1, curso.getDescripcion());
                pstmt.setDouble(2, curso.getPrecio());
                pstmt.setString(3, curso.getImagen());
                pstmt.setInt(4, curso.getIdCurso());
            }        
            pstmt.executeUpdate();            
        }
        catch(Exception e){}
        desconectar();
    }
    
    public void bajaCurso(int idCurso){
        try{
            conectar();
            pstmt = conexion.prepareStatement("UPDATE Cursos SET alta = 0 WHERE idCurso = ?");
            pstmt.setInt(1, idCurso);
            pstmt.executeUpdate();
        }
        catch(Exception e){}
        desconectar();
    }
    
}
