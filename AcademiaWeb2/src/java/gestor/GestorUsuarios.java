package gestor;

import model.Usuario;

public class GestorUsuarios extends GestorBD {

    public GestorUsuarios(){
        super();
    }      
    
    public Usuario getUsuario(String user, String pass){
        Usuario usuario = null;
        try{
            conectar();
            pstmt = conexion.prepareStatement("SELECT * FROM Usuarios WHERE nombreUsuario = ? AND contraseña = ?");
            pstmt.setString(1, user);
            pstmt.setString(2, pass);            
            query = pstmt.executeQuery();
            if(query.next()){
                int idUsuario = query.getInt("idUsuario");
                String nombreUsuario = query.getString("nombreUsuario");
                String contraseña = query.getString("contraseña");
                usuario = new Usuario(idUsuario, nombreUsuario, contraseña);
            }
            
        }
        catch(Exception e){}
        desconectar();
                
        return usuario;
    }
    
   
    
}
