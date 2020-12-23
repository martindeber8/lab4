package model;

public class Matricula {
    
    private Alumno alumno;
    private Curso curso;
    private int notaPrimerParcial;
    private int notaSegundoParcial;
    private int notaFinal;
    private double descuento;

    public Matricula(Alumno alumno, Curso curso, double descuento) {
        this.alumno = alumno;
        this.curso = curso;
        this.descuento = descuento;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public int getNotaPrimerParcial() {
        return notaPrimerParcial;
    }

    public int getNotaSegundoParcial() {
        return notaSegundoParcial;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    public double getDescuento() {
        return descuento;
    }
    
    
    
    
}
