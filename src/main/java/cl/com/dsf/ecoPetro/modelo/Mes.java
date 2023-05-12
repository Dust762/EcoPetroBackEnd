package cl.com.dsf.ecoPetro.modelo;

public class Mes {
    private String nombreMes;
    private int totalMes;

    public Mes(String nombreMes, int totalMes) {
        this.nombreMes = nombreMes;
        this.totalMes = totalMes;
    }

    public String getNombreMes() {
        return nombreMes;
    }

    public void setNombreMes(String nombreMes) {
        this.nombreMes = nombreMes;
    }

    public int getTotalMes() {
        return totalMes;
    }

    public void setTotalMes(int totalMes) {
        this.totalMes = totalMes;
    }
    
}
