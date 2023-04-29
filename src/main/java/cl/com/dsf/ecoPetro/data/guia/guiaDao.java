package cl.com.dsf.ecoPetro.data.guia;

import cl.com.dsf.ecoPetro.modelo.Guia;
import java.util.List;

public interface guiaDao {
    public List<Guia> mostrarGuias();
    
    public Guia encontrarGuiaPorNroGuia(Guia g);
    
    public void agregarGuia(Guia g);
    
    public void modificarGuia(Guia g);
    
    public void eliminarGuia(Guia g);
}
