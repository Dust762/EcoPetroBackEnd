package cl.com.dsf.ecoPetro.data.guia;

import cl.com.dsf.ecoPetro.modelo.Dia;
import cl.com.dsf.ecoPetro.modelo.Guia;
import cl.com.dsf.ecoPetro.modelo.Mes;
import java.util.List;

public interface guiaDao {
    public List<Guia> mostrarGuias();
    
    public Guia encontrarGuiaPorNroGuia(Guia g);
    
    public void agregarGuia(Guia g);
    
    public void modificarGuia(Guia g);
    
    public void eliminarGuia(Guia g);
    
    public List<Guia> listarGuiasPorFecha(String mes);
    
    public Mes totalConsumoMensual(String mes);
    
    public List<Dia> listarConsumoSemana(String mes, String semana);
}
