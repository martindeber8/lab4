package model;

public class Programa {
    
    private int idPrograma;
    private Alumno alumno;
    private String archivo;
    private String descripcion;    
    private int habilitado;
    private int cantidadDescargas;

    public Programa(int idPrograma, Alumno alumno, String archivo, String descripcion, int habilitado, int cantidadDescargas) {
        this.idPrograma = idPrograma;
        this.alumno = alumno;
        this.archivo = archivo;
        this.descripcion = descripcion;
        this.habilitado = habilitado;
        this.cantidadDescargas = cantidadDescargas;
    }

    public Programa(Alumno alumno, String archivo, String descripcion) {
        this.alumno = alumno;
        this.archivo = archivo;
        this.descripcion = descripcion;
    }

    public int getIdPrograma() {
        return idPrograma;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public String getArchivo() {
        return archivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public int getCantidadDescargas() {
        return cantidadDescargas;
    }
    
}
