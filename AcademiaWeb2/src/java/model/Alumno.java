package model;

public class Alumno {
    
    private int idAlumno;
    private String documento;
    private String nombre;
    private String apellido;    

    public Alumno(String documento, String nombre, String apellido) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Alumno(int idAlumno, String documento, String nombre, String apellido) {
        this.idAlumno = idAlumno;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
    }    

    public int getIdAlumno() {
        return idAlumno;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
}
