package dto;

public class FacturadoCursoDTO {
    
    private int idCurso;
    private String descripcion;
    private double totalFacturado;

    public FacturadoCursoDTO(int idCurso, String descripcion, double totalFacturado) {
        this.idCurso = idCurso;
        this.descripcion = descripcion;
        this.totalFacturado = totalFacturado;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getTotalFacturado() {
        return totalFacturado;
    }
    
    
}
