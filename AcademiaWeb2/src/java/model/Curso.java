package model;

public class Curso {
    
    private int idCurso;
    private String descripcion;
    private double precio;
    private String imagen;    

    public Curso(int idCurso, String descripcion, double precio, String imagen) {
        this.idCurso = idCurso;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
    }

    public Curso(String descripcion, double precio, String imagen) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
    }
    

    public int getIdCurso() {
        return idCurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }
    
    public String getImagen(){
        return imagen;
    }
}
