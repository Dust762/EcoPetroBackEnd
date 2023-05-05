package cl.com.dsf.ecoPetro.modelo;

public class Dia {
    private String nombreDia;
    private int totalDia;

    public Dia(String nombreDia, int totalDia) {
        this.nombreDia = nombreDia;
        this.totalDia = totalDia;
    }

    public String getNombreDia() {
        return nombreDia;
    }

    public void setNombreDia(String nombreDia) {
        this.nombreDia = nombreDia;
    }

    public int getTotalDia() {
        return totalDia;
    }

    public void setTotalDia(int totalDia) {
        this.totalDia = totalDia;
    }
    
}
