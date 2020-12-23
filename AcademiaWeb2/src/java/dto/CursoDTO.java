package dto;

public class CursoDTO {
    
    private int idCurso;
    private String descripcion;
    private int notaPrimerParcial;
    private int notaSegundoParcial;
    private int notaFinal;

    public CursoDTO(int idCurso, String descripcion, int notaPrimerParcial, int notaSegundoParcial, int notaFinal) {
        this.idCurso = idCurso;
        this.descripcion = descripcion;
        this.notaPrimerParcial = notaPrimerParcial;
        this.notaSegundoParcial = notaSegundoParcial;
        this.notaFinal = notaFinal;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public String getDescripcion() {
        return descripcion;
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
    
    
    
}
