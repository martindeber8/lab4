package gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class GestorBD {
    
    protected Connection conexion = null;
    protected Statement stmt = null;
    protected PreparedStatement pstmt = null;
    protected ResultSet query = null;
    private final String cadenaConexion = "jdbc:sqlserver://CLIENTE-PC\\SQLEXPRESS;databaseName=AcademiaWeb2";
    private final String usuario = "usuario";
    private final String contraseña = "usuario";        
    
    public void conectar(){
        try{            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");        
            conexion = DriverManager.getConnection(cadenaConexion, usuario, contraseña);
        }
        catch(Exception e){}
    }
    
    public void desconectar(){ // para cerrar y ahorrar recursos (se puede evitar con un try con recursos)
        try{
            if(conexion != null && !conexion.isClosed())
                conexion.close();
            if(stmt != null && !stmt.isClosed())
                stmt.close();
            if(pstmt != null && !pstmt.isClosed())
                pstmt.close();
            if(query != null && !query.isClosed())
                query.close();
        }
        catch(Exception e){}
    }   
    
}
